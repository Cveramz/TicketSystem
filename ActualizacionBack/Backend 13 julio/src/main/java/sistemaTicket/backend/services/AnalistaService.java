package sistemaTicket.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistemaTicket.backend.entities.AnalistaEntity;
import sistemaTicket.backend.entities.TicketEntity;
import sistemaTicket.backend.repositories.AnalistaRepository;
import sistemaTicket.backend.repositories.TicketRepository;

@Service
public class AnalistaService{
    @Autowired
    private AnalistaRepository analistaRepository;
    private TicketRepository ticketRepository;

    public AnalistaEntity buscarTicketById(Long id){
        return analistaRepository.findByIdAnalista(id);
    }
    public void AsignarAnalista(Long idAnalista, Long idTicket){
        AnalistaEntity analista = analistaRepository.findByIdAnalista(idAnalista);
        TicketEntity ticket = ticketRepository.findByIdTicket(idTicket);
        ticket.setAnalista(analista);
        ticketRepository.save(ticket);
    }
    public AnalistaEntity guardar(AnalistaEntity analista){
        return analistaRepository.save(analista);
    }
}
