package com.project.ejercicio.data.model;

import javax.persistence.Embeddable;

@Embeddable
public class TokenModel {

    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
