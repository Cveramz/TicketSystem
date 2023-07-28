package sistemaTicket.backend.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "respuestas")
public class RespuestaTicketsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long idRespuesta;
    private String mensaje;

    public RespuestaTicketsEntity(Long idRespuesta, String mensaje) {
        this.idRespuesta = idRespuesta;
        this.mensaje = mensaje;
    }

    public RespuestaTicketsEntity() {

    }

    public Long getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Long idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
