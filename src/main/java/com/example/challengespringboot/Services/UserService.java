package com.example.challengespringboot.Services;

import com.example.challengespringboot.Models.UserApp;

import java.util.Optional;

public interface UserService {

    UserApp registerUser(UserApp newUser);

    UserApp findUser(String email, String password);

    UserApp findUserByName(String name);

    Optional<UserApp> findUserByEmail(String email);

}
