package sistemaTicket.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistemaTicket.backend.entities.RespuestaTicketsEntity;
import sistemaTicket.backend.repositories.RespuestaTicketsRepository;

@Service
//Se llenan desde otras clases las tablas intermedias
public class RespuestaTicketsServices {
    @Autowired
    RespuestaTicketsRepository respuestaTicketsRepository;

    public RespuestaTicketsEntity guardar(RespuestaTicketsEntity nuevaRespuesta){
        return respuestaTicketsRepository.save(nuevaRespuesta);
    }

    public Iterable<RespuestaTicketsEntity> todos(){
        return respuestaTicketsRepository.findAll();
    }

}
