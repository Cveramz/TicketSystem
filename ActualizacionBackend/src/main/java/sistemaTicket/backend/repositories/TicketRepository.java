package sistemaTicket.backend.repositories;

import sistemaTicket.backend.entities.TicketEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface TicketRepository extends CrudRepository<TicketEntity, Long> {
}
