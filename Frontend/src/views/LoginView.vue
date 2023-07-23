
<script>

import LoginService from "../services/LoginDataService.js";

export default {
  name: 'LoginView',
  data() {
    return {
      email: '',
      password: '',
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

    submitForm() {
      if (this.validarInformacion()) {
        // Lógica de inicio de sesión aquí
        alert('Formulario enviado y correo válido. Procesando inicio de sesión...');

        // Mostrar en pantalla lo enviado
        alert('Correo: ' + this.email + '\nContraseña: ' + this.password);
        this.redirectToPage(); // Redirigir a la vista de inicio
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
      this.$router.push('/register');
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
