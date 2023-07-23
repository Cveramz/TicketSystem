package sistemaTicket.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "Tickets_Usuarios")
@NoArgsConstructor
@AllArgsConstructor
public class Tickets_UsuariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = true)

    private Long id;

    private Long id_alumno;

    private Long id_curso;
}
