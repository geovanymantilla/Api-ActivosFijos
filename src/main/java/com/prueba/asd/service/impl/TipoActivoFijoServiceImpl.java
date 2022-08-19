package com.prueba.asd.service.impl;

import com.prueba.asd.dto.ActivoFijoDto;
import com.prueba.asd.dto.TipoActivoFijoDto;
import com.prueba.asd.entity.ActivoFijo;
import com.prueba.asd.entity.TipoActivoFijo;
import com.prueba.asd.exceptions.ActivoFijoError;
import com.prueba.asd.repository.ActivoFijoRepository;
import com.prueba.asd.repository.TipoActivoFijoRepository;
import com.prueba.asd.service.TipoActivoFijoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
@RequiredArgsConstructor
public class TipoActivoFijoServiceImpl implements TipoActivoFijoService {

    private final TipoActivoFijoRepository tipoActivoFijoRepository;
    private final ModelMapper modelMapper;

    @Override
    public TipoActivoFijoDto addTipoActivoFijo(TipoActivoFijoDto tipoActivoFijoDto) {
        if (tipoActivoFijoDto == null){
            throw new ActivoFijoError("Error Activo fijo Nulo");
        }
        TipoActivoFijo tipoActivoFijo = modelMapper.map(tipoActivoFijoDto, TipoActivoFijo.class);
        return modelMapper.map(tipoActivoFijoRepository.save(tipoActivoFijo), TipoActivoFijoDto.class);
    }
}
