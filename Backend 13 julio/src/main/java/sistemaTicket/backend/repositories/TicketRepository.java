package sistemaTicket.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sistemaTicket.backend.entities.TicketEntity;


public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
}
