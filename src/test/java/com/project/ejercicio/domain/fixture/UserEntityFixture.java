package com.project.ejercicio.domain.fixture;

import com.project.ejercicio.domain.entity.PhoneEntity;
import com.project.ejercicio.domain.entity.UserEntity;
import com.project.ejercicio.domain.model.TokenModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserEntityFixture {
    public static UserEntity userEntityMock(){
        UserEntity user = new UserEntity();
        List<PhoneEntity> phones = new ArrayList<>();
        PhoneEntity phone = new PhoneEntity();
        phone.setCityCode("1");
        phone.setCountryCode("77");
        phone.setNumber("123456789");
        phones.add(phone);
        TokenModel token = new TokenModel();
        token.setJwt("Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJKV1QiLCJzdWIiOiJBZHJpw6FuIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTY4MTIyOTE5OCwiZXhwIjoxNjgxMjI5Nzk4fQ.nIAcNHEY7nZa2sNpteeC9tD9IHL8I2EaRqN3xg5Hzt6BjIER7dwi28Ykn4xBCqAKyV9T5-4CBYBPT_ssaZvNtA");
        user.setId("402880888771116501877111b5530000");
        user.setName("Adrián");
        user.setEmail("correo@correo.cl");
        user.setPassword("AA123aaaa");
        user.setPhones(phones);
        user.setCreated(String.valueOf(new Date()));
        user.setModified(String.valueOf(new Date()));
        user.setLast_login(String.valueOf(new Date()));
        user.setToken(token);
        user.setActive(true);
        return user;
    }
}
