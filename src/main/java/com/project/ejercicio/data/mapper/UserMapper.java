package com.project.ejercicio.data.mapper;

import com.project.ejercicio.data.entity.UserEntity;
import com.project.ejercicio.data.model.UserModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    UserEntity map(UserModel user);
}
