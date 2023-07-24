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
        <v-toolbar-title>Sistema de Tickets: Inicio</v-toolbar-title>
  
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
      <div class="dashboard-container">
        <!-- Título "Servicios" -->
        <h1 class="dashboard-title">Servicios</h1>

        <!-- Cards -->
        <v-row>
          <!-- Mis Tickets -->
          <v-col cols="12" md="4">
            <v-card class="dashboard-card" to="/mistickets">
              <v-card-text class="dashboard-card-text">
                <v-icon size="48" class="dashboard-card-icon">mdi-ticket-account</v-icon>
                <p>Mis Tickets</p>
              </v-card-text>
            </v-card>
          </v-col>

          <!-- Crear Ticket -->
          <v-col cols="12" md="4">
            <v-card class="dashboard-card" to="/crearticket">
              <v-card-text class="dashboard-card-text">
                <v-icon size="48" class="dashboard-card-icon">mdi-new-box</v-icon>
                <p>Crear Ticket</p>
              </v-card-text>
            </v-card>
          </v-col>

          <!-- Administrar Cuentas -->
          <v-col cols="12" md="4">
            <v-card class="dashboard-card" to="/micuenta">
              <v-card-text class="dashboard-card-text">
                <v-icon size="48" class="dashboard-card-icon">mdi-account</v-icon>
                <p>Administrar Cuenta</p>
              </v-card-text>
            </v-card>
          </v-col>
        </v-row>
      </div>
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
  },
  redirectTo(routeName) {
      this.$router.push({ name: routeName });
    }
}
};
</script>

<style scoped>
.dashboard-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}

.dashboard-title {
  font-size: 32px;
  font-weight: bold;
  text-align: center;
  margin-bottom: 20px;
}

.dashboard-card {
  cursor: pointer;
  margin-bottom: 20px;
  background-color: #f0f0f0;
}

.dashboard-card-text {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.dashboard-card-icon {
  color: #ea7600;
}
</style>
