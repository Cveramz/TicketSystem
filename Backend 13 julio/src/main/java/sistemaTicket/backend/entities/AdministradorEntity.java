package sistemaTicket.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "administrador")
public class AdministradorEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;
    private String Nombre;
    private String Correo;
    private String Password;
    private String descripcion; //El administrador puede dar una descripcion para crearlos

}
