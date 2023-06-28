<script>
export default {
  name: 'LoginView',
  data() {
    return {
      email: '',
      password: '',
      error: null
    };
  },
  methods: {
    submitForm() {
      if (this.validarCorreo()) {
        // Lógica de inicio de sesión aquí
        alert('Formulario enviado y correo válido. Procesando inicio de sesión...');
        this.$router.push('#');  // Redirigir a la vista de inicio
      } else {
      }
    },
    validarCorreo() {
      if (this.email.indexOf('@usach.cl') === -1) {
        alert('No se ha detectado su correo institucional, recuerde que debe ser @usach.cl\nIngrese nuevamente su correo de forma correcta por favor');
        return false; // El correo es inválido
      } else {
        return true; // El correo es válido
      }
    }
  }
};
</script>


<template>
    <div class="fondo" style="background: #00a499;">
      <div class="logo" style="background: url(&quot;assets/Logos/Usach%20P2.png&quot;) center / countain no-repeat;"></div>
      <div class="login">
        <div class="login__container">
          <img class="login__logo" src="../assets/Logos/Usach P1.png" alt="Logo">
          <h4 class="login__title">Bienvenido al Sistema de Tickets</h4>
          <form class="login__form" @submit.prevent="submitForm">
            <div class="login">
              <input class="login__input" type="email" placeholder="Correo Institucional" v-model="email" required>
            </div>
            <div class="login">
              <input class="login__input" type="password" placeholder="Contraseña" v-model="password" required>
            </div>
            <button class="login__button" type="submit">Entrar</button>
          </form>
          <router-link class="login__link" to="/register">Crear cuenta</router-link>
          <router-link class="login__link" to="/forgot-password">¿Olvidó su contraseña?</router-link>
        </div>
      </div>
    </div>
  </template>

<style scoped> /* CSS */</style>