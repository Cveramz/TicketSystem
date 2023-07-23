import http from "../../http-common.js";

class LoginDataService {

    // Función para realizar el inicio de sesión
    login(correo, password) {
        try {
            return http.get(`/validar-usuario?correo=${correo}&password=${password}`);
        } catch (error) {
            alert(error);
        }
    }
    

}

export default new LoginDataService();