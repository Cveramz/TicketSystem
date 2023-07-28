package sistemaTicket.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistemaTicket.backend.entities.AnalistaEntity;

@Repository
public interface AnalistaRepository extends JpaRepository<AnalistaEntity, Long> {
    AnalistaEntity findByIdAnalista(Long id);
}
