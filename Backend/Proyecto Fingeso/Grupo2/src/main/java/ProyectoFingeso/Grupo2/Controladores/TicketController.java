package ProyectoFingeso.Grupo2.Controladores;

import ProyectoFingeso.Grupo2.Entidades.TicketEntity;
import ProyectoFingeso.Grupo2.Servicios.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
public class TicketController{
    @Autowired
    TicketService ticketService;

    @PostMapping(value = "/Ticket/")
    public ResponseEntity<TicketEntity> guardar(@RequestBody TicketEntity nuevoTicket){
        TicketEntity Ticket = ticketService.guardar(nuevoTicket);
        return new ResponseEntity<TicketEntity>(Ticket, HttpStatus.OK);
    }
    @GetMapping("/Tickets/")
    public Iterable<TicketEntity> obtenerTodosTicket(){
        return ticketService.obtenerTodosTicket();
    }
    @GetMapping("/Tickets por {id}/")
    public Optional<TicketEntity> obtenerIdTicket(@PathVariable Long id){
        return ticketService.obtenerIdTicket(id);
    }

}
