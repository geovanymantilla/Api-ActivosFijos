package com.prueba.asd.exceptions;

import org.springframework.http.HttpStatus;

public class ActivoFijoNoEncontrado extends RuntimeException{

    private HttpStatus httpStatus;
    public ActivoFijoNoEncontrado(HttpStatus httpStatus,String mensaje){

        super(mensaje);
        this.httpStatus = httpStatus;
    }
}
