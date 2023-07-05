package ProyectoFingeso.Grupo2.Repositorios;

import ProyectoFingeso.Grupo2.Entidades.TicketEntity;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<TicketEntity, Long> {
}
