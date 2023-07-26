import http from "../../http-common.js";

class AdminModeService {

    // Función para realizar el inicio de sesión
    getAll() {
        try {
            return http.get(`/tickets/`);
        } catch (error) {
            alert(error);
        }
    }

    getAllUsers() {
        try {
            return http.get(`/usuarios/`);
        } catch (error) {
            alert(error);
        }
    }


    deleteTicket(id) {
        try {
            return http.delete(`/tickets/${id}`);
        } catch (error) {
            alert(error);
        }
    }

    async editTicket(ticket) {
        try {
            // Obtén el ID del ticket que deseas modificar
            const ticketId = ticket.idTicket;
    
            // Realiza la solicitud PUT incluyendo el ID del ticket en la URL
            const response = await http.put(`/ticket/${ticketId}`, ticket);
            return response.data;
        } catch (error) {
            // Aquí puedes manejar el error de la petición en caso de ser necesario
            throw error;
        }
    }
}

export default new AdminModeService();