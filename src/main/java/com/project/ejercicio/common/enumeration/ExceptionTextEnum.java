package com.project.ejercicio.common.enumeration;

public enum ExceptionTextEnum {
    MESSAGE_EMAIL_ALREADY_EXIST("Este correo ya esta registrado"),

    MESSAGE_EMAIL_PASSWORD_PATTERN_WRONG("Falto ingresar un campo o el formato de la contraseña / correo no son válidos");


    private String value;

    ExceptionTextEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
