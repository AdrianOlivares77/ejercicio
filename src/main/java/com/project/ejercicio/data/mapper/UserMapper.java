package com.project.ejercicio.data.mapper;

import com.project.ejercicio.data.entity.UserEntity;
import com.project.ejercicio.data.model.UserModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    @Mapping(target="id", ignore = true)
    @Mapping(target="created", ignore = true)
    @Mapping(target="modified", ignore = true)
    @Mapping(target="last_login", ignore = true)
    @Mapping(target="token", ignore = true)
    @Mapping(target="active", ignore = true)
    UserEntity map(UserModel user);
}
