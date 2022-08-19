package com.prueba.asd.service;

import com.prueba.asd.dto.ActivoFijoDto;

import java.util.Date;
import java.util.List;

public interface ActivoFijoService {

    ActivoFijoDto addActivoFijo(ActivoFijoDto activoFijoDto);

    ActivoFijoDto updateActivoFijo(ActivoFijoDto activoFijoDto, Long idActivoFijo);

    List<ActivoFijoDto> findByTipo(Long tipo);

    ActivoFijoDto findBySerial(String serial);

    List<ActivoFijoDto> findByFechaCompra(Date fechaCompra);
}
