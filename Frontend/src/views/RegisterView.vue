<script>
export default {
  name: 'RegisterView',
  data() {
    return {
      nombres: '',
      apellidos: '',
      correo: '',
      contrasena: '',
      repetirContrasena: '',
      correoRules: [
        v => !!v || 'El correo es requerido',
        v => /(.+)@(.+){2,}\.(.+){2,}/.test(v) || 'El correo no es válido',
        v => /@usach\.cl$/.test(v) || 'El correo debe ser de @usach.cl'
      ]
    };
  },
  methods: {
    submitForm() {
        // Lógica de inicio de sesión aquí
        alert('Formulario enviado y correo válido. Procesando inicio de sesión...');
        //mostrar en pantalla lo enviado
        alert('Correo: ' + this.email + '\nContraseña: ' + this.password);
        this.$router.push('/login');  // Redirigir a la vista de inicio
    },
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
        <div class="login_container">
          <div class="title">
            <h4 class="register_title">Sistema de Tickets:<br />Creación de cuenta</h4>
          </div>
          <form class="register__form" @submit.prevent="submitForm">
            <v-card class="register__card">
              <v-card-text>
                <v-text-field class="register__input" label="Nombres" v-model="nombres" required></v-text-field>

                <v-text-field class="register__input" label="Apellidos" v-model="apellidos" required></v-text-field>

                <v-text-field class="register__input" type="email" label="Correo" v-model="correo" :rules="correoRules"
                  required></v-text-field>

                <v-text-field class="register__input" type="password" label="Contraseña" v-model="contrasena"
                  required></v-text-field>

                <v-text-field class="register__input" type="password" label="Repetir Contraseña"
                  v-model="repetirContrasena" :rules="[v => v === contrasena || 'Las contraseñas no coinciden']"
                  required></v-text-field>
              </v-card-text>

              <v-card-actions class="register__button">
                <v-btn class="register" color="#ffffff" dark rounded @click="submitForm">Registrarse</v-btn>
                <router-link class="login__link" to="/">Iniciar sesión</router-link>
              </v-card-actions>
            </v-card>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
@import url('https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap');



.container {
  width: 80%;
  height: 85vh;
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
  font-weight: 500;
  justify-content: center;
}


.login_container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  flex-direction: column;
}


.register__form {
  display: flex;
  flex-direction: column;
  justify-content: center;
  width: 90%;
  height: 80%;
}

.register__input{
  margin-bottom: 15px;
  height: 50px;
}


.register__button{
  display: flex;
  flex-direction: column;
}

.register{
  background-color: #EA7600;
  width: 80%;
}

</style>
