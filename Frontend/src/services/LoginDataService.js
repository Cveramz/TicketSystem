import http from "../../http-common.js";

class LoginDataService {

    // Función para realizar el inicio de sesión
    login(correo, password) {
    return http.get(`/validar-usuario?correo=${correo}&password=${password}`);
    }
    

}

export default new LoginDataService();