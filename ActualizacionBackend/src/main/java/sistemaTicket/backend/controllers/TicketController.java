package sistemaTicket.backend.controllers;

import sistemaTicket.backend.entities.TicketEntity;
import sistemaTicket.backend.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
