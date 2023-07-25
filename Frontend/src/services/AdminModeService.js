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


    deleteTicket(id) {
        try {
            return http.delete(`/tickets/${id}`);
        } catch (error) {
            alert(error);
        }
    }
}

export default new AdminModeService();