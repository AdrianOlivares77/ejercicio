package com.project.ejercicio.data.model;

import com.project.ejercicio.data.entity.PhoneEntity;

import java.util.List;

public class UserModel {
    private String name;
    private String email;
    private String password;
    private List<PhoneEntity> phones;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PhoneEntity> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneEntity> phones) {
        this.phones = phones;
    }

}
