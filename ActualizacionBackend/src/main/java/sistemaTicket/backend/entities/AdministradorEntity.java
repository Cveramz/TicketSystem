package sistemaTicket.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "administrador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministradorEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;
    private String Nombre;
    private String Correo;
    private String Password;
    private Rol rol;
    public Rol getRol() { //Operaciones para retornar el rol del administrador
        return rol;
    }
    public void setRol(Rol rol){ //Seleccion rol administrador clase administrador
        this.rol = rol;
    }
}
