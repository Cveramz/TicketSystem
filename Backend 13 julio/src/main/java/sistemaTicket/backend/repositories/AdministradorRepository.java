package sistemaTicket.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sistemaTicket.backend.entities.AdministradorEntity;
import sistemaTicket.backend.entities.TicketEntity;

public interface AdministradorRepository extends JpaRepository<AdministradorEntity, Long> {


}
