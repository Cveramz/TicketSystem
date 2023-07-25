import http from "../../http-common.js";

class CreateTicketService {
    transformStringToInt(inputString) {
        let numericString = inputString.replace(/[^0-9]/g, '');
        let result = parseInt(numericString, 10);
        return result;
    }
    async crearTicket(ticket) {
        try {
          const response = await http.post("/ticket", ticket);
          return response.data;
        } catch (error) {
          // Aquí puedes manejar el error de la petición en caso de ser necesario
          throw error;
        }
      }
}

export default new CreateTicketService();