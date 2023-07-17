package sistemaTicket.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import sistemaTicket.backend.entities.AdministradorEntity;

public interface  AdministradorRepository extends CrudRepository<AdministradorEntity, Long> {
}
