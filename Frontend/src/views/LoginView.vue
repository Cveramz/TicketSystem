
<script>
import LoginService from "../services/LoginDataService.js";
import VueCookies from 'vue-cookies';

export default {
  name: 'LoginView',
  data() {
    return {
      valid: false,
      email: '',
      password: '',
      usuario: {
        nombre: '',
        apellido: '',
        correo: '',
        rut: '',
      },
      emailrules: [
        v => !!v || 'El correo es requerido',
        v => /.+@usach\.cl$/.test(v) || 'El correo debe ser @usach.cl',
      ],
      passwordrules: [
        v => !!v || 'La contraseña es requerida',
      ],
    };
  },
  methods: {
    async submitForm() {
  if (this.validarInformacion()) {
    try {
      const response = await LoginService.login(this.email, this.password);

      if (response.status === 200) {
        // Verificar si la respuesta contiene los datos del usuario
        if (response.data && response.data.nombre && response.data.correo) {
          // Asignar los valores del usuario a las propiedades en la data
          this.usuario.nombre = response.data.nombre;
          this.usuario.apellido = response.data.apellido || '';
          this.usuario.correo = response.data.correo;
          this.usuario.rut = response.data.rut || '';
          // Guardar la información del usuario en una cookie
          VueCookies.set('usuario', JSON.stringify(this.usuario));
          // Redirigir a la página deseada después del inicio de sesión
          this.redirectToPage();
        } else {
          alert('Error al obtener los datos del usuario.');
        }
      }
    } catch (error) {
      // Manejar el error
      if (error.response && error.response.status === 401) {
        // Inicio de sesión fallido, mostrar mensaje de error
        alert('Credenciales inválidas. Revise el correo y la contraseña.');
      } else {
        // Error general, mostrar mensaje de error genérico
        alert('Error al iniciar sesión. Intente nuevamente más tarde.');
      }
    }
  }
},

    validarInformacion() {
      if (this.email.indexOf('@usach.cl') === -1 || this.password === '') {
        alert('Revise que los datos ingresados sean correctos');
        return false; // El correo es inválido
      } else {
        return true; // El correo es válido
      }
    },
    redirectToPage() {
      // Redireccionar a la página deseada
      this.$router.push('/dashboard');
    }
  }
};

</script>


<template>
  <div class="general">

    <div class="container" style="background-color: white;">

      <v-col class="zona-logo"></v-col>

      <v-col class="zona-login">
        <v-card-text class="zona-texto">
          <h4 class="register_title">Sistema de tickets: Iniciar sesión</h4>
        </v-card-text>

        <v-form ref="form" v-model="valid" lazy-validation>
          <v-text-field
            v-model="email"
            :rules="emailrules"
            label="Correo electrónico"
            required
          ></v-text-field>

          <v-text-field
            v-model="password"
            :rules="passwordrules"
            label="Contraseña"
            required
            type="password"
            @keyup.enter="submitForm"
          ></v-text-field>

          <div class="botones">

          <v-btn
            :disabled="!valid"
            color="#EA7600"
            class="mr-4 text-white"
            @click="submitForm"
          >
            Iniciar sesión
          </v-btn>

          <v-btn
            color="#EA3900"
            class="mr-4 text-white"
            @click="redirectToPage"
          >
            Entrar como invitado
          </v-btn>
        </div>

        </v-form>

        <v-card-text class="zona-texto-botones">
          <router-link to="/register">Registrarse</router-link>
          <router-link to="/ForgotPasswordView">¿Olvidó su contraseña?</router-link>
        </v-card-text>


        <v-btn
            color="#EA7600"
            class="mr-4 text-white"
            to="/TicketStatus"
          >
            Consultar estado de ticket
          </v-btn>

        

      </v-col>

    </div>

  </div>
</template>

<style>

@import '../assets/css/base-prepanel.css';

.zona-login{
  width: 50%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.zona-texto{
  width: 100%;
  height: 20vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
.register_title{
  font-size: 25px;
  font-weight: bold;
}

.zona-texto-botones{
  width: 100%;
  height: 10vh;
  display: grid;
  grid-template-columns: 1fr 1fr;
}

.botones{
  width: 100%;
  height: 10vh;
  display: flex;
  justify-content: center;
  align-items: center;
}



</style>
