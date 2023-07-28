package sistemaTicket.backend.services;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UsuarioEntity> SystemLogin(String correo, String password) {
        UsuarioEntity user = usuarioRepository.findByCorreoAndPassword(correo, password);
        if (user == null) {
            System.out.println("No existe el usuario en el sistema");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else if (user.getPassword().equals(password) && user.getCorreo().equals(correo)) {
            System.out.println("Credenciales correctas");
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            System.out.println("Datos incorrectos");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    public void eliminarUsuario(String correo){
       usuarioRepository.deleteByCorreo(correo);
    }

    public UsuarioEntity obtenerUserByRut(String rut){
        return usuarioRepository.findUserByRut(rut);
    }

    public void changePassword(String newPassword, String rut){
        UsuarioEntity usuario = usuarioRepository.findUserByRut(rut);
        if(usuario == null){
            throw new EntityNotFoundException("El usuario no existe");
        }else{
            usuario.setPassword(newPassword);
            usuarioRepository.save(usuario);
        }
    }
}
