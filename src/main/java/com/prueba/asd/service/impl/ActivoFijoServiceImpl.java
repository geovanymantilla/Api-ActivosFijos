package com.prueba.asd.service.impl;

import com.prueba.asd.dto.ActivoFijoDto;
import com.prueba.asd.entity.ActivoFijo;
import com.prueba.asd.entity.TipoActivoFijo;
import com.prueba.asd.exceptions.ActivoFijoNoEncontrado;
import com.prueba.asd.repository.ActivoFijoRepository;
import com.prueba.asd.repository.TipoActivoFijoRepository;
import com.prueba.asd.service.ActivoFijoService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * En esta clase ActivoFijoServiceImpl implementamos la interfaz ActivoFijoService donde implementaremos los metodos y crearemos toda la logica
 * @author Geovanny Mantilla
 */

@RequiredArgsConstructor
public class ActivoFijoServiceImpl implements ActivoFijoService {

    private final ActivoFijoRepository activoFijoRepository;
    private final ModelMapper modelMapper;
    private  final TipoActivoFijoRepository tipoActivoFijoRepository;
    public static Log LOG = LogFactory.getLog(ActivoFijoServiceImpl.class);


    /**
     *
     * @param activoFijoDto recibe como parametro un objeto activoFijo
     * @return retorna el objecto guardado
     */
    @Override
    public ActivoFijoDto addActivoFijo(ActivoFijoDto activoFijoDto) {
        LOG.debug("Creando Activo Fijo con la data{}");
        TipoActivoFijo tipoActivoFijo = tipoActivoFijoRepository.findById(activoFijoDto.getIdTipoActivoFijo())
                .orElseThrow(() ->new ActivoFijoNoEncontrado(HttpStatus.BAD_REQUEST, "El Activo fijo ya existe en la bd"));
        ActivoFijo activoFijo = modelMapper.map(activoFijoDto, ActivoFijo.class);
        activoFijo.setTipoActivoFijo(tipoActivoFijo);
        return modelMapper.map(activoFijoRepository.save(activoFijo), ActivoFijoDto.class);
    }

    @Override
    public ActivoFijoDto updateActivoFijo(ActivoFijoDto activoFijoDto, Long idActivoFijo) {
        LOG.info("Ingresando al actualizar");
        ActivoFijo activoFijo = activoFijoRepository.findById(idActivoFijo)
                .orElseThrow( () -> {
                    LOG.error("No se encontro el activo fijo ");
                   throw new ActivoFijoNoEncontrado(HttpStatus.BAD_REQUEST, "El Activo fijo no existe en la bd");
                });
        TipoActivoFijo tipoActivoFijo = tipoActivoFijoRepository.findById(activoFijoDto.getIdTipoActivoFijo())
                .orElseThrow(() ->{
                    LOG.error("No se encontro el tipo de activo fijo ");
                    throw new ActivoFijoNoEncontrado(HttpStatus.NOT_FOUND, "El tipo de activo fijo no se encontro en la bd");
                });
        activoFijo.setNombre(activoFijoDto.getNombre());
        activoFijo.setDescripcion(activoFijoDto.getDescripcion());
        activoFijo.setSerial(activoFijoDto.getSerial());
        activoFijo.setTipoActivoFijo(tipoActivoFijo);
        activoFijo.setAlto(activoFijoDto.getAlto());
        activoFijo.setAncho(activoFijoDto.getAncho());
        activoFijo.setLargo(activoFijoDto.getLargo());
        activoFijo.setPeso(activoFijoDto.getPeso());
        activoFijo.setNumeroInterno(activoFijoDto.getNumeroInterno());
        activoFijo.setValorCompra(activoFijoDto.getValorCompra());
        activoFijo.setFechaCompra(activoFijoDto.getFechaCompra());
        return modelMapper.map(activoFijoRepository.save(activoFijo), ActivoFijoDto.class);
    }

    @Override
    public List<ActivoFijoDto> findByTipo(Long tipo) {
        LOG.info("Buscando por tipo");
        TipoActivoFijo tipoActivoFijo = new TipoActivoFijo();

        tipoActivoFijo.setIdTipoActivoFijo(tipo);
        return  activoFijoRepository.findByTipoActivoFijo(tipoActivoFijo).stream()
                .map(tipoActivo -> modelMapper.map(tipoActivo, ActivoFijoDto.class)).collect(Collectors.toList());
    }

    @Override
    public ActivoFijoDto findBySerial(String serial) {
        ActivoFijo activoFijo = activoFijoRepository.findBySerial(serial);
        if (activoFijo == null){
            LOG.debug("ENTRA CUANDO ESTA VACIO");
            throw new ActivoFijoNoEncontrado(HttpStatus.NO_CONTENT, "No se encontro Activo Fijo con ese numero de serial");
        }

        return modelMapper.map(activoFijo, ActivoFijoDto.class);
    }

    @Override
    public List<ActivoFijoDto> findByFechaCompra(Date fechaCompra) {

        return  activoFijoRepository.findByFechaCompra(fechaCompra).stream()
                .map(tipoActivo -> modelMapper.map(tipoActivo, ActivoFijoDto.class)).collect(Collectors.toList());
    }
}
