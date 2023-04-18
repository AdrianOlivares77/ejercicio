package com.project.ejercicio.domain.fixture;

import com.project.ejercicio.domain.entity.PhoneEntity;
import com.project.ejercicio.domain.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserModelFixture {
    public static UserModel userModelMock(){
        UserModel user = new UserModel();
        List<PhoneEntity> phones = new ArrayList<>();
        PhoneEntity phone = new PhoneEntity();
        phone.setCityCode("1");
        phone.setCountryCode("77");
        phone.setNumber("123456789");
        phones.add(phone);
        user.setName("Adrián");
        user.setEmail("correo@correo.cl");
        user.setPassword("AA123aaaa");
        user.setPhones(phones);
        return user;
    }
}
