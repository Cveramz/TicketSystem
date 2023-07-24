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
      <v-toolbar-title>Sistema de Tickets: Mi Cuenta</v-toolbar-title>

      <v-spacer></v-spacer>
      <v-btn class="btn" icon="mdi-home" to="/dashboard"></v-btn>
      <v-btn>
        <v-icon>mdi-bell</v-icon>
      </v-btn>
      <v-btn>
        <v-icon>mdi-account-box</v-icon>
        Mi Cuenta
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
