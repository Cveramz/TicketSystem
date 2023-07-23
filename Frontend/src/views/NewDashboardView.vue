<template>
    <v-app>
      <v-navigation-drawer app v-model="drawer" temporary>
        <h3>Menú vertical</h3>
      </v-navigation-drawer>
  
      <v-app-bar app color="#EA7600" class="text-white">
        <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
        <v-toolbar-title>Sistema de Tickets</v-toolbar-title>
  
        <v-spacer></v-spacer>
        <v-btn>
          <v-icon>mdi-home</v-icon>
          Inicio
        </v-btn>
        <v-btn>
          <v-icon>mdi-ticket-account</v-icon>
          Mis Tickets
        </v-btn>
        <v-btn>
          <v-icon>mdi-new-box</v-icon>
          Crear Ticket
        </v-btn>
        <v-btn>
          <v-icon>mdi-account</v-icon>
          Mi Cuenta
        </v-btn>
        <v-btn>
          <v-icon>mdi-bell</v-icon>
        </v-btn>
      </v-app-bar>
  
      <v-main>
        <!-- Contenido principal de la aplicación -->
        <!-- Aquí deberías colocar el resto de tu contenido de la página -->
      </v-main>
    </v-app>
  </template>
  
  <script>
  export default {
    name: "App",
    data() {
      return {
        drawer: false,
      };
    },
  };
  </script>
  