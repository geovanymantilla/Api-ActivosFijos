package com.prueba.asd.entity;

import lombok.Builder;
import lombok.Data;


import javax.persistence.*;

/**
 * TipoActivoFijo va a representar los tipos de activos fijos de una empresa
 * como pueden ser bienes inmubles,maquinaria, material de oficina, etc.
 * @author Geovanny Mantilla
 */

@Entity
@Data
@Table(name = "tipoactivofijo", schema = "inventario")
public class TipoActivoFijo {
    @Id
    @Column(name = "tiaf_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoActivoFijo;

    @Column(name = "tiaf_nombre", nullable = false)
    private String nombre;

    @Column(name = "tiaf_descripcion")
    private String descripcion;
}
