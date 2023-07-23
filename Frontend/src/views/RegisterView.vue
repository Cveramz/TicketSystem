<script>

import RegisterDataService from '../services/RegisterDataService';

export default {
  name: 'RegisterView',
  data() {
    return {
      nombres: '',
      apellidos: '',
      rut: '',
      correo: '',
      contrasena: '',
      repetirContrasena: '',
      correoRules: [
        v => !!v || 'El correo es requerido',
        v => /(.+)@(.+){2,}\.(.+){2,}/.test(v) || 'El correo no es válido',
        v => /@usach\.cl$/.test(v) || 'El correo debe ser de @usach.cl'
      ],
      nameRules: [v => !!v || 'El nombre es requerido'],
      passwordRules: [
        v => !!v || 'La contraseña es requerida',
        v => (v && v.length >= 8) || 'La contraseña debe tener al menos 8 caracteres'
      ],
      repetirContrasenaRules: [
        v => !!v || 'La contraseña es requerida',
        v => (v && v.length >= 8) || 'La contraseña debe tener al menos 8 caracteres',
        v => v === this.contrasena || 'Las contraseñas no coinciden'
      ],
      rutRules: [v => !!v || 'El RUT es requerido', v => this.validarRut(v) || 'RUT inválido'],
      valid: false // Inicializamos el estado de validación del formulario como falso
    };
  },
  methods: {
    validarRut(rut) {
      // Aquí implementamos la lógica para validar el formato del RUT chileno
      if (!rut || typeof rut !== 'string') return false;
      const regex = /^(\d{1,3}(?:\.\d{1,3}){2})-(\d|k|K)$/;
      return regex.test(rut.trim());
    },
    submitForm() {
  console.log('Enviando formulario...');
  console.log('Estado de validación antes de validar:', this.valid);
  this.$refs.form.validate(valid => {
    console.log('Estado de validación después de validar:', valid);
  });

  alert('Formulario enviado y correo válido. Procesando registro...');
  alert('Contenido a enviar:');
  alert('Nombres: ' + this.nombres + '\nApellidos: ' + this.apellidos + '\nRUT: ' + this.rut + '\nCorreo: ' + this.correo + '\nContraseña: ' + this.contrasena + '\nRepetir contraseña: ' + this.repetirContrasena);
},
    // ... ( función enviarFormulario actual) ...
  }
};



</script>


<template>
  <div class="general">
    <div class="container" style="background-color: white;">
      <v-col class="zona-logo"></v-col>
      <v-col class="zona-registro">
        <v-card-text class="zona-texto">
          <h4 class="register_title">Sistema de tickets: Registro</h4>
        </v-card-text>

        <v-card class="formulario-registro">
          <v-form ref="form" v-model="valid" lazy-validation>
            <v-row>
              <v-col cols="12" md="6">
                <v-text-field
                  v-model="nombres"
                  :rules="nameRules"
                  label="Nombres"
                  required
                ></v-text-field>
              </v-col>
              <v-col cols="12" md="6">
                <v-text-field
                  v-model="apellidos"
                  :rules="nameRules"
                  label="Apellidos"
                  required
                ></v-text-field>
              </v-col>
            </v-row>

            <v-row>
              <v-col cols="12" md="6">
                <v-text-field
                  v-model="rut"
                  :rules="rutRules"
                  label="RUT"
                  required
                ></v-text-field>
              </v-col>
              <v-col cols="12" md="6">
                <v-text-field
                  v-model="correo"
                  :rules="correoRules"
                  label="Correo"
                  required
                ></v-text-field>
              </v-col>
            </v-row>

            <v-row>
              <v-col cols="12" md="6">
                <v-text-field
                  v-model="contrasena"
                  :rules="passwordRules"
                  label="Contraseña"
                  required
                  type="password"
                ></v-text-field>
              </v-col>
              <v-col cols="12" md="6">
                <v-text-field
                  v-model="repetirContrasena"
                  :rules="repetirContrasenaRules"
                  label="Repetir contraseña"
                  required
                  type="password"
                ></v-text-field>
              </v-col>
            </v-row>
            <div class="botones-registro">
              <v-btn class="btn text-white" :disabled="!valid" color="#EA7600" @click="submitForm">
                Registrarse
              </v-btn>
              <v-btn
              color="#394049"
              class="btn text-white"
              to="/login"
            >
              Iniciar Sesión
            </v-btn>
          </div>
          </v-form>
        </v-card>
      </v-col>
    </div>
  </div>
</template>


<style>
@import '../assets/css/base-prepanel.css';


.botones-registro{
  display: flex;
  justify-content: space-between;
  flex-direction: column;
  margin-top: 20px;
}

.botones-registro .btn{
  width: 100%;
  margin-bottom: 10px;
}

</style>
