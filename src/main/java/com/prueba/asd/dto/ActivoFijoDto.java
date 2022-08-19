package com.prueba.asd.dto;

import com.prueba.asd.entity.TipoActivoFijo;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Geovanny Mantilla
 */
@Builder
@Data
public class ActivoFijoDto {
    @NotBlank(message = "nombre no puede ser nulo")
    private String nombre;

    @NotBlank(message = "descripción no puede ser nula")
    private String descripcion;

    @NotNull(message = "tipo de activo no puede ser nulo")
    private Long idTipoActivoFijo;

    @NotBlank(message = "serial no puede ser nulo")
    private String serial;

    @NotNull(message = "numero interno no puede ser nulo")
    private Integer numeroInterno;

    @NotNull(message = "peso no puede ser nulo")
    private Double peso;

    @NotNull(message = "alto no puede ser nulo")
    private Double alto;

    @NotNull(message = "ancho no puede ser nulo")
    private Double ancho;

    @NotNull(message = "largo no puede ser nulo")
    private Double largo;

    @NotNull(message = "valor compra no puede ser nulo" )
    private Double valorCompra;

    @NotNull(message = "fecha compra no puede ser nula")
    private Date fechaCompra;

    public ActivoFijoDto() {}

    public ActivoFijoDto(String nombre, String descripcion, Long idTipoActivoFijo, String serial, Integer numeroInterno, Double peso, Double alto, Double ancho, Double largo, Double valorCompra, Date fechaCompra) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idTipoActivoFijo = idTipoActivoFijo;
        this.serial = serial;
        this.numeroInterno = numeroInterno;
        this.peso = peso;
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
        this.valorCompra = valorCompra;
        this.fechaCompra = fechaCompra;
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

    public Long getIdTipoActivoFijo() {
        return idTipoActivoFijo;
    }

    public void setIdTipoActivoFijo(Long idTipoActivoFijo) {
        this.idTipoActivoFijo = idTipoActivoFijo;
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
