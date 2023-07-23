package sistemaTicket.backend.controllers;

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
    public ResponseEntity<TicketEntity> obtenerTicketPorPrioridad(@PathVariable String prioridad){
        return ResponseEntity.ok(ticketService.obtenerTicketPorPrioridad(prioridad));
    }
    @PutMapping("/tickets/{id}")
    @CrossOrigin("*")
    public ResponseEntity<TicketEntity> ActualizarTicket(@PathVariable Long id, @RequestBody TicketEntity ticket){
        TicketEntity ticketVigente = ticketService.obtenerTicketPorId(id);
        if(ticketVigente == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ticketVigente.setEstadoTicket(ticket.getEstadoTicket());
        TicketEntity ticketModificado = ticketService.actualizarTicket(ticketVigente);
        return new ResponseEntity<>(ticketModificado, HttpStatus.OK);
    }
    @DeleteMapping("/Delete/{idTicket}")
    public ResponseEntity<TicketEntity> eliminarTicket(@RequestBody Long idTicket){
        try{
            ticketService.eliminarTicket(idTicket);
            System.out.println("El ticket a sido eliminado con exito!");
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
