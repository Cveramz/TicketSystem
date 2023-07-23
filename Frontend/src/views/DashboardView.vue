<template>
  <v-app>
    <v-navigation-drawer app class="drawerizq">
      <!-- Barra vertical izquierda -->
      <v-list>
        <!-- Logo del sistema ticket -->
        <v-list-item>
          <v-list-item-icon>
            <v-icon>mdi-ticket</v-icon>
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
          <h1 class="Textomain">Avisos</h1>

<!-- Lista de avisos -->
<v-card v-for="aviso in avisos" :key="aviso.id" class="avisos">
  <v-card-title>{{ aviso.titulo }}</v-card-title>
  <v-card-text>{{ aviso.contenido }}</v-card-text>
</v-card>


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
      avisos: [
        {
          id: 1,
          titulo: '¡Bienvenido al sistema de tickets!',
          contenido: 'Puedes configurar los datos de tu cuenta en la sección "Mi Cuenta"',
        },
        {
          id: 2,
          titulo: 'Aviso 2',
          contenido: 'Contenido del aviso 2',
        },
      ],
    };
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
