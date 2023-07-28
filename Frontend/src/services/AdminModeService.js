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

    deleteUser(correo) {
        try {
          return http.delete(`/usuario/${correo}`);
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
    getUserById(id) {
        try {
          return http.get(`/usuario/${id}`);
        } catch (error) {
          // Manejar el error si ocurriera algún problema en la petición
          console.error("Error al obtener el usuario:", error);
          throw error;
        }
        }
        async actualizarUsuario(usuarioActualizado) {
          try {
            const response = await http.put(`/usuario/${usuarioActualizado.idUsuario}`, usuarioActualizado);
            return response.data;
          } catch (error) {
            throw error;
          }
        }
}

export default new AdminModeService();