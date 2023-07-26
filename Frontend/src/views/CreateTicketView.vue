<template>
  <v-app>
    <v-navigation-drawer app v-model="drawer" temporary color="#3934049">
<v-layout column align-center>
  <v-col align="center">
    <img src="../assets/Logos/UsachS1.png" alt="" style="max-width: 100%;" />
    <v-divider></v-divider>
    <p class="headline">Bienvenido al sistema de tickets</p>
    <v-btn class="mr-4 v-btn--block mt-4" to="/dashboard">
      <v-icon>mdi-home</v-icon>
      Inicio
    </v-btn>
    <v-btn class="mr-4 v-btn--block mt-4" to="/mistickets">
      <v-icon>mdi-ticket-account</v-icon>
      Mis Tickets
    </v-btn>
    <v-btn class="mr-4 v-btn--block mt-4" to="/crearticket">
      <v-icon>mdi-new-box</v-icon>
      Crear Ticket
    </v-btn>
    <v-btn class="mr-4 v-btn--block mt-4" to="micuenta">
      <v-icon>mdi-account</v-icon>
      Administrar cuenta
    </v-btn>

  </v-col>
</v-layout>
</v-navigation-drawer>



    <v-app-bar app color="#EA7600" class="text-white">
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>Sistema de Tickets: Crear Ticket</v-toolbar-title>

      <v-spacer></v-spacer>
      <v-btn class="btn" icon="mdi-home" to="/dashboard"></v-btn>
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
          <v-text-field v-model="consulta" label="Asunto" required></v-text-field>
        </v-col>
        <v-col cols="12" sm="6">
          <v-select v-model="categoria" :items="categorias" label="Categoría" required></v-select>
        </v-col>
      </v-row>

      <v-row>
        <v-col cols="12">
          <v-textarea
            v-model="descripcion"
            label="Descripción"
            required
            :counter="250"
            maxlength="250"
          ></v-textarea>
        </v-col>
      </v-row>

      <v-row>
        <v-col cols="12">
          <v-btn color="primary" @click="crearTicket">Crear Ticket</v-btn>
        </v-col>
      </v-row>
    </v-container>
    </v-main>
  </v-app>
</template>

<script>
import VueCookies from 'vue-cookies';
import CreateTicketService from '../services/CreateTicketService.js';

export default {
name: 'CreateTicketView',
data() {
  return {
    drawer: false,
    usuario: {}, // Variable para almacenar la información del usuario
    dialog: false,
    consulta: '',
    categoria: '',
    descripcion: '',
    categorias: ['Acádemico', 'Infraestructura', 'Sistema', 'Seguridad','Eventos', 'Otros'],
    estadoTicket: 'Abierto',
    ticketRut: '',
    resolucion: 'abierto',
    prioridad: 'baja',
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
async crearTicket() {
        const ticketRut = CreateTicketService.transformStringToInt(this.usuario.rut);
        
        // Crear el objeto JSON con la información del ticket
        const ticket = {
          categoria: this.categoria,
          descripcion: this.descripcion,
          consulta: this.consulta,
          comentarios: "",
          estadoTicket: "Activo",
          ticketRut: ticketRut,
          fechaCreacion: new Date().toISOString(),
          ultimaActualizacion: null,
          resolucion: "Abierto",
          prioridad: "1",
        };
        // Mostrar el objeto JSON en la consola
        console.log(ticket);
        try {
      // Llamar al servicio para enviar el ticket a la base de datos
      const response = await CreateTicketService.crearTicket(ticket);

      // Aquí puedes manejar la respuesta de la petición si es necesario
      console.log("Ticket creado:", response);

      // Limpiar los campos después de crear el ticket (opcional)
      this.consulta = "";
      this.categoria = "";
      this.descripcion = "";
    } catch (error) {
      // Manejar el error si ocurriera algún problema en la petición
      console.error("Error al crear el ticket:", error);
    }
      },
}
};
</script>