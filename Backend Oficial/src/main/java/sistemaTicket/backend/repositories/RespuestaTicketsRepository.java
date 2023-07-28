package sistemaTicket.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sistemaTicket.backend.entities.RespuestaTicketsEntity;

public interface RespuestaTicketsRepository extends CrudRepository <RespuestaTicketsEntity , Long> {
}
