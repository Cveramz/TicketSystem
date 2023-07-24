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
    <v-btn color="#EA3900" class="mr-4 v-btn--block mt-4" @click="cerrarSesion">
      <v-icon>mdi-account</v-icon>
      Cerrar Sesión
    </v-btn>

  </v-col>
</v-layout>
</v-navigation-drawer>



    <v-app-bar app color="#EA7600" class="text-white">
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>Sistema de Tickets: Crear ticket</v-toolbar-title>

      <v-spacer></v-spacer>
      <v-btn class="btn" icon="mdi-home" to="/dashboard"></v-btn>
      <v-btn>
        <v-icon>mdi-bell</v-icon>
      </v-btn>
      <v-btn>
        <v-icon>mdi-account-box</v-icon>
        {{ usuario.nombre}} {{ usuario.apellido}}
      </v-btn>
      
    </v-app-bar>

    <v-main>
      <!-- Contenido principal de la aplicación -->
      <!-- Aquí deberías colocar el resto de tu contenido de la página -->
    </v-main>
  </v-app>
</template>

<script>
import VueCookies from 'vue-cookies';

export default {
name: 'DashboardView',
data() {
  return {
    drawer: false,
    usuario: {}, // Variable para almacenar la información del usuario
  };
},
mounted() {
  // Leer la cookie al cargar el componente
  const usuarioCookie = VueCookies.get('usuario');
  if (usuarioCookie) {
    // Si la cookie existe, asignar el valor a la variable usuario
    this.usuario = usuarioCookie;
    //mostrar en pantalla nombre,correo y rut
    console.log(this.usuario.nombre);
    console.log(this.usuario.correo);
    console.log(this.usuario.rut);
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
}
}
};
</script>