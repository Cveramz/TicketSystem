package ProyectoFingeso.Grupo2.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private String Nombre;
    private String Correo;
    private String Contraseña;
    private Long id;
}
