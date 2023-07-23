import http from "../../http-common.js";

class RegisterDataService {
  // Función para registrar un nuevo usuario
  register(newUser) {
    return http.post('/usuario/', newUser);
  }
}

export default new RegisterDataService();
