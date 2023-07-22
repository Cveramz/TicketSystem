package sistemaTicket.backend.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistemaTicket.backend.entities.AdministradorEntity;
import sistemaTicket.backend.entities.TicketEntity;
import sistemaTicket.backend.services.AdministradorService;
import java.util.Optional;


@RestController
@RequestMapping("/Administrador")
@CrossOrigin(origins = "http://localhost:5173") //Solicitar peticiones
public class AdministradorController{
    @Autowired
    AdministradorService administradorService;
    @PostMapping(value = "/administrador/")
    public ResponseEntity<AdministradorEntity> guardar(@RequestBody AdministradorEntity nuevoAdministrador){
        AdministradorEntity administrador = administradorService.guardar(nuevoAdministrador);
        return new ResponseEntity<AdministradorEntity>(administrador, HttpStatus.OK);
    }
    @GetMapping("/administradores/")
    public Iterable<AdministradorEntity> obtenerTodosAdministradores(){
        return administradorService.obtenerTodosAdministradores();
    }
    @GetMapping("/administrador/{id}")
    public Optional<AdministradorEntity> obtenerIdAdministrador(@PathVariable Long id){
        return administradorService.obtenerIdAdministrador(id);
    }
    @GetMapping("/eliminarAdmin/")
    public void eliminarAdministrador(AdministradorEntity administrador){
        administradorService.eliminarAdministrador(administrador);
    }
    @GetMapping("/Actualizar/")
    public void actualizar(AdministradorEntity administrador){
        administradorService.actualizar(administrador);
    }
    @RequestMapping(value = "/EliminarTicket{id}", method = RequestMethod.GET)
    public void EliminarTicket(@PathVariable("id") Long id){
        administradorService.EliminarTicket(id);
    }

}
