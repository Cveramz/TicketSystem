<script>
export default {
  mounted() {
    // Utilizamos setTimeout para redireccionar después de 5 segundos
    setTimeout(() => {
      this.redirectToHome();
    }, 10000);
  },
  methods: {
    redirectToHome() {
      // Redireccionar a la página de inicio (ruta /)
      this.$router.push('/');
    },
  },
};
</script>


<template>
  <div class="general">

    <div class="container" style="background-color: white;">

      <v-col class="zona-logo">

      </v-col>

      <v-card-text class="zona-texto-not-found">
        <h4 class="register_title">ERROR 404: La página solicitada no se ha podido encontrar.
          Serás redireccionado a la página inicial.
        </h4>
      </v-card-text>

    </div>

  </div>
</template>

<style>
@import '../assets/css/base-prepanel.css';

.zona-texto-not-found{
  width: 10%;
  font-size: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

</style>
