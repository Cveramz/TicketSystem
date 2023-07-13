package sistemaTicket.backend.repositories;

import sistemaTicket.backend.entities.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity,Long> {
}
