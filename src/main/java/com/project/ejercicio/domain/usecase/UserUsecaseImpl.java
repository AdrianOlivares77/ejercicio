package com.project.ejercicio.domain.usecase;

import com.project.ejercicio.common.controller.TokenController;
import com.project.ejercicio.common.enumeration.ExceptionTextEnum;
import com.project.ejercicio.common.exception.ValidationException;
import com.project.ejercicio.domain.entity.UserEntity;
import com.project.ejercicio.domain.mapper.UserMapper;
import com.project.ejercicio.domain.model.UserModel;
import com.project.ejercicio.domain.repository.JPARepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserUsecaseImpl implements UserUsecase {


    UserMapper mapper;

    TokenController tokenController;

    JPARepository repository;

    public UserUsecaseImpl(UserMapper mapper, JPARepository repository, TokenController tokenController){

        this.mapper = mapper;
        this.repository = repository;
        this.tokenController = tokenController;
    }

    public UserEntity createUser(UserModel user) {
        try {
            UserEntity userCreated = mapper.map(user);
            userCreated.setCreated(String.valueOf(new Date()));
            userCreated.setModified(String.valueOf(new Date()));
            userCreated.setLast_login(String.valueOf(new Date()));
            userCreated.setToken(tokenController.login(userCreated.getName()));
            userCreated.setActive(true);
            try{
                repository.save(userCreated);
                return userCreated;
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,ExceptionTextEnum.MESSAGE_EMAIL_PASSWORD_PATTERN_WRONG.getValue());
            }
        } catch (Exception e) {
            throw new ValidationException(e.getMessage());
        }

    }

    public List<UserEntity> getAllUsers() {
        return repository.findAll();
    }
}
