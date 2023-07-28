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
      <v-container>
        <v-row justify="center">
          <v-col cols="12" sm="8" md="6">
            <h1 class="headline">Cuentas Existentes</h1>
            <v-divider class="my-4"></v-divider>
            <v-card v-for="usuario in cuentas" :key="usuario.idUsuario" class="my-4">
              <v-card-title>ID Usuario: {{ usuario.idUsuario }}</v-card-title>
              <v-card-text>
                <p>Nombre: {{ usuario.nombre }}</p>
                <p>Apellido: {{ usuario.apellido }}</p>
                <p>Correo: {{ usuario.correo }}</p>
                <p>Rut: {{ usuario.rut }}</p>
                <p>Tipo: {{ usuario.tipo }}</p>
              </v-card-text>
              <v-btn color="#EA3900" @click="deleteUser(usuario)">Eliminar</v-btn>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-main>

  </v-app>
</template>

<script>
import VueCookies from 'vue-cookies';
import AdminModeService from "../../services/AdminModeService.js";
import moment from 'moment';

export default {
  name: 'ADMINCuentasView',
  data() {
    return {
      drawer: false,
      cuentas: [],
      usuario: {}, // Variable para almacenar la información del usuario
      dialog: false,
    };
  },
  mounted() {
    this.retrieveCuentas();
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
    retrieveCuentas() {
      AdminModeService.getAllUsers()
        .then((response) => {
          this.cuentas = response.data;
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
    async deleteUser(usuario) {
  try {
    const response = await AdminModeService.deleteUser(usuario.correo);
    console.log(response.data);
    this.retrieveCuentas();
    alert("Usuario eliminado");
  } catch (e) {
    console.log(e);
    alert("Error al eliminar usuario");
  }
},

}
};
</script>
