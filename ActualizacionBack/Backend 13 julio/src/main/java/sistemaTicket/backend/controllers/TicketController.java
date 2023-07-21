package sistemaTicket.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistemaTicket.backend.entities.TicketEntity;
import sistemaTicket.backend.services.TicketService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("ticket")

public class TicketController{
    private TicketService ticketService;
    @PostMapping("/")
    public void guardarTicket(@RequestBody TicketEntity ticket){
        ticketService.save(ticket);
    }
    @GetMapping(value = "/MostrarTickets")
    @CrossOrigin("*")
    public List<TicketEntity> MostrarTickets(){
        return ticketService.findAll();
    }

    @GetMapping(value = "/BuscarTickets")
    @CrossOrigin("*")
    public TicketEntity buscarTickets(@PathVariable Long id){
        System.out.println("Buscar tickets");
        return ticketService.findById(id).get();
    }
    @PutMapping
    @CrossOrigin("*")

    public ResponseEntity<TicketEntity> actualizarTickets(@PathVariable TicketEntity ticket1){
        try{
            TicketEntity ticket2 = ticketService.save(ticket1);
            return ResponseEntity.created(new URI("/ticket"+ticket1.getIdTicket())).body(ticket2);
        }catch (URISyntaxException e){
            throw new RuntimeException(e);
        }
    }

}
