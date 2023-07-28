package sistemaTicket.backend.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistemaTicket.backend.entities.Tickets_usuariosEntity;
import sistemaTicket.backend.services.Tickets_usuariosService;

import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:5173") // para realizar las peticiones
public class Ticket_usuariosController{
    @Autowired
    private Tickets_usuariosService ticketsUsuariosService;

    @PostMapping(value = "/TicketsUsuarios")
    public ResponseEntity<Tickets_usuariosEntity> guardar(@RequestBody Tickets_usuariosEntity nuevoTicket_usuario){
        Tickets_usuariosEntity NewTickerUser = ticketsUsuariosService.guardar(nuevoTicket_usuario);
        return new ResponseEntity<>(NewTickerUser, HttpStatus.OK);
    }

    @GetMapping("/TicketsUsuarios/")
    @CrossOrigin("*")
    public Iterable<Tickets_usuariosEntity> mostrarTodos(){
        return ticketsUsuariosService.mostrarTodos();
    }

    @GetMapping("/TicketsUsuarios/{id}")
    @CrossOrigin("*")
    public Optional<Tickets_usuariosEntity> buscarPorId(@PathVariable Long id){
        return ticketsUsuariosService.buscarPorId(id);
    }
}
