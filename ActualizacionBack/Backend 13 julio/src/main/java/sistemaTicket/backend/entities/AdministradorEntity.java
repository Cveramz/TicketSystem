package sistemaTicket.backend.entities;
import jakarta.persistence.*;



@Entity
@Table(name = "administrador")
public class AdministradorEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAdministrador", nullable = false)
    private Long idAdministrador;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Correo")
    private String Correo;
    @Column(name = "Password")
    private String Password;
    @Column(name = "descripcion")
    private String descripcion;

    public AdministradorEntity(Long id, String nombre, String correo, String password, String descripcion) {
        this.idAdministrador = id;
        Nombre = nombre;
        Correo = correo;
        Password = password;
        this.descripcion = descripcion;
    }

    public AdministradorEntity() {

    }

    public Long getId() {
        return idAdministrador;
    }

    public void setId(Long id) {
        this.idAdministrador = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
