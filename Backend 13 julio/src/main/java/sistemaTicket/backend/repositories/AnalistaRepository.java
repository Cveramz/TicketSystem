package sistemaTicket.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sistemaTicket.backend.entities.AnalistaEntity;

public interface AnalistaRepository extends JpaRepository<AnalistaEntity, Long> {

}
