package sistemaTicket.backend.services;
import sistemaTicket.backend.entities.UsuarioEntity;
import sistemaTicket.backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioEntity guardar(UsuarioEntity usuarioEntityNuevo){
        return usuarioRepository.save(usuarioEntityNuevo);
    }

    public Iterable<UsuarioEntity> todos(){
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioEntity> obtenerUsuario(Long id){
        return usuarioRepository.findById(id);
    }

    public Optional<UsuarioEntity> obtenerListadoRut(Long rut){
        return usuarioRepository.findById(rut);
    }

    public UsuarioEntity buscarUsuariosExistentes(String correo, String password){
        return usuarioRepository.findByCorreoAndPassword(correo, password);
    }
    public UsuarioEntity SystemLogin(String correo, String password){
        UsuarioEntity User = usuarioRepository.findByCorreoAndPassword(correo, password);
        if(User == null){
            System.out.println("No existe el usuario en el sistema");
        } else if (User.getPassword().equals(password) && User.getCorreo().equals(correo)){
            System.out.println("Credenciales correctas");
            return User;
        }else {
            throw new RuntimeException("Datos incorrectos");
        }
        return User;
    }

    public void eliminarUsuario(String correo){
       usuarioRepository.deleteByCorreo(correo);
    }

    public UsuarioEntity obtenerUserByRut(String rut){
        return usuarioRepository.findUserByRut(rut);
    }
}
