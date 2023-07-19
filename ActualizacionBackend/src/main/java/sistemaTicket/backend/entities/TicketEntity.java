package sistemaTicket.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "reclamo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String categoria;
    private String descripcion;
    private String consulta;
    private String comentarios;
    private String creacion; //Usuario que crea el ticket
    private Date fecha = new Date();
}
