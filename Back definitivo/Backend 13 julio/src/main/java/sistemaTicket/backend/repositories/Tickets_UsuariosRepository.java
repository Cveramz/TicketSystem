package sistemaTicket.backend.repositories;

import sistemaTicket.backend.entities.Tickets_UsuariosEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tickets_UsuariosRepository extends CrudRepository<Tickets_UsuariosEntity , Long>{
}
