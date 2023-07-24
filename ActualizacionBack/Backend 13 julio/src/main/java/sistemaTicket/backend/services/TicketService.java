package sistemaTicket.backend.services;
import sistemaTicket.backend.entities.TicketEntity;
import sistemaTicket.backend.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class TicketService{
    @Autowired
    private TicketRepository ticketRepository;
    public TicketEntity guardar(TicketEntity nuevoTicket){
        return ticketRepository.save(nuevoTicket);
    }
    public Iterable<TicketEntity> obtenerTodosTicket(){
        return ticketRepository.findAll();
    }
    public Optional<TicketEntity> obtenerIdTicket(Long id){
        return ticketRepository.findById(id);
    }

    public TicketEntity obtenerTicketPorPrioridad(String prioridad){
        return ticketRepository.findByPrioridad(prioridad);
    }
    public TicketEntity obtenerTicketPorId(Long id){
        return ticketRepository.findByIdTicket(id);
    }
    public TicketEntity actualizarTicket(TicketEntity ticket){
        return ticketRepository.save(ticket);
    }

    public void eliminarTicket(Long id){
        System.out.println("Eliminacion de ticket");
        ticketRepository.deleteByIdTicket(id);
    }
}
