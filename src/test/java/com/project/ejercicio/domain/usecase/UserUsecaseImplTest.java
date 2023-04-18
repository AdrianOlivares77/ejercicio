package com.project.ejercicio.domain.usecase;

import com.project.ejercicio.common.controller.TokenController;
import com.project.ejercicio.common.exception.ValidationException;
import com.project.ejercicio.domain.entity.UserEntity;
import com.project.ejercicio.domain.mapper.UserMapper;
import com.project.ejercicio.domain.model.TokenModel;
import com.project.ejercicio.domain.model.UserModel;
import com.project.ejercicio.domain.repository.JPARepository;
import com.project.ejercicio.domain.fixture.TokenModelFixture;
import com.project.ejercicio.domain.fixture.UserEntityFixture;
import com.project.ejercicio.domain.fixture.UserModelFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserUsecaseImplTest {

    @InjectMocks
    UserUsecaseImpl usecase;

    @Mock
    UserMapper mapper;

    @Mock
    TokenController tokenController;

    @Mock
    JPARepository repository;

    final String email = "correo@correo.cl";

    final String tokenJWT = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJKV1QiLCJzdWIiOiJBZHJpw6FuIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTY4MTIyOTE5OCwiZXhwIjoxNjgxMjI5Nzk4fQ.nIAcNHEY7nZa2sNpteeC9tD9IHL8I2EaRqN3xg5Hzt6BjIER7dwi28Ykn4xBCqAKyV9T5-4CBYBPT_ssaZvNtA";



    @BeforeEach
    void setUp() {
        this.usecase = new UserUsecaseImpl(mapper, repository, tokenController);
    }

    @Test
    void when_createUser_respond_successful(){
        TokenModel token = TokenModelFixture.tokenModelMock();
        UserModel userNotMapped = UserModelFixture.userModelMock();
        UserEntity userMapped = UserEntityFixture.userEntityMock();

        Mockito.when(mapper.map(userNotMapped)).thenReturn(userMapped);
        Mockito.when(tokenController.login(userMapped.getName())).thenReturn(token);
        Assertions.assertNotNull(usecase.createUser(userNotMapped));
    }

    @Test
    void when_createUser_throws_INTERNAL_ERROR(){
        TokenModel token = TokenModelFixture.tokenModelMock();
        UserModel userNotMapped = UserModelFixture.userModelMock();
        UserEntity userMapped = UserEntityFixture.userEntityMock();

        Mockito.when(mapper.map(userNotMapped)).thenReturn(userMapped);
        Mockito.when(tokenController.login(userMapped.getName())).thenReturn(token);
        Mockito.when(usecase.createUser(userNotMapped)).thenThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST));
        Assertions.assertThrows(ValidationException.class, ()-> usecase.createUser(userNotMapped));
    }


}
