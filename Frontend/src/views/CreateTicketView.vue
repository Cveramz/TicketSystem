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
            <h2>Crear Ticket</h2>

<!-- Título del ticket -->
<v-text-field
  v-model="titulo"
  label="Título del ticket"
  outlined
></v-text-field>

<!-- Descripción del ticket -->
<v-textarea
  v-model="descripcion"
  label="Descripción"
  outlined
  rows="5"
></v-textarea>

<!-- Botón para enviar el ticket -->
    <v-btn @click="enviarTicket" 
    color="#EA7600"
    class="mr-4 text-white">Enviar Ticket</v-btn>
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
  //Sección Crear Ticket
  data() {
    return {
      titulo: '',
      descripcion: '',
    };
  },
  methods: {
    enviarTicket() {
      //lógica para enviar el ticket
      // API
      // o guardarlos en una base de datos.
      // de ejemplo  solo mostraremos los datos en la consola:
      console.log('Título del ticket:', this.titulo);
      console.log('Descripción:', this.descripcion);
      // Luego puedes redirigir al usuario a otra página o realizar alguna acción después de enviar el ticket.
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
  