package com.project.ejercicio.common.enumeration;

public enum ExceptionTextEnum {
    MESSAGE_EMAIL_ALREADY_EXIST("Este correo ya esta registrado"),

    MESSAGE_EMAIL_PASSWORD_PATTERN_WRONG("Falló la petición debido a que el correo ya existe o el formato del correo / contraseña es erróneo");


    private String value;

    ExceptionTextEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
