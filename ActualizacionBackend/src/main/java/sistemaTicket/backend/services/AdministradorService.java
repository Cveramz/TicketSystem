package sistemaTicket.backend.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import sistemaTicket.backend.entities.AdministradorEntity;
import sistemaTicket.backend.repositories.AdministradorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorService{
    @Autowired
    AdministradorRepository administradorRepository;

    public AdministradorEntity guardar(@RequestBody AdministradorEntity nuevoAdministradorEntity){
        return administradorRepository.save(nuevoAdministradorEntity);
    }

    public Iterable<AdministradorEntity> todos(){
        return administradorRepository.findAll();
    }

    public Optional<AdministradorEntity> obtenerAdministrador(Long id){
        return administradorRepository.findById(id);
    }


    public AdministradorEntity getAdministradorByUser_id(Long id){
        return administradorRepository.getAdministradorByUser_id(id);
    }

    public AdministradorEntity save(AdministradorEntity administrador) {
        return administradorRepository.save(administrador);
    }
}
