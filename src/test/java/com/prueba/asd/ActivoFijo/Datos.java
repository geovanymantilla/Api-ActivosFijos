package com.prueba.asd.ActivoFijo;

import com.prueba.asd.dto.ActivoFijoDto;
import com.prueba.asd.dto.TipoActivoFijoDto;
import com.prueba.asd.entity.ActivoFijo;
import com.prueba.asd.entity.TipoActivoFijo;

import java.util.Date;

public class Datos {

    public static ActivoFijoDto getActivoFijoDto(){

        return ActivoFijoDto.builder().idTipoActivoFijo(1L)
                .nombre("Silla Gerencial")
                .idTipoActivoFijo(1L)
                .descripcion("Silla Gerencial oficina 1")
                .alto(12.3)
                .ancho(5.2)
                .peso(15.2)
                .largo(12.3)
                .serial("XSD123")
                .numeroInterno(156)
                .valorCompra(285600.00)
                .fechaCompra( new Date())
                .build();
    }

    public static ActivoFijo getActivoFijo(){
    TipoActivoFijo tipoActivoFijo = new TipoActivoFijo();
        tipoActivoFijo.setIdTipoActivoFijo(1L);
        tipoActivoFijo.setNombre("material de oficina");
        return ActivoFijo.builder().idActivoFijo(1L)
                .nombre("Silla Gerencial")
                .tipoActivoFijo(tipoActivoFijo)
                .descripcion("Silla Gerencial oficina 1")
                .alto(12.3)
                .ancho(5.2)
                .peso(15.2)
                .largo(12.3)
                .serial("XSD123")
                .numeroInterno(156)
                .valorCompra(285600.00)
                .fechaCompra( new Date())
                .build();
    }

    public static TipoActivoFijo getTipoActivoFijo(){
        TipoActivoFijo tipoActivoFijo = new TipoActivoFijo();
        tipoActivoFijo.setIdTipoActivoFijo(1L);
        tipoActivoFijo.setNombre("Maquinaria");
        tipoActivoFijo.setDescripcion("Maquinaria de la obra");
        return tipoActivoFijo;
    }
}
