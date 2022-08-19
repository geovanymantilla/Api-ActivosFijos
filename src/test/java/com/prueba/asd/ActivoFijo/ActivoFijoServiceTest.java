package com.prueba.asd.ActivoFijo;

import com.prueba.asd.dto.ActivoFijoDto;
import com.prueba.asd.entity.ActivoFijo;
import com.prueba.asd.exceptions.ActivoFijoNoEncontrado;
import com.prueba.asd.repository.ActivoFijoRepository;
import com.prueba.asd.repository.TipoActivoFijoRepository;
import com.prueba.asd.service.impl.ActivoFijoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ActivoFijoServiceTest {

    @Mock
    ActivoFijoRepository activoFijoRepository;

    @Mock
    TipoActivoFijoRepository tipoActivoFijoRepository;

    @InjectMocks
    ActivoFijoServiceImpl activoFijoService;

    @BeforeEach
    void config(){
//        MockitoAnnotations.openMocks(this);
        activoFijoService = new ActivoFijoServiceImpl(activoFijoRepository, new ModelMapper(),tipoActivoFijoRepository);
    }

    @Test
    void testBucarActivoFijoBySerial(){
        Mockito.when(activoFijoRepository.findBySerial(anyString()))
                .thenReturn(Datos.getActivoFijo());
        ActivoFijoDto activoFijoDto = activoFijoService.findBySerial("XSD123");
        assertEquals("XSD123", activoFijoDto.getSerial());

    }

    @Test
    void testBucarActivoFijoBySerialThrowException(){
        Mockito.when(activoFijoRepository.findBySerial(anyString()))
                .thenReturn(isNull());
        Exception exception = assertThrows(ActivoFijoNoEncontrado.class, () -> {
            activoFijoService.findBySerial("");
        });
        assertEquals(ActivoFijoNoEncontrado.class, exception.getClass());

    }

    @Test
    void testBuscarActivoFijoByFechaCompra(){
        List<ActivoFijo> listActivoFijo = new ArrayList<>();
        Mockito.when(activoFijoRepository.findByFechaCompra(any()))
                .thenReturn(listActivoFijo);

        List<ActivoFijoDto> activoFijoDto = activoFijoService.findByFechaCompra(new Date());
        assertEquals(true, activoFijoDto.isEmpty());
    }

    @Test
    void testBuscarActivoFijoByTipo(){
        List<ActivoFijo> listActivoFijo = new ArrayList<>();
        Mockito.when(activoFijoRepository.findByTipoActivoFijo(any()))
                .thenReturn(listActivoFijo);
        List<ActivoFijoDto> activoFijoDto = activoFijoService.findByTipo(1L);
        assertEquals(true, activoFijoDto.isEmpty());
    }

    @Test
    void testAgregarActivoFijo(){

        Mockito.when(tipoActivoFijoRepository.findById(anyLong()))
                .thenReturn(Optional.of(Datos.getTipoActivoFijo()));
        Mockito.when(activoFijoRepository.save(any()))
                .thenReturn(Datos.getActivoFijo());
        ActivoFijoDto activoFijoDto = activoFijoService.addActivoFijo(Datos.getActivoFijoDto());

    }

    @Test
    void testUpdateActivoFijo(){
        Mockito.when(activoFijoRepository.findById(1L))
                .thenReturn(Optional.of(Datos.getActivoFijo()));
        Mockito.when(tipoActivoFijoRepository.findById(1L))
                .thenReturn(Optional.of(Datos.getTipoActivoFijo()));
        Mockito.when(activoFijoRepository.save(any()))
                .thenReturn(Datos.getActivoFijo());
        ActivoFijoDto activoFijoDto = activoFijoService.updateActivoFijo(Datos.getActivoFijoDto(), 1L);


    }

    @Test
    void testUpdateActivoFijoThrowException(){
        Mockito.when(activoFijoRepository.findById(any()))
                .thenReturn(Optional.empty());
        Exception exception = assertThrows(ActivoFijoNoEncontrado.class, () -> {
            activoFijoService.updateActivoFijo(Datos.getActivoFijoDto(),1L);
        });
        assertEquals(ActivoFijoNoEncontrado.class, exception.getClass());

    }

    @Test
    void testUpdateActivoFijoThrowException2(){
        Mockito.when(activoFijoRepository.findById(1L))
                .thenReturn(Optional.of(Datos.getActivoFijo()));
        Mockito.when(tipoActivoFijoRepository.findById(any()))
                .thenReturn(Optional.empty());
        Exception exception = assertThrows(ActivoFijoNoEncontrado.class, () -> {
            activoFijoService.updateActivoFijo(Datos.getActivoFijoDto(),1L);
        });
        assertEquals(ActivoFijoNoEncontrado.class, exception.getClass());

    }

}
