package sistemaTicket.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Tickets_usuarios")
public class Tickets_usuariosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Long id_usuario;
    @Column(name = "id_analista")
    private Long id_analista;
    @Column(name = "id_invitado")
    private Long id_invitado;

    public Tickets_usuariosEntity(Long id_usuario, Long id_analista, Long id_invitado) {
        this.id_usuario = id_usuario;
        this.id_analista = id_analista;
        this.id_invitado = id_invitado;
    }
    public Tickets_usuariosEntity() {

    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_analista() {
        return id_analista;
    }

    public void setId_analista(Long id_analista) {
        this.id_analista = id_analista;
    }

    public Long getId_invitado() {
        return id_invitado;
    }

    public void setId_invitado(Long id_invitado) {
        this.id_invitado = id_invitado;
    }
}
