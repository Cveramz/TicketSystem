<template>
    <v-app>
      <v-navigation-drawer app class="drawerizq">
        <!-- Barra vertical izquierda -->
        <v-list>
          <!-- Logo del sistema ticket -->
          <v-list-item>
          <v-list-item-icon>
            <v-avatar size="64">
              <img src="favicon.png" alt="Logo" style="max-width: 100%; max-height: 100%;"/>
        </v-avatar>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>Ticket System USACH</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
  
          <!-- Opciones del menú -->
          <v-list-item-group v-model="selectedItem">
            <router-link to="/dashboard">
          <v-list-item>
            <v-list-item-icon>
              <v-icon>mdi-home</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Inicio</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </router-link>
  
        <router-link to="/mistickets">
          <v-list-item>
            <v-list-item-icon>
              <v-icon>mdi-ticket-account</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Mis Tickets</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </router-link>
  
        <router-link to="/crearticket">
          <v-list-item>
            <v-list-item-icon>
              <v-icon>mdi-new-box</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Crear Ticket</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </router-link>
  
        <router-link to="/micuenta">
          <v-list-item>
            <v-list-item-icon>
              <v-icon>mdi-account</v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>Mi Cuenta</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </router-link>
          </v-list-item-group>
        </v-list>
      </v-navigation-drawer>
  
      <v-app-bar app class>
        <!-- Barra horizontal superior -->
        <v-toolbar-title class="barrasup">Sistema de Tickets</v-toolbar-title>
  
        <!-- Barra de búsqueda -->
        <v-text-field
          v-model="search"
          hide-details
          solo-inverted
          label="Buscar tickets"
          prepend-inner-icon="mdi-magnify"
        ></v-text-field>
  
        <!--Notificaciones -->
        <v-btn icon>
          <v-icon>mdi-bell</v-icon>
        </v-btn>
      </v-app-bar>
  
  
          <!-- Contenido principal -->
          <v-main>
            <h2>Mi Cuenta</h2>

<!-- Nombre completo -->
<v-text-field
  v-model="nombreCompleto"
  label="Nombre completo"
  outlined
></v-text-field>

<!-- Teléfono -->
<v-text-field
  v-model="telefono"
  label="Teléfono"
  outlined
></v-text-field>

<!-- Correo electrónico registrado -->
<v-text-field
  v-model="correoElectronico"
  label="Correo electrónico registrado"
  outlined
></v-text-field>

<!-- Botón para actualizar datos de la cuenta -->
<v-btn @click="actualizarCuenta" 
color="#EA7600"
class="mr-4 text-white"
>Actualizar Cuenta</v-btn>
  
      </v-main>
    </v-app>
  </template>
  
  <script>
  
  
  export default {
  // Lógica del programa
  
    name: 'App',
    data() {
      return {
        selectedItem: 'Inicio',
        search: '',
      };
    },
    methods: {
      navigateTo(item) {
        this.selectedItem = item;
      },
    },
  //Sección Inicio
  data() {
    return {
      nombreCompleto: 'Leonardo Espinoza',
      telefono: '+56973711546',
      correoElectronico: 'leonardo.espinoza.o@usach.cl',
    };
  },
  methods: {
    actualizarCuenta() {
      // metodo para actualizar los datos de la cuenta
      // API para guardarlos en el servidor.
      // a ejemplo solo mostraremos los datos en la consola:
      console.log('Nombre completo:', this.nombreCompleto);
      console.log('Teléfono:', this.telefono);
      console.log('Correo electrónico registrado:', this.correoElectronico);
    },
  },
  };
  
  </script>
  
  <style>
  /* CSS */
  .barrasup{
    height: 100vh;
    width: 100vw;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .Textomain{
  
    justify-content: center;
    align-items: center;
    display: flex;
  }
  .drawerizq{
    height: 100vh;
    width: 100vw;
    background-color: #00a499;
    display: flex;
    justify-content: center;
    align-items: center;
    }
  
  </style>
  