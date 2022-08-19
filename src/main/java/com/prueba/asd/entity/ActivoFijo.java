package com.prueba.asd.entity;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * ActivoFijo va a representar los vienes materiales de una empresa
 * @author Geovanny Mantilla
 */
@Builder
@Entity
@Data
@Table(name = "activofijo", schema = "inventario")
public class ActivoFijo{

    @Id
    @Column(name = "acfi_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActivoFijo;

    @Column(name = "acfi_nombre", nullable = false)
    private String nombre;

    @Column(name = "acfi_descripcion")
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tiaf_id", referencedColumnName = "tiaf_id", nullable = false)
    private TipoActivoFijo tipoActivoFijo;

    @Column(name = "acfi_serial")
    private String serial;

    @Column(name = "acfi_numerointerno")
    private Integer numeroInterno;

    @Column(name = "acfi_peso")
    private Double peso;

    @Column(name = "acfi_alto")
    private Double alto;

    @Column(name = "acfi_ancho")
    private Double ancho;

    @Column(name = "acfi_largo")
    private Double largo;

    @Column(name = "acfi_valorcompra")
    private Double valorCompra;

    @Column(name = "acfi_fechacompra")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date fechaCompra;

    public ActivoFijo() {
    }

    public ActivoFijo(Long idActivoFijo, String nombre, String descripcion, TipoActivoFijo tipoActivoFijo, String serial, Integer numeroInterno, Double peso, Double alto, Double ancho, Double largo, Double valorCompra, Date fechaCompra) {
        this.idActivoFijo = idActivoFijo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoActivoFijo = tipoActivoFijo;
        this.serial = serial;
        this.numeroInterno = numeroInterno;
        this.peso = peso;
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
        this.valorCompra = valorCompra;
        this.fechaCompra = fechaCompra;
    }

    public Long getIdActivoFijo() {
        return idActivoFijo;
    }

    public void setIdActivoFijo(Long idActivoFijo) {
        this.idActivoFijo = idActivoFijo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoActivoFijo getTipoActivoFijo() {
        return tipoActivoFijo;
    }

    public void setTipoActivoFijo(TipoActivoFijo tipoActivoFijo) {
        this.tipoActivoFijo = tipoActivoFijo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getNumeroInterno() {
        return numeroInterno;
    }

    public void setNumeroInterno(Integer numeroInterno) {
        this.numeroInterno = numeroInterno;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Double getLargo() {
        return largo;
    }

    public void setLargo(Double largo) {
        this.largo = largo;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
