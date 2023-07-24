package sistemaTicket.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistemaTicket.backend.entities.TicketEntity;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long>{
    TicketEntity findByIdTicket(Long id);
    TicketEntity findByPrioridad(String prioridad);

    TicketEntity findByestadoTicket(String estadoTicket);

    void deleteByIdTicket(Long id);

    List<TicketEntity> findByTicketRut(String ticketRut);
}
