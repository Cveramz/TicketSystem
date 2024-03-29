package sistemaTicket.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sistemaTicket.backend.entities.UsuarioEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {
    UsuarioEntity findByCorreoAndPassword(String correo, String password);

    void deleteByCorreo(String correo);

    UsuarioEntity findUserByRut(String rut);
}
