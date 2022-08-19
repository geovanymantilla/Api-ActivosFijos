package com.prueba.asd.exceptions;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.ConcurrentHashMap;

@RestControllerAdvice
public class HandlerException {

    private static ConcurrentHashMap<String,Integer> exceptions=new ConcurrentHashMap<>();

    public HandlerException() {
        exceptions.put(ActivoFijoError.class.getSimpleName(),400);
        exceptions.put(ActivoFijoNoEncontrado.class.getSimpleName(), 204);
        exceptions.put(ActivoFijoException.class.getSimpleName(), 400);
    }



    @ExceptionHandler(Exception.class)
    private Object handleException(Exception e){

        String mensaje = e.getMessage();
        Integer code=exceptions.get(e.getClass().getSimpleName());

        System.out.println(mensaje);

        if(code==null){
            return ResponseEntity.status(500).
                    body(new ResponseError("Ha ocurrido un error interno contacta al administrador"));
        }
        return ResponseEntity.status(code).
                body(new ResponseError(mensaje));
    }


}
