package sistemaTicket.backend.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistemaTicket.backend.entities.Tickets_usuariosEntity;
import sistemaTicket.backend.repositories.Tickets_usuariosRepository;
import java.util.Optional;

@Service
public class Tickets_usuariosService{
    @Autowired
    private Tickets_usuariosRepository ticketsUsuariosRepository;

    public Tickets_usuariosEntity guardar(Tickets_usuariosEntity newTickets_Usuarios){
        return ticketsUsuariosRepository.save(newTickets_Usuarios);
    }
    public Iterable<Tickets_usuariosEntity> mostrarTodos(){
        return ticketsUsuariosRepository.findAll();
    }
    public Optional<Tickets_usuariosEntity> buscarPorId(Long id){
        return ticketsUsuariosRepository.findById(id);
    }
}
