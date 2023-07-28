<template>
  <v-app>
    <v-navigation-drawer app v-model="drawer" temporary color="#3934049">
<v-layout column align-center>
  <v-col align="center">
    <img src="../../assets/Logos/UsachS1.png" alt="" style="max-width: 100%;" />
    <v-divider></v-divider>
    <p class="headline">Bienvenido al sistema de tickets</p>
    <v-btn class="mr-4 v-btn--block mt-4" to="/analista">
      <v-icon>mdi-home</v-icon>
      Inicio
    </v-btn>

  </v-col>
</v-layout>
</v-navigation-drawer>



    <v-app-bar app color="#394049" class="text-white">
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>MODO ANALISTA</v-toolbar-title>

      <v-spacer></v-spacer>
      <v-btn class="btn" icon="mdi-home" to="/analista"></v-btn>
      <v-btn>
        <v-icon>mdi-bell</v-icon>
      </v-btn>
      <v-btn @click="dialog  = true">
        <v-icon>mdi-account-box</v-icon>
        {{ usuario.nombre}} {{ usuario.apellido}}
      </v-btn>
    </v-app-bar>
    <v-dialog v-model="dialog" max-width="400">
<v-card class="position-relative">
  <v-btn icon @click="dialog = false" class="ml-auto mr-4">
<v-icon>mdi-close</v-icon>
</v-btn>

  <v-card-title class="headline">Perfil de Usuario</v-card-title>
  <v-card-text>
    <p>Nombre: {{ usuario.nombre }}</p>
    <p>Correo: {{ usuario.correo }}</p>
  </v-card-text>
  <v-card-actions class="justify-space-between">
    <!-- Botón para cerrar sesión -->
    <v-btn color="#EA3900" @click="cerrarSesion">Cerrar Sesión</v-btn>
  </v-card-actions>
</v-card>
</v-dialog>


<v-main>
      <v-container>
      <v-row>
        <v-col cols="12" sm="6">
          <v-text-field v-model="idTicket" label="ID Ticket" required></v-text-field>
          <v-btn color="primary" @click="getTicketById">Obtener Información de ticket</v-btn>
        </v-col>
        <v-col cols="12" sm="6">
          <!-- Mostrar contenido del ticket -->
          <v-card v-if="encontrado == 1" class="mt-4">
            <v-card-title>
              <h2 class="headline mb-0">Ticket: {{ ticket.idTicket }}</h2>
            </v-card-title>
            <v-card-text>
              <p class="text--primary">Categoria: {{ ticket.categoria }}</p>
              <p class="text--primary">Descripción: {{ ticket.descripcion }}</p>
              <p class="text--primary">Estado: {{ ticket.estadoTicket }}</p>
              <p class="text--primary">Prioridad: {{ ticket.prioridad }}</p>
              <p class="text--primary">Resolución: {{ ticket.resolucion }}</p>
              <p class="text--primary">Fecha de creación: {{ formatDate(ticket.fechaCreacion) }}</p>
              <p class="text--primary">Última actualización: {{ formatDate(ticket.ultimaActualizacion) }}</p>
              <p class="text--primary">Comentarios: {{ ticket.comentarios }}</p>
              <p class="text--primary">Rut: {{ ticket.ticketRut }}</p>
            </v-card-text>
          </v-card>
          <!-- Ticket no encontrado -->
          <v-alert v-if="encontrado == 2" type="error" class="mt-4">
            <p class="text--primary">Ticket no encontrado</p>
          </v-alert>
          <!-- Error al buscar el ticket -->
          <v-alert v-if="encontrado == 3" type="error" class="mt-4">
            <p class="text--primary">Error al buscar el ticket</p>
          </v-alert>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="12">
        </v-col>
      </v-row>

      <v-row>
          <v-textarea
            v-model="respuesta"
            label="Respuesta a ticket"
            required
            :counter="250"
            maxlength="250"
          ></v-textarea>
      </v-row>

      <v-row>
        <v-col cols="12">
          <v-btn color="primary" @click="editarTicket">Enviar Respuesta</v-btn>
        </v-col>
      </v-row>
    </v-container>
    </v-main>
  </v-app>
</template>


<script>
import VueCookies from 'vue-cookies';
import GetTicketService from "../../services/GetTicketService";
import AdminModeService from "../../services/AdminModeService";
import moment from 'moment';

export default {
name: 'AdminReplyTicket',
data() {
  return {
    drawer: false,
    usuario: {}, // Variable para almacenar la información del usuario
    dialog: false,
    valid: false,
    idTicket: null,
    ticket: {},
    encontrado: 0,
    respuesta: null,
    counter: 250,

  };
},
mounted() {
    // Leer la cookie al cargar el componente
    const usuarioCookie = VueCookies.get('usuario');
    if (usuarioCookie) {
      // Si la cookie existe, asignar el valor a la variable usuario
      this.usuario = usuarioCookie;
    } else {
      // Si la cookie no existe, redirigir al login
      this.$router.push('/login');
    }
  },
methods: {
cerrarSesion() {
  // Eliminar la cookie del usuario u otra acción necesaria al cerrar sesión
  VueCookies.remove('usuario'); // Por ejemplo, eliminar la cookie del usuario
  this.$router.push('/login'); // Redirigir a la vista de cerrar sesión
},
getTicketById() {
      GetTicketService.getTicketById(this.idTicket)
        .then((response) => {
          // Verificar si el ticket existe en la respuesta
          if (response.data) {
            this.ticket = response.data;
            this.encontrado = 1;
          } else {
            // Ticket no encontrado
            this.ticket = {};
            this.encontrado = 2;
          }
        })
        .catch((error) => {
          this.ticket = {};
          this.encontrado = 3;
        });
    },

    async editarTicket() {
      const formattedDate = formatDateToCustomString(new Date().toISOString());
  // Verificar si hay un ticket válido antes de continuar
  if (!this.ticket || !this.ticket.idTicket) {
    console.error("No se ha encontrado un ticket válido.");
    return;
  }

  // Crear el objeto JSON con la información del ticket para actualizarlo
  const ticketActualizado = {
    idTicket: this.ticket.idTicket,
    categoria: this.ticket.categoria,
    descripcion: this.ticket.descripcion,
    consulta: this.ticket.consulta,
    comentarios: this.respuesta,
    estadoTicket: "Cerrado",
    ticketRut: this.ticket.ticketRut,
    fechaCreacion: this.ticket.fechaCreacion,
    ultimaActualizacion: formattedDate,
    resolucion: "Cerrado",
    prioridad: this.ticket.prioridad,
  };

  // Mostrar el objeto JSON en la consola
  console.log(ticketActualizado);

  try {
    // Llamar al servicio para enviar la solicitud PUT y actualizar el ticket en la base de datos
    const response = await AdminModeService.editTicket(ticketActualizado);

    // Limpiar los campos después de editar el ticket (opcional)
    this.respuesta = "";

    // Aquí puedes agregar cualquier lógica adicional que necesites después de editar el ticket

  } catch (error) {
    // Manejar el error si ocurriera algún problema en la petición
    console.error("Error al editar el ticket:", error);
  }
},
formatDate(date) {
      if (date) {
        return moment(String(date)).format('DD/MM/YYYY hh:mm');
      }
    },

}
};
</script>