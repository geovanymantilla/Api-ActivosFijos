package com.prueba.asd.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Geovanny Mantilla
 */
@Builder
@Data
public class TipoActivoFijoDto {

    private Long idTipoActivoFijo;

    private String nombre;

    private String descripcion;
}
