package ProyectoFingeso.Grupo2.Servicios;
import ProyectoFingeso.Grupo2.Entidades.TicketEntity;
import ProyectoFingeso.Grupo2.Repositorios.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class TicketService{
    @Autowired
    TicketRepository ticketRepository;
    public TicketEntity guardar(TicketEntity nuevoTicket){
        return ticketRepository.save(nuevoTicket);
    }
    public Iterable<TicketEntity> obtenerTodosTicket(){
        return ticketRepository.findAll();
    }
    public Optional<TicketEntity> obtenerIdTicket(Long id){
        return ticketRepository.findById(id);
    }
}
