<script>

import LoginService from "../services/LoginDataService.js";

export default {
  name: 'LoginView',
  data() {
    return {
      email: '',
      password: '',
      recordarUsuario: false,
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
        if (this.recordarUsuario) {
        // Calcular fecha de expiración en 1 día
        const expirationDate = new Date();
        expirationDate.setDate(expirationDate.getDate() + 1);
        // Establecer cookie con el nombre de usuario y fecha de expiración
        document.cookie = `usuario=${this.email}; expires=${expirationDate.toUTCString()}; path=/`;
      }

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
  <div class="container" style="background-color: white;">
    <div class="logo">
      <img src="../assets/Logos/UsachP2.png" alt="Logo">
    </div>
    <div class="login">
      <div class="login__container">
        <div class="login">
          <div class="title">
            <h4 class="login__title">Bienvenido al Sistema de Tickets</h4>
          </div>
          <form class="login__form" @submit.prevent="submitForm">
            <v-card class="login__card">
              <v-card-text>
                <v-text-field class="login__input" type="email" label="Correo Institucional" v-model="email"
  :rules="emailrules" required autocomplete="email"></v-text-field>

  <v-text-field class="login__input" type="password" label="Contraseña" v-model="password"
  :rules="passwordrules" required autocomplete="current-password"></v-text-field>
              </v-card-text>

              <v-checkbox v-model="recordarUsuario" label="Recordar usuario" color="red" value="red" class="checkbox"></v-checkbox>
              <v-card-actions class="sesionboton">
                <v-btn color="#ffffff" dark rounded @click="submitForm">Iniciar sesión</v-btn>
              </v-card-actions>


              <v-card-actions class="invitadoboton">
                <v-btn color="#ffffff" dark rounded>Iniciar como invitado</v-btn>
              </v-card-actions>
            </v-card>
      


          </form>
          <router-link class="login__link" to="/register">Crear cuenta</router-link>
          <router-link class="login__link" to="/forgot-password">¿Olvidó su contraseña?</router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
@import url('https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap');


body {
  background: #00a499;
}

.container {
  width: 80%;
  height: 80vh;
  display: flex;
  justify-content: space-between;
  align-items: center;
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  border-radius: 20px;
}

.logo {
  display: flex;
  justify-content: flex-start;
  width: 50%;
}

.logo img {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  /*que sea del tamaño del padre*/
  object-fit: cover;
}

.title {
  font-family: 'Nunito', sans-serif;
  color: black;
  font-size: 30px;
  font-weight: 600;
  text-align: center;
}

.login {
  
  display: flex;
  justify-content: center;
  align-items: center;
  width: 50%;
  height: 100%;
  flex-direction: column;
}

.login__container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
}

.login__form {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 140%;
  height: 55%;
  margin-top: 10%;

}

.login__card {
  max-width: 400px;
  width: 100%;
}

.sesionboton {
  background-color: #EA7600;
  display: flex;
  justify-content: center;
}

.invitadoboton {
  background-color: #EA3800;
  display: flex;
  justify-content: center;
}

.checkbox{
  height: 12%;
}



</style>
