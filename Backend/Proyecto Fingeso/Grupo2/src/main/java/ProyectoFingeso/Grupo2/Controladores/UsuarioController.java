package ProyectoFingeso.Grupo2.Controladores;
import ProyectoFingeso.Grupo2.Entidades.UsuarioEntity;
import ProyectoFingeso.Grupo2.Servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@RestController
public class UsuarioController{
    @Autowired
    UsuarioService usuarioService;
    @PostMapping("/usuario/")
    public UsuarioEntity guardar(@RequestBody UsuarioEntity newUsuarioEntity){
        return usuarioService.guardar(newUsuarioEntity);
    }
    @GetMapping("/usuario/")
    public Iterable<UsuarioEntity> todos(){
        return usuarioService.todos();
    }
}
