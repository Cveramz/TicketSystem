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
        <v-row>
  <v-col cols="12" sm="6">
    <v-text-field v-model="idUsuario" label="ID Usuario" required></v-text-field>
    <v-btn color="primary" @click="getUserById(idUsuario)">Buscar</v-btn>
  </v-col>
  <v-col cols="12" sm="6">
    <!-- Mostrar contenido del usuario -->
    <v-card v-if="encontrado === 1" class="mt-4">
      <v-card-title>
        <h2 class="headline mb-0">Información de usuario</h2>
      </v-card-title>
      <v-card-text>
        <p>Nombre: {{ usuarion ? usuarion.nombre : 'Usuario no encontrado' }}</p>
        <p>Apellido: {{ usuarion ? usuarion.apellido : 'Usuario no encontrado' }}</p>
        <p>Correo: {{ usuarion ? usuarion.correo : 'Usuario no encontrado' }}</p>
        <p>Tipo de usuario: {{ usuarion ? (usuarion.tipo ? usuarion.tipo : 'No definido') : 'Usuario no encontrado' }}</p>
      </v-card-text>
    </v-card>
    <!-- Usuario no encontrado -->
    <v-alert v-if="encontrado === 2" type="error" class="mt-4">
      <p class="text--primary">Usuario no encontrado</p>
    </v-alert>
    <!-- Error al buscar el usuario -->
    <v-alert v-if="encontrado === 3" type="error" class="mt-4">
      <p class="text--primary">Error al buscar el usuario</p>
    </v-alert>
  </v-col>
</v-row>

<v-row v-if="encontrado === 1">
      <v-col cols="12" sm="6">
        <v-text-field v-model="nuevoNombre" label="Nuevo nombre" required></v-text-field>
      </v-col>
      <v-col cols="12" sm="6">
        <v-text-field v-model="nuevoApellido" label="Nuevo apellido" required></v-text-field>
      </v-col>
    </v-row>
    <v-row v-if="encontrado === 1">
      <v-col cols="12" sm="6">
        <v-text-field v-model="nuevoCorreo" label="Nuevo correo" required></v-text-field>
      </v-col>
      <v-col cols="12" sm="6">
        <!-- Utilizar v-select para el tipo de usuario -->
        <v-select
          v-model="nuevoTipo"
          :items="['Super Administrador', 'Administrador', 'Analista', 'Usuario']"
          label="Nuevo tipo de usuario"
          required
        ></v-select>
      </v-col>
    </v-row>
    <v-row v-if="encontrado === 1">
      <v-col cols="12">
        <v-text-field v-model="nuevoContrasena" label="Nueva contraseña" required></v-text-field>
      </v-col>
    </v-row>

    <!-- Botón para actualizar información -->
    <v-row v-if="encontrado === 1">
      <v-col cols="12">
        <v-btn color="primary" @click="actualizarUsuario(usuarion.idUsuario)">Actualizar</v-btn>
      </v-col>
    </v-row>
  </v-container>
    </v-main>
  </v-app>
</template>


<script>
import VueCookies from 'vue-cookies';
import AdminModeService from "../../services/AdminModeService";

export default {
  name: 'AdminActualizarUsuario',
  data() {
    return {
      drawer: false,
      usuario: {},
      usuarion: {}, // Variable para almacenar la información del usuario
      dialog: false,
      idUsuario: null,
      encontrado: 0,
      nuevoContrasena: null,
      nuevotipo: null,
      counter: 250,
      nuevoNombre: '', // Nuevo campo para almacenar el nombre actualizado
      nuevoApellido: '', // Nuevo campo para almacenar el apellido actualizado
      nuevoCorreo: '', // Nuevo campo para almacenar el correo actualizado
      nuevoTipo: '', // Nuevo campo para almacenar el tipo de usuario actualizado
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

    getUserById(idUsuario) {
      AdminModeService.getUserById(idUsuario)
        .then((response) => {
          const usuario = response.data;
          if (usuario) {
            this.usuarion = usuario;
            this.encontrado = 1;
          } else {
            this.usuarion = {};
            this.encontrado = 2;
          }
        })
        .catch((error) => {
          console.error("Error al obtener el usuario:", error);
          this.usuarion = {};
          this.encontrado = 3;
        });
    },
    async actualizarUsuario() {
  const usuarioActualizado = {
    idUsuario: this.usuarion.idUsuario,
    nombre: this.nuevoNombre,
    apellido: this.nuevoApellido,
    correo: this.nuevoCorreo,
    tipo: this.nuevoTipo,
    password: this.nuevoContrasena, // Utilizamos nuevoContrasena correctamente
  };

    try {
      // Llamar al servicio para enviar la solicitud PUT y actualizar el usuario en la base de datos
      const response = await AdminModeService.actualizarUsuario(usuarioActualizado);

      // Limpiar los campos después de actualizar el usuario (opcional)
      this.nuevoNombre = '';
      this.nuevoApellido = '';
      this.nuevoCorreo = '';
      this.nuevoTipo = '';
      this.nuevoContrasena = ''; // Corregimos el nombre del campo

      // Mostrar alguna notificación o mensaje de éxito (opcional)
      alert('Usuario actualizado correctamente');

    } catch (error) {
      // Manejar el error si ocurriera algún problema en la petición
      console.error('Error al actualizar el usuario:', error);
    }
  },
}    

};
</script>
