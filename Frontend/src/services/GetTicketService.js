import http from "../../http-common.js";

class GetTicketService {
  // Obtener lista de tickets
  getAllTickets() {
    return http.get('/tickets');
  }

  // Obtener un ticket por su ID
  getTicketById(ticketId) {
    return http.get(`/ticket/${ticketId}`);
  }

  // Crear un nuevo ticket
  createTicket(ticketData) {
    return http.post('tickets', ticketData);
  }

  // Actualizar un ticket existente
  updateTicket(ticketId, ticketData) {
    return http.put(`tickets/${ticketId}`, ticketData);
  }

  // Eliminar un ticket por su ID
  deleteTicket(ticketId) {
    return http.delete(`tickets/${ticketId}`);
  }
}

export default new GetTicketService();
