//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sistemaTicket.backend.controllers;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sistemaTicket.backend.entities.TicketEntity;
import sistemaTicket.backend.entities.UsuarioEntity;
import sistemaTicket.backend.services.TicketService;
import sistemaTicket.backend.services.UsuarioService;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;
    private UsuarioService usuarioService;

    public TicketController() {
    }

    @PostMapping("/ticket")
    @CrossOrigin(origins = "*") // Agrega aquí la URL de tu frontend
    public ResponseEntity<TicketEntity> guardar(@RequestBody TicketEntity nuevoTicket) {
        TicketEntity Ticket = this.ticketService.guardar(nuevoTicket);
        return new ResponseEntity<>(Ticket, HttpStatus.OK);
    }

    @PutMapping("/ticket/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<TicketEntity> actualizarTicket(@PathVariable Long id, @RequestBody TicketEntity ticketModificado) {
        // Verificar que el ticket con el ID especificado existe en la base de datos
        Optional<TicketEntity> ticketExistente = ticketService.obtenerIdTicket(id);
        if (ticketExistente.isEmpty()) {
            return new ResponseEntity("Ticket no existe", HttpStatus.NOT_FOUND);
        }

        // Establecer el ID del ticket modificado con el ID existente para actualizarlo
        ticketModificado.setIdTicket(id);

        // Guardar el ticket modificado en la base de datos
        TicketEntity ticketActualizado = ticketService.actualizarTicket(ticketModificado);

        return new ResponseEntity<>(ticketActualizado, HttpStatus.OK);
    }

    @GetMapping({"/tickets/"})
    @CrossOrigin({"*"})
    public Iterable<TicketEntity> obtenerTodosTicket() {
        return this.ticketService.obtenerTodosTicket();
    }

    @GetMapping({"/ticket/{id}"})
    @CrossOrigin({"*"})
    public Optional<TicketEntity> obtenerIdTicket(@PathVariable Long id) {
        return this.ticketService.obtenerIdTicket(id);
    }

    @GetMapping({"/prioridad/{prioridad}"})
    @CrossOrigin({"*"})
    public ResponseEntity<TicketEntity> obtenerTicketPorPrioridad(@PathVariable String prioridad) {
        return ResponseEntity.ok(this.ticketService.obtenerTicketPorPrioridad(prioridad));
    }

    @PutMapping("/tickets/{id}/{estadoTicket}")
    @CrossOrigin("*")
    public ResponseEntity<TicketEntity> ActualizarTicket(@PathVariable Long id, @PathVariable String estadoTicket) {
        TicketEntity ticketVigente = ticketService.obtenerTicketPorId(id);
        if (ticketVigente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ticketVigente.setEstadoTicket(estadoTicket);
        TicketEntity ticketModificado = ticketService.actualizarTicket(ticketVigente);
        return new ResponseEntity<>(ticketModificado, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping({"/tickets/{id}"})
    @CrossOrigin({"*"})
    public ResponseEntity<String> eliminarTicket(@PathVariable Long id) {
        try {
            this.ticketService.eliminarTicket(id);
            return new ResponseEntity("Ticket eliminado", HttpStatus.OK);
        } catch (EmptyResultDataAccessException var3) {
            return new ResponseEntity("Ticket no existe", HttpStatus.NOT_FOUND);
        } catch (Exception var4) {
            return new ResponseEntity("Fallo al eliminar ticket", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET: http://localhost:8080/tickets-rut/21333444-k
    @GetMapping("/tickets-rut/{ticketRut}")
    @CrossOrigin({"*"})
    public ResponseEntity<List<TicketEntity>> obtenerTicketsPorRut(@PathVariable String ticketRut) {
        List<TicketEntity> tickets = this.ticketService.obtenerTicketRut(ticketRut);

        if (!tickets.isEmpty()) {
            System.out.println("Tickets encontrados");
            return new ResponseEntity<>(tickets, HttpStatus.OK);
        } else {
            System.out.println("Tickets no encontrados");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}