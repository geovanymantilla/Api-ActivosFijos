package com.prueba.asd.exceptions;

public class ResponseError {

    private String mensaje;

    public ResponseError(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
