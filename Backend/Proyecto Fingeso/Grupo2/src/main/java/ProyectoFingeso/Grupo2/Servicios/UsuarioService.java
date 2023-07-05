package ProyectoFingeso.Grupo2.Servicios;
import ProyectoFingeso.Grupo2.Entidades.UsuarioEntity;
import ProyectoFingeso.Grupo2.Repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    public UsuarioEntity guardar(UsuarioEntity newUsuarioEntity){
        return usuarioRepository.save(newUsuarioEntity);
    }
    public Iterable<UsuarioEntity> todos(){
        return(usuarioRepository.findAll());
    }
}
