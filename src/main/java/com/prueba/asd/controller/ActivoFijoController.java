package com.prueba.asd.controller;

import com.prueba.asd.dto.ActivoFijoDto;
import com.prueba.asd.exceptions.ActivoFijoException;
import com.prueba.asd.service.ActivoFijoService;
import com.prueba.asd.service.impl.ActivoFijoServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Geovanny Mantilla
 */

@RestController
@RequestMapping("api/v1/activos")
@RequiredArgsConstructor
public class ActivoFijoController {

    private final ActivoFijoService activoFijoService;
    public static Log LOG = LogFactory.getLog(ActivoFijoController.class);

    /**
     *
     * @param activoFijoDto objeto de activoFijo a guardar
     * @param result se usa para almacenar el resultado de la validacion
     * @return retorna el objeto creado
     */
    @ApiOperation(value = "Guardar",notes = "Guardar ActivoFijo en la bd")
    @ApiResponses(value = {@ApiResponse(code = 201,message = "Entidad guardada"),@ApiResponse(code =204,message = "a response whitout body whit status 204",response =List.class)})
    @PostMapping
    public ResponseEntity<ActivoFijoDto> addActivoFijo(@Valid @RequestBody ActivoFijoDto activoFijoDto, BindingResult result){
        if (result.hasErrors()){
            LOG.error("ERROR al guardar el activo fijo");
            throw new ActivoFijoException(result.getAllErrors().stream()
                    .map(errors -> errors.getObjectName()+" : "+errors.getDefaultMessage()).collect(Collectors.joining()));
        }
       return new ResponseEntity<>(activoFijoService.addActivoFijo(activoFijoDto),HttpStatus.OK);
    }

    /**
     *
     * @param activoFijoDto objeto de tipo activofijo con la data a modificar
     * @param result se usa para almacenar el resultado de la validacion
     * @param idActivoFijo id del activo fijo a modificar
     * @return retorna el activoFijo modificado
     */
    @PutMapping("/{idActivoFijo}")
    public ResponseEntity<ActivoFijoDto> updateActivoFijo (@Valid @RequestBody ActivoFijoDto activoFijoDto, BindingResult result, @PathVariable Long idActivoFijo){
        if (result.hasErrors()){
            LOG.error("ERROR al actualizar el activo fijo");
            throw new ActivoFijoException(result.getAllErrors().stream()
                    .map(errors -> errors.getObjectName()+" : "+errors.getDefaultMessage()).collect(Collectors.joining()));
        }
        return new ResponseEntity<>(activoFijoService.updateActivoFijo(activoFijoDto,idActivoFijo ), HttpStatus.OK);
    }

    /**
     *
     * @param idTipoActivoFijo recibe como parametro el id del tipo de activo fijo
     * @return retorna una lista con los activos fijos del tipo de activo fijo ingresado como parametro
     */
    @GetMapping("/tipoActivoFijo/{idTipoActivoFijo}")
    public ResponseEntity<List<ActivoFijoDto>> findByIdTipoActivoFijo(@PathVariable Long idTipoActivoFijo){
        return  new ResponseEntity<>(activoFijoService.findByTipo(idTipoActivoFijo), HttpStatus.OK);
    }

    /**
     *
     * @param fechaCompra recibe como parametro la fecha de compra
     * @return retorna una lista de activos fijo agregados en la fecha especificada
     * @throws ParseException se usa para el parseo de string a date
     */
    @GetMapping("/fechaCompra/{fechaCompra}")
    public ResponseEntity<List<ActivoFijoDto>> findByFechaCompra(@PathVariable String fechaCompra) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = formato.parse(fechaCompra);
        return  new ResponseEntity<>(activoFijoService.findByFechaCompra(fecha), HttpStatus.OK);
    }

    /**
     *
     * @param serial recibe como parametro un string que especifica el serial del activoFijo a buscar
     * @return retorna un onjecto de activoFijo que corresponda al serial especificado
     */
    @GetMapping("/serial/{serial}")
    public ResponseEntity<ActivoFijoDto> findBySerial(@PathVariable String serial){
        return  new ResponseEntity<>(activoFijoService.findBySerial(serial), HttpStatus.OK);
    }

}
