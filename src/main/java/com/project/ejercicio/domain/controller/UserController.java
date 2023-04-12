package com.project.ejercicio.domain.controller;

import com.project.ejercicio.domain.usecase.UserUsecaseImpl;
import com.project.ejercicio.data.entity.UserEntity;
import com.project.ejercicio.data.model.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserUsecaseImpl usecase;

    public UserController(UserUsecaseImpl usecase) {
        this.usecase = usecase;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public UserEntity createUser(@RequestBody UserModel user) {
        UserEntity userCreated = usecase.createUser(user);
        return userCreated;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<UserEntity> getAllUsers(){
        List<UserEntity> allUsers = usecase.getAllUsers();
        return allUsers;
    }
}
