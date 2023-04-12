package com.project.ejercicio.common.exception;

public class ExceptionResponse {
    private String mensaje;

    public ExceptionResponse(String message) {
        super();
        this.mensaje = message;
    }

    public String getMensaje() {
        return mensaje;
    }

}
