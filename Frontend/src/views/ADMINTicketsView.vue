<template>
  <v-app>
    <v-navigation-drawer app v-model="drawer" temporary color="#3934049">
<v-layout column align-center>
  <v-col align="center">
    <img src="../assets/Logos/UsachS1.png" alt="" style="max-width: 100%;" />
    <v-divider></v-divider>
    <p class="headline">Bienvenido al sistema de tickets</p>
    <v-btn class="mr-4 v-btn--block mt-4" to="/admin">
      <v-icon>mdi-home</v-icon>
      Inicio
    </v-btn>

  </v-col>
</v-layout>
</v-navigation-drawer>



    <v-app-bar app color="#EA7600" class="text-white">
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>MODO ADMIN</v-toolbar-title>

      <v-spacer></v-spacer>
      <v-btn class="btn" icon="mdi-home" to="/admin"></v-btn>
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
        <v-row justify="center">
          <v-col cols="12" sm="8" md="6">
            <h1 class="headline">Tickets Existentes</h1>
            <v-divider class="my-4"></v-divider>
            <v-card v-for="ticket in tickets" :key="ticket.idTicket" class="my-4">
              <v-card-title>ID TICKET: {{ ticket.idTicket }}</v-card-title>
              <v-card-text>
                <p>Categoría: {{ ticket.categoria }}</p>
                <p>Descripción: {{ ticket.descripcion }}</p>
                <p>Consulta: {{ ticket.consulta }}</p>
                <p>Comentarios: {{ ticket.comentarios }}</p>
                <p>Estado Ticket: {{ ticket.estadoTicket }}</p>
                <p>Rut del solicitante: {{ ticket.ticketRut }}</p>
                <p>Fecha de creación: {{ formatDate(ticket.fechaCreacion) }}</p>
                <p>Ultima Actualización: {{ ticket.ultimaActualizacion }}</p>
                <p>Resolución: {{ ticket.resolucion }}</p>
                <p>Prioridad: {{ ticket.prioridad }}</p>
              </v-card-text>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-main>

  </v-app>
</template>

<script>
import VueCookies from 'vue-cookies';
import AdminModeService from "../services/AdminModeService.js";
import moment from 'moment';

export default {
  name: 'ADMINTicketsView',
  data() {
    return {
      drawer: false,
      tickets: [],
      usuario: {}, // Variable para almacenar la información del usuario
      dialog: false,
    };
  },
  mounted() {
    this.retrieveTickets();
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
  redirectTo(routeName) {
      this.$router.push({ name: routeName });
    },
    retrieveTickets() {
      AdminModeService.getAll()
        .then((response) => {
          this.tickets = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    formatDate(date) {
      if (date) {
        return moment(String(date)).format('DD/MM/YYYY hh:mm');
      }
    },
}
};
</script>
