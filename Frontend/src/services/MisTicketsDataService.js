// MisTicketsDataService.js

import http from "../../http-common.js";

class MisTicketsDataService {
  // Función para transformar un string a un número entero eliminando caracteres no numéricos
  transformStringToInt(inputString) {
    let numericString = inputString.replace(/[^0-9]/g, '');
    let result = parseInt(numericString, 10);
    return result;
  }

  // Función para obtener todos los tickets asociados a un usuario por su ID
  getAll(userId) {
    try {
      let userIdInt = this.transformStringToInt(userId);
      // Hacer la solicitud HTTP utilizando el ID del usuario
      return http.get(`/tickets-rut/${userIdInt}`);
    } catch (error) {
      console.error(error);
      throw error;
    }
  }
}

export default new MisTicketsDataService();
