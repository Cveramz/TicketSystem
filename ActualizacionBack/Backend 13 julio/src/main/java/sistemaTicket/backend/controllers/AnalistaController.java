package sistemaTicket.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sistemaTicket.backend.entities.AnalistaEntity;
import sistemaTicket.backend.entities.UsuarioEntity;
import sistemaTicket.backend.services.AnalistaService;

@RestController
public class AnalistaController{
    @Autowired
    private AnalistaService analistaService;

    @PostMapping("/AsignarTicket/{idAnalista}{idTicket}")
    public ResponseEntity<String> AsignarAnalista(@PathVariable Long idAnalista, @PathVariable Long idTicket){
        analistaService.AsignarAnalista(idAnalista, idTicket);
        return ResponseEntity.ok("Ticket asignado al analista");
    }
    @PostMapping(value = "/analista/")
    public ResponseEntity<AnalistaEntity> guardar(@RequestBody AnalistaEntity analista) {
        AnalistaEntity analista1 = analistaService.guardar(analista);
        return new ResponseEntity<AnalistaEntity>(analista1, HttpStatus.OK);
    }
}
