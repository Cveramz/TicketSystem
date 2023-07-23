package sistemaTicket.backend.controllers;
import jakarta.transaction.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sistemaTicket.backend.entities.UsuarioEntity;
import sistemaTicket.backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173") // para realizar las peticiones
@RestController
public class UsuarioController{
    @Autowired
    UsuarioService usuarioService;

    @PostMapping(value = "/usuario/")
    public ResponseEntity<UsuarioEntity> guardar(@RequestBody UsuarioEntity usuarioEntityNuevo) {
        UsuarioEntity objeto = usuarioService.guardar(usuarioEntityNuevo);
        return new ResponseEntity<UsuarioEntity>(objeto, HttpStatus.OK);
    }
    @GetMapping("/usuarios/")
    public Iterable<UsuarioEntity> todos() {
        return usuarioService.todos();
    }

    @GetMapping("/usuario/{id}")
    public Optional<UsuarioEntity> obtenerUsuario(@PathVariable Long id) {
        return usuarioService.obtenerUsuario(id);
    }

    //GET: http://localhost:8080/validar-usuario?correo=cr7,a@usach.cl&password=rm2018
    @GetMapping("/validar-usuario")
    @CrossOrigin("*")
    public ResponseEntity<UsuarioEntity> SystemLogin(@RequestParam String correo, @RequestParam String password){
        UsuarioEntity newUser = usuarioService.SystemLogin(correo, password);
        if(newUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}

