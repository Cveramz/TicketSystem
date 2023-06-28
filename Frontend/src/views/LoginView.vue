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
        //mostrar en pantalla lo enviado
        alert('Correo: ' + this.email + '\nContraseña: ' + this.password);
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
    <div class="container" style="background-color: white;">
    <div class="logo">
      <img src="../assets/Logos/Usach P2.png" alt="Logo">
    </div>
    <div class="login">
      <div class="login__container">
      <div class="login">
        <div class="title"><h4 class="login__title">Bienvenido al Sistema de Tickets</h4></div>
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
        <br/>
        <router-link class="login__link" to="/forgot-password">¿Olvidó su contraseña?</router-link>
      </div>
      </div>
    </div>
  </div>
</template>

<style>
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

.logo{
  display: flex;
  justify-content: flex-start;
  width: 50%;
}

.logo img{
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  /*que sea del tamaño del padre*/
  object-fit: cover;
}

.title{
  font-family: 'inherit';
  color: black;
  font-size: 30px;
  font-weight: 600;
  text-align: center;
}

.login{
  display: flex;
  justify-content: center;
  align-items: center;
  width: 50%;
  height: 100%;
  flex-direction: column;
}

.login__container{
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
}

.login__form{
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 60%;
  flex-direction: column;
}







</style>
