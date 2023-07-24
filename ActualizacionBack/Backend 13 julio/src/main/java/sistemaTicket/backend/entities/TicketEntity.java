//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sistemaTicket.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(
        name = "reclamo"
)
public class TicketEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "idTicket"
    )
    private Long idTicket;
    @Column(
            name = "categoria"
    )
    private String categoria;
    @Column(
            name = "descripcion"
    )
    private String descripcion;
    @Column(
            name = "consulta"
    )
    private String consulta;
    @Column(
            name = "comentarios"
    )
    private String comentarios;
    @Column(
            name = "estadoTicket"
    )
    private String estadoTicket;
    @Column(
            name = "ticketRut"
    )
    private String ticketRut;
    @DateTimeFormat(
            iso = ISO.DATE_TIME
    )
    private Date fechaCreacion;
    @DateTimeFormat(
            iso = ISO.DATE_TIME
    )
    private Date ultimaActualizacion;
    @Column(
            name = "resolucion"
    )
    private String resolucion;

    @Column(
            name = "Prioridad"
    )
    private String prioridad;
    /*
    @ManyToOne
    @JoinColumn(
            name = "idAnalista"
    )
    private AnalistaEntity analista;
    */

    public TicketEntity(Long idTicket, String categoria, String descripcion, String consulta, String comentarios, String estadoTicket, Date fechaCreacion, Date ultimaActualizacion, String resolucion, String prioridad, AnalistaEntity analista, String ticketRut) {
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
        //this.analista = analista;
        this.ticketRut = ticketRut;
    }

    public TicketEntity() {
    }

    public Long getIdTicket() {
        return this.idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getConsulta() {
        return this.consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public String getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getEstadoTicket() {
        return this.estadoTicket;
    }

    public void setEstadoTicket(String estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getUltimaActualizacion() {
        return this.ultimaActualizacion;
    }

    public void setUltimaActualizacion(Date ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public String getResolucion() {
        return this.resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getPrioridad() {
        return this.prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    /*
    public AnalistaEntity getAnalista() {
        return this.analista;
    }


    public void setAnalista(AnalistaEntity analista) {
        this.analista = analista;
    }
    */
    public String getTicketRut() {
        return this.ticketRut;
    }

    public void setTicketRut(String ticketRut) {
        this.ticketRut = ticketRut;
    }
}