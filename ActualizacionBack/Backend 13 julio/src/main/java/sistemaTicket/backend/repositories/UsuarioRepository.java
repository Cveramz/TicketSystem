package sistemaTicket.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sistemaTicket.backend.entities.UsuarioEntity;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

    public Optional<UsuarioEntity> findBycorreo(String correo);
}
