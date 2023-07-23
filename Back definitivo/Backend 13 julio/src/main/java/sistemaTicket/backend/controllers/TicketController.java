package sistemaTicket.backend.controllers;

import jakarta.transaction.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import sistemaTicket.backend.entities.TicketEntity;
import sistemaTicket.backend.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@RestController
@Controller
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping(value = "/ticket/")
    public ResponseEntity<TicketEntity> guardar(@RequestBody TicketEntity nuevoTicket) {
        TicketEntity Ticket = ticketService.guardar(nuevoTicket);
        return new ResponseEntity<TicketEntity>(Ticket, HttpStatus.OK);
    }

    @GetMapping("/tickets/")
    @CrossOrigin("*")
    public Iterable<TicketEntity> obtenerTodosTicket() {
        return ticketService.obtenerTodosTicket();
    }

    @GetMapping("/ticket/{id}")
    @CrossOrigin("*")
    public Optional<TicketEntity> obtenerIdTicket(@PathVariable Long id) {
        return ticketService.obtenerIdTicket(id);
    }

    @GetMapping(value = "/prioridad/{prioridad}")
    @CrossOrigin("*")
    public ResponseEntity<TicketEntity> obtenerTicketPorPrioridad(@PathVariable String prioridad) {
        return ResponseEntity.ok(ticketService.obtenerTicketPorPrioridad(prioridad));
    }

    @Transactional
    @DeleteMapping("/tickets/{id}")
    @CrossOrigin("*")
    public ResponseEntity<String> eliminarTicket(@PathVariable Long id){
        try{
            ticketService.eliminarTicket(id);
            return new ResponseEntity<>("Ticket eliminado", HttpStatus.OK);
        }catch (EmptyResultDataAccessException e){
            return new ResponseEntity<>("Ticket no existe", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>("Fallo al eliminar ticket", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}