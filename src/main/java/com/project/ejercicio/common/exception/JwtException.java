package com.project.ejercicio.common.exception;

public class JwtException extends RuntimeException {

    public JwtException() { super(); }

    public JwtException(String message) { super(message); }

    public JwtException(String message, Throwable cause) { super(message, cause); }
}
