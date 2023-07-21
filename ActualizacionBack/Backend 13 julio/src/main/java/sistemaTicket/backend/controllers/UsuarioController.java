package sistemaTicket.backend.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistemaTicket.backend.services.UsuarioService;
import sistemaTicket.backend.entities.UsuarioEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "usuario")

public class UsuarioController{
    private UsuarioService usuarioService;
    @PostMapping(value = "/")
    public void guardarUsuario(@RequestBody UsuarioEntity usuarioEntity){
        usuarioService.save(usuarioEntity);
    }
    @GetMapping(value = "/MostrarUsuarios")
    @CrossOrigin("*")
    public List<UsuarioEntity> MostrarUsuarios(){
        return usuarioService.findAll();
    }
    @DeleteMapping(value = "/{id}")
    public void EliminarUsuario(@PathVariable Long id){
        usuarioService.deleteById(id);
    }
    @GetMapping(value = "/getUsuarioId/{id}")
    @CrossOrigin("*")
    public UsuarioEntity buscarUsuario(@PathVariable Long id){
        System.out.println("Buscar usuario");
        return usuarioService.findById(id).get();
    }
    @PutMapping
    @CrossOrigin("*")
    public ResponseEntity<UsuarioEntity> actualizarUsuario(@PathVariable UsuarioEntity usuario){
        try{
            UsuarioEntity usuario1 = usuarioService.save(usuario);
            return ResponseEntity.created(new URI("/usuario"+usuario1.getIdUsuario())).body(usuario1);
        }catch (URISyntaxException e){
            throw new RuntimeException(e);
        }
    }

}
