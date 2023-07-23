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
        <h2>Mis Tickets</h2>

<!-- Lista de tickets -->
<v-list>
  <v-list-item-group v-model="selectedTicketId">
    <v-list-item
      v-for="ticket in tickets"
      :key="ticket.id"
      @click="selectTicket(ticket.id)"
    >
      <v-list-item-content>
        <v-list-item-title>{{ ticket.asunto }}</v-list-item-title>
        <v-list-item-subtitle>{{ ticket.fecha }}</v-list-item-subtitle>
      </v-list-item-content>
    </v-list-item>
  </v-list-item-group>
</v-list>

<!-- Detalle del ticket seleccionado -->
<v-card v-if="selectedTicketId !== null">
  <v-card-title>{{ selectedTicket.asunto }}</v-card-title>
  <v-card-text>{{ selectedTicket.detalle }}</v-card-text>
  <!-- Botón para cerrar el detalle del ticket -->
  <v-btn @click="closeTicketDetails"
  color="#EA7600"
  class="mr-4 text-white"
  >Cerrar Detalle</v-btn>
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
//Sección Mis Tickets

data() {
    return {
      tickets: [
        {
          id: 1,
          asunto: 'Problema Ramo Fingeso',
          detalle: 'Falté a la pep 1 de Fingeso y quiero dar la prueba recuperativa pero no tengo certificado médico',
          fecha: '2023-07-20',
        },
        {
          id: 2,
          asunto: 'Gotera CEII',
          detalle: 'Hola, dentro de la oficina del CEII hay una gotera que moja toda la mesa',
          fecha: '2023-07-21',
        },
        // Agrega más tickets simulados aquí
      ],
      selectedTicketId: null,
    };
  },
  computed: {
    selectedTicket() {
      return this.tickets.find((ticket) => ticket.id === this.selectedTicketId);
    },
  },
  methods: {
    selectTicket(ticketId) {
      this.selectedTicketId = ticketId;
    },
    closeTicketDetails() {
      this.selectedTicketId = null;
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
