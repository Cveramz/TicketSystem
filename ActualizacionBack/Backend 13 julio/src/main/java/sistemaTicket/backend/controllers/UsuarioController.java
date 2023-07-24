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

    @PostMapping("/Login")
    @CrossOrigin("*")
    public ResponseEntity<UsuarioEntity> SystemLogin(@RequestBody UsuarioEntity User){
        String correoUser = User.getCorreo();
        String passwordUser = User.getPassword();
        UsuarioEntity newUser = usuarioService.SystemLogin(correoUser, passwordUser);
        if(newUser == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/Usuario/{rut}")
    @CrossOrigin("*")
    public ResponseEntity<UsuarioEntity> obtenerUserByRut(@PathVariable String rut){
        return ResponseEntity.ok(usuarioService.obtenerUserByRut(rut));
    }

    @Transactional
    @DeleteMapping("/usuario/{correo}")
    @CrossOrigin("*")
    public ResponseEntity<String> eliminarUsuario(@PathVariable String correo){
        try{
            usuarioService.eliminarUsuario(correo);
            return new ResponseEntity<>("Usuario eliminado", HttpStatus.OK);
        }catch (EmptyResultDataAccessException e){
            return new ResponseEntity<>("No existe el usuario", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>("Fallo al eliminar el usuario del sistema", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

