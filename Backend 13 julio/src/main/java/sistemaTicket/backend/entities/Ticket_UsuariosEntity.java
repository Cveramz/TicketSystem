package sistemaTicket.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Tickets_Usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ticket_UsuariosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)

    private Long id;

    private Long id_usuario;

    private Long id_ticket;
}
