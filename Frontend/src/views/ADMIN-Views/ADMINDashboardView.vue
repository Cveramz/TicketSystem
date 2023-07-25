<template>
    <v-app>
      <v-navigation-drawer app v-model="drawer" temporary color="#3934049">
  <v-layout column align-center>
    <v-col align="center">
      <img src="../../assets/Logos/UsachS1.png" alt="" style="max-width: 100%;" />
      <v-divider></v-divider>
      <p class="headline">Bienvenido al sistema de tickets</p>
      <v-btn class="mr-4 v-btn--block mt-4" to="/admin">
        <v-icon>mdi-home</v-icon>
        Inicio
      </v-btn>

    </v-col>
  </v-layout>
</v-navigation-drawer>


  
      <v-app-bar app color="#00a499" class="text-white">
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
      <div class="dashboard-container">
        <!-- Título "Servicios" -->
        <h1 class="dashboard-title">Servicios</h1>

        <!-- Cards -->
        <v-row>
          <!-- Mis Tickets -->
          <v-col cols="12" md="4">
            <v-card class="dashboard-card" to="/admin/tickets">
              <v-card-text class="dashboard-card-text">
                <v-icon size="48" class="dashboard-card-icon">mdi-ticket-account</v-icon>
                <p>Todos los tickets</p>
              </v-card-text>
            </v-card>
          </v-col>

          <!-- Crear Ticket -->
          <v-col cols="12" md="4">
            <v-card class="dashboard-card" to="/crearticket">
              <v-card-text class="dashboard-card-text">
                <v-icon size="48" class="dashboard-card-icon">mdi-ticket-confirmation</v-icon>
                <p>Responder ticket</p>
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
      dialog: false,
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
  color: #00a499;
}
</style>
