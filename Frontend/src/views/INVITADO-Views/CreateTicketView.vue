<template>
  <v-app>
    <v-navigation-drawer app v-model="drawer" temporary color="#3934049">
<v-layout column align-center>
  <v-col align="center">
    <img src="../../assets/Logos/UsachS1.png" alt="" style="max-width: 100%;" />
    <v-divider></v-divider>
    <p class="headline">Bienvenido al sistema de tickets</p>
    <v-btn class="mr-4 v-btn--block mt-4" to="/invitado">
      <v-icon>mdi-home</v-icon>
      Inicio
    </v-btn>
    <br /><br /><br /><br /><br /><br />
    <p class="headline">Para una mejor experiencia inicie sesión.</p>

  </v-col>
</v-layout>
</v-navigation-drawer>



    <v-app-bar app color="#EA7600" class="text-white">
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>Sistema de Tickets: Crear ticket como invitado</v-toolbar-title>

      <v-spacer></v-spacer>
      <v-btn to="/login">
        <v-icon>mdi-account-box</v-icon>
        Iniciar sesión
      </v-btn>
    </v-app-bar>

    <v-main>
      <v-container>
        <v-form ref="form" v-model="valid" lazy-validation>
        <h1 class="dashboard-title">Complete los siguientes campos:</h1> <br />
        <v-row>
        <v-col cols="12" sm="6">
          <v-text-field v-model="ticketRut" label="Ingrese su rut (sin puntos ni guiones)" required :rules="ticketRutRules"></v-text-field>
        </v-col>
      </v-row>
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
          <v-btn color="primary" @click="crearTicket" :disabled="!valid">Crear Ticket</v-btn>
        </v-col>
      </v-row>
    </v-form>
    </v-container>
    </v-main>
  </v-app>
</template>

<script>
import VueCookies from 'vue-cookies';
import CreateTicketService from '../../services/CreateTicketService.js';

export default {
name: 'CreateTicketView',
data() {
  return {
    drawer: false,
    usuario: {}, // Variable para almacenar la información del usuario
    valid: false,
    consulta: '',
    categoria: '',
    descripcion: '',
    categorias: ['Acádemico', 'Infraestructura', 'Sistema', 'Seguridad','Eventos', 'Otros'],
    estadoTicket: 'Abierto',
    ticketRut: '',
    resolucion: 'abierto',
    prioridad: 'baja',
    ticketRutRules: //no puede tener ni puntos ni guiones
      [
        v => !!v || 'El rut es requerido',
        v => /^[0-9]+$/.test(v) || 'El rut solo puede contener números',
        v => v.length >= 8 || 'El rut debe ser válido',
        v => v.length <= 9 || 'El rut debe ser válido',
      ],
  };
},
mounted() {
    // Leer la cookie al cargar el componente
    const usuarioCookie = VueCookies.get('usuario');
    if (usuarioCookie) {
      VueCookies.remove('usuario'); // Eliminar la cookie
    }
  },
methods: {
cerrarSesion() {
  // Eliminar la cookie del usuario u otra acción necesaria al cerrar sesión
  VueCookies.remove('usuario'); // Por ejemplo, eliminar la cookie del usuario
  this.$router.push('/login'); // Redirigir a la vista de cerrar sesión
},
async crearTicket() {
        // Crear el objeto JSON con la información del ticket
        const ticket = {
          categoria: this.categoria,
          descripcion: this.descripcion,
          consulta: this.consulta,
          comentarios: "",
          estadoTicket: "Activo",
          ticketRut: this.ticketRut,
          fechaCreacion: new Date().toISOString(),
          ultimaActualizacion: null,
          resolucion: "Abierto",
          prioridad: "1",
        };
        try {
      // Llamar al servicio para enviar el ticket a la base de datos
      const response = await CreateTicketService.crearTicket(ticket);


      // Limpiar los campos después de crear el ticket (opcional)
      this.consulta = "";
      this.categoria = "";
      this.descripcion = "";
      alert("Ticket creado con éxito, su número de ticket es: " + response.idTicket + "/n" + "Puede consultar el estado de su ticket en la pantalla inicial.");
      //enviar al inicio de sesión
      this.$router.push('/');
    } catch (error) {
      // Manejar el error si ocurriera algún problema en la petición
      console.error("Error al crear el ticket:", error);
    }
      },
}
};
</script>