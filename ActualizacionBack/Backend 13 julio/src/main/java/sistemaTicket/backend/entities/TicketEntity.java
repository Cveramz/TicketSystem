package sistemaTicket.backend.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "reclamo")

public class TicketEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTicket")
    private Long idTicket;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "consulta")
    private String consulta;
    @Column(name = "comentarios")
    private String comentarios;
    @Column(name = "estadoTicket")
    private String estadoTicket;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date fechaCreacion;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date ultimaActualizacion;
    @Column(name = "resolucion")
    private String resolucion;
    @Column(name = "Prioridad")
    private String prioridad;
    @ManyToOne
    @JoinColumn(name = "idAnalista")
    private AnalistaEntity analista;



    public TicketEntity(Long idTicket, String categoria, String descripcion, String consulta, String comentarios, String estadoTicket, Date fechaCreacion, Date ultimaActualizacion, String resolucion, String prioridad, AnalistaEntity analista) {
        this.idTicket = idTicket;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.consulta = consulta;
        this.comentarios = comentarios;
        this.estadoTicket = estadoTicket;
        this.fechaCreacion = fechaCreacion;
        this.ultimaActualizacion = ultimaActualizacion;
        this.resolucion = resolucion;
        this.prioridad = prioridad;
        this.analista = analista;
    }

    public TicketEntity() {

    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getEstadoTicket() {
        return estadoTicket;
    }

    public void setEstadoTicket(String estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(Date ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public AnalistaEntity getAnalista() {
        return analista;
    }

    public void setAnalista(AnalistaEntity analista) {
        this.analista = analista;
    }
}

