//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sistemaTicket.backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistemaTicket.backend.entities.TicketEntity;
import sistemaTicket.backend.repositories.TicketRepository;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public TicketService() {
    }

    public TicketEntity guardar(TicketEntity nuevoTicket) {
        return (TicketEntity)this.ticketRepository.save(nuevoTicket);
    }

    public Iterable<TicketEntity> obtenerTodosTicket() {
        return this.ticketRepository.findAll();
    }

    public Optional<TicketEntity> obtenerIdTicket(Long id) {
        return this.ticketRepository.findById(id);
    }

    public TicketEntity obtenerTicketPorPrioridad(String prioridad) {
        return this.ticketRepository.findByPrioridad(prioridad);
    }

    public TicketEntity obtenerTicketPorId(Long id) {
        return this.ticketRepository.findByIdTicket(id);
    }

    public TicketEntity actualizarTicket(TicketEntity ticket) {
        return (TicketEntity)this.ticketRepository.save(ticket);
    }

    public void eliminarTicket(Long id) {
        System.out.println("Eliminacion de ticket");
        this.ticketRepository.deleteByIdTicket(id);
    }

    public List<TicketEntity> obtenerTicketRut(String ticketRut) {
        return this.ticketRepository.findByTicketRut(ticketRut);
    }
}
