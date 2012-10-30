/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.ParamDef;

/**
 *
 * @author miguelavg
 */
@Entity
@Table(name = "Envio")
@NamedQueries({
    @NamedQuery(name = "Envios", query = "from Envio order by fechaRecojo desc"),
    @NamedQuery(name = "Aeropuerto", query = "from aeropuerto")    
    })
@FilterDefs({
    @FilterDef(name = "EnviosXOrigen", parameters = @ParamDef(name = ":idAeropuerto", type = "integer")),
    @FilterDef(name = "EnviosXDestino", parameters = @ParamDef(name = ":idAeropuerto", type = "integer")),
    @FilterDef(name = "EnviosXActual", parameters = @ParamDef(name = ":idAeropuerto", type = "integer")),
    @FilterDef(name = "EnviosXEstado", parameters = @ParamDef(name = ":idEstado", type = "integer")),
    @FilterDef(name = "EnviosXCliente", parameters = @ParamDef(name = ":idCliente", type = "integer")),
    @FilterDef(name = "EnviosXNumEnvio",parameters = @ParamDef(name = ":numEnvio", type = "integer")),
    @FilterDef(name = "Aeropuerto",parameters = @ParamDef(name = ":idAeropuerto", type = "integer")),
})
@Filters({
    @Filter(name = "EnviosXOrigen", condition = "idAeropuerto = :idAeropuerto"),
    @Filter(name = "EnviosXDestino", condition = "idAeropuerto = :idAeropuerto"),
    @Filter(name = "EnviosXActual", condition = "idAeropuerto = :idAeropuerto"),
    @Filter(name = "EnviosXEstado", condition = "Estado = :idEstado"),
    @Filter(name = "EnviosXCliente", condition = "idRemitente = :idCliente or idDestinatario = :idCliente"),
    @Filter(name = "EnviosXNumEnvio", condition = "idEnvio = :numEnvio"),
    @Filter(name = "Aeropuerto", condition = "idaeropuerto = :idAeropuerto")
})
public class Envio implements Serializable {

    @Id
    private int idEnvio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecojo;
    private int numPaquetes;
    private double monto;
    private int numDocVenta;
    @ManyToOne
    @JoinColumn(name = "Moneda")
    private Parametro moneda;
    @ManyToOne
    @JoinColumn(name = "TipoDocVenta")
    private Parametro tipoDocVenta;
    @ManyToOne
    @JoinColumn(name = "Estado")
    private Parametro estado;
    @ManyToOne
    @JoinColumn(name = "idOrigen")
    private Aeropuerto origen;
    @ManyToOne
    @JoinColumn(name = "idDestino")
    private Aeropuerto destino;
    @ManyToOne
    @JoinColumn(name = "idActual")
    private Aeropuerto actual;
    @ManyToOne
    @JoinColumn(name = "idRemitente")
    private Cliente remitente;
    @ManyToOne
    @JoinColumn(name = "idDestinatario")
    private Cliente destinatario;
    @OneToMany(mappedBy = "envio")
    private List<Escala> escalas;

    public Envio() {
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaEntrada) {
        this.fechaRegistro = fechaEntrada;
    }

    public Date getFechaRecojo() {
        return fechaRecojo;
    }

    public void setFechaRecojo(Date fechaSalida) {
        this.fechaRecojo = fechaSalida;
    }

    public int getNumPaquetes() {
        return numPaquetes;
    }

    public void setNumPaquetes(int numPaquetes) {
        this.numPaquetes = numPaquetes;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Parametro getMoneda() {
        return moneda;
    }

    public void setMoneda(Parametro moneda) {
        this.moneda = moneda;
    }

    public Parametro getEstado() {
        return estado;
    }

    public void setEstado(Parametro estado) {
        this.estado = estado;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    public Aeropuerto getActual() {
        return actual;
    }

    public void setActual(Aeropuerto actual) {
        this.actual = actual;
    }

    public Cliente getRemitente() {
        return remitente;
    }

    public void setRemitente(Cliente remitente) {
        this.remitente = remitente;
    }

    public Cliente getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Cliente destinatario) {
        this.destinatario = destinatario;
    }

    public List<Escala> getEscalas() {
        return escalas;
    }

    public void setEscalas(List<Escala> escalas) {
        this.escalas = escalas;
    }

    public int getNumDocVenta() {
        return numDocVenta;
    }

    public void setNumDocVenta(int numDocVenta) {
        this.numDocVenta = numDocVenta;
    }

    public Parametro getTipoDocVenta() {
        return tipoDocVenta;
    }

    public void setTipoDocVenta(Parametro tipoDocVenta) {
        this.tipoDocVenta = tipoDocVenta;
    }
}
