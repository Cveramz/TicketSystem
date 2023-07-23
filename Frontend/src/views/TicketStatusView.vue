<template>
  <div class="general">
    <div class="container" style="background-color: white;">
      <v-col class="zona-logo"></v-col>
      <v-col class="zona-info-ticket">
        <v-card-text class="zona-texto">
          <h4 class="register_title">Sistema de tickets: Estado de Ticket</h4>
        </v-card-text>

        <div>
          <v-text-field
            v-model="searchId"
            label="ID del ticket"
            required
          ></v-text-field>
          <v-btn
            color="#EA7600"
            class="mr-4 text-white"
            @click="getTicketById"
          >
            Buscar
          </v-btn>
          
        </div>
        <!-- Información del ticket encontrado -->
        <div v-if="encontrado === 1 && ticket.resolucion === 'Abierto'">
          <v-card
            width="400"
            :title="'Estado Ticket: ' + ticket.estadoTicket"
            :subtitle="'Asunto: ' + ticket.consulta"
            :text="'Su ticket aún no ha sido resuelto.'"
          ></v-card>
        </div>
        <div v-else-if="encontrado === 1">
          <v-card
            width="400"
            :title="'Estado Ticket: ' + ticket.estadoTicket"
            :subtitle="'Asunto: ' + ticket.consulta"
            :text="'Respuesta de su ticket: ' + ticket.comentarios"
          ></v-card>
        </div>
        <div v-else-if="encontrado === 2">
          <v-card
            width="400"
            :text="'El ticket a buscar no se ha encontrado o no existe'"
          ></v-card>
        </div>
        <div v-else>
          <v-card
            width="400"
            :text="'Ingrese el ID del ticket para buscarlo.'"
          ></v-card>
      </div>
      <br>
      <v-divider class="border-opacity-40"></v-divider>
      <br>
      <v-btn
            color="#EA3900"
            class="mr-4 text-white"
            to="/"
          >
            Volver a inicio
          </v-btn>
      </v-col>
    </div>
  </div>
</template>


<script>
import GetTicketService from "../services/GetTicketService.js";

export default {
  name: "TicketStatusView",
  data() {
    return {
      searchId: "",
      ticket: {},
      encontrado: 0, // 0 = nulo, 1 = encontrado, 2 = no encontrado
    };
  },
  methods: {
    getTicketById() {
      GetTicketService.getTicketById(this.searchId)
        .then((response) => {
          // Verificar si el ticket existe en la respuesta
          if (response.data) {
            this.ticket = response.data;
            this.encontrado = 1;
          } else {
            // Ticket no encontrado
            this.ticket = {};
            this.encontrado = 2;
          }
        })
        .catch((error) => {
          this.ticket = {};
          this.encontrado = 2;
        });
    },
  },
};


</script>

<style>
@import '../assets/css/base-prepanel.css';

.zona-texto{
  width: 100%;
  height: 20vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
