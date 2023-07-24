package sistemaTicket.backend.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "analista")
public class AnalistaEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAnalista")
    private Long idAnalista;
    @Column(name = "correo")
    private String correo;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "analista")
    private List<TicketEntity> ticket;

    public AnalistaEntity(Long idAnalista, String correo, String password, List<TicketEntity> ticket) {
        this.idAnalista = idAnalista;
        this.correo = correo;
        this.password = password;
        this.ticket = ticket;
    }

    public AnalistaEntity() {

    }

    public Long getIdAnalista() {
        return idAnalista;
    }

    public void setIdAnalista(Long idAnalista) {
        this.idAnalista = idAnalista;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TicketEntity> getTicket() {
        return ticket;
    }

    public void setTicket(List<TicketEntity> ticket) {
        this.ticket = ticket;
    }


}
