package sistemaTicket.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistemaTicket.backend.entities.TicketEntity;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long>{
    TicketEntity findByIdTicket(Long id);
    TicketEntity findByPrioridad(String prioridad);

    TicketEntity deleteByIdTicket(Long id);

    TicketEntity findByestadoTicket(String estadoTicket);
}
