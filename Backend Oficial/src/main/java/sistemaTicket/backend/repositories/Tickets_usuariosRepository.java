package sistemaTicket.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistemaTicket.backend.entities.Tickets_usuariosEntity;

@Repository
public interface Tickets_usuariosRepository extends JpaRepository<Tickets_usuariosEntity, Long>{

}
