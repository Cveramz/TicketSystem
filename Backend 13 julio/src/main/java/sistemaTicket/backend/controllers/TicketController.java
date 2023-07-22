package sistemaTicket.backend.controllers;

import sistemaTicket.backend.entities.TicketEntity;
import sistemaTicket.backend.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
@RestController
public class TicketController{
    @Autowired
    TicketService ticketService;

    @PostMapping(value = "/ticket/")
    public ResponseEntity<TicketEntity> guardar(@RequestBody TicketEntity nuevoTicket){
        TicketEntity Ticket = ticketService.guardar(nuevoTicket);
        return new ResponseEntity<TicketEntity>(Ticket, HttpStatus.OK);
    }

    @GetMapping("/tickets/")
    @CrossOrigin("*")
    public Iterable<TicketEntity> obtenerTodosTicket(){
        return ticketService.obtenerTodosTicket();
    }

    @GetMapping("/ticket/{id}")
    @CrossOrigin("*")
    public Optional<TicketEntity> obtenerIdTicket(@PathVariable Long id){
        return ticketService.obtenerIdTicket(id);
    }

    @GetMapping(value = "/prioridad/{prioridad}")
    @CrossOrigin("*")

    public ResponseEntity<List<TicketEntity>> findByPriority(@PathVariable("prioridad") String prioridad){
        return ResponseEntity.ok(ticketService.findByPriority(prioridad));
    }

    @PostMapping("/")
    public void guardarTicket(@RequestBody TicketEntity ticket){
        ticketService.save(ticket);
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
