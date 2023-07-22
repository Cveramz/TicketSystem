<script>
</script>


<template>
  <div class="general">
    <div class="container" style="background-color: white;">
      <div class="logo">
        <img src="../assets/Logos/UsachP2.png" alt="Logo">
      </div>
      <div class="login">
        <div class="login__container">
          <div class="login_container">
            <div class="title">
              <h4 class="register_title">ERROR 404: La página solicitada no se ha podido encontrar.</h4>

            </div>
            
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
@import '../assets/css/base-prepanel.css';



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
  font-size: 40px;
  font-weight: 500;
  justify-content: center;
  margin: 20;
}


</style>
