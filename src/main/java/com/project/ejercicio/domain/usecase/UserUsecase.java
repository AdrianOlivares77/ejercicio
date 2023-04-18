package com.project.ejercicio.domain.usecase;

import com.project.ejercicio.domain.entity.UserEntity;
import com.project.ejercicio.domain.model.UserModel;

import java.util.List;

public interface UserUsecase {

    UserEntity createUser(UserModel user);

    List<UserEntity> getAllUsers();
}
