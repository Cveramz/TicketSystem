package sistemaTicket.backend.controllers;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sistemaTicket.backend.entities.RespuestaTicketsEntity;
import sistemaTicket.backend.services.RespuestaTicketsServices;

@RestController
public class RespuestaTicketsController {
    @Autowired
    RespuestaTicketsServices respuestaTicketsServices;

    @PostMapping("/Respuesta/")
    public RespuestaTicketsEntity guardar(@RequestBody RespuestaTicketsEntity nuevaRespuesta){
        return respuestaTicketsServices.guardar(nuevaRespuesta);
    }
}
