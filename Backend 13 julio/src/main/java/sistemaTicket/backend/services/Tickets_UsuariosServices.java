package sistemaTicket.backend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistemaTicket.backend.entities.Tickets_UsuariosEntity;
import sistemaTicket.backend.repositories.Tickets_UsuariosRepository;

import java.util.Optional;

@Service
public class Tickets_UsuariosServices {

    @Autowired
    Tickets_UsuariosRepository ticketsUsuariosRepository;

    public Tickets_UsuariosEntity guardar(Tickets_UsuariosEntity ticketsUsuariosEntityNew){
        return ticketsUsuariosRepository.save(ticketsUsuariosEntityNew);
    }
    /*
    public Iterable<Tickets_UsuariosEntity> obtenerTodos(){
        return ticketsUsuariosRepository.findAll();
    }

    public Optional<Tickets_UsuariosEntity> obetenerPorID(Long id){
        return ticketsUsuariosRepository.findById(id);
    }
    */
}
