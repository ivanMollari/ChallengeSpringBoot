package com.example.challengespringboot.Services;

import com.example.challengespringboot.Models.UserApp;
import com.example.challengespringboot.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserApp registerUser(UserApp newUser) {
        Optional<UserApp> searchedUser = userRepository.findUserByEmail(newUser.getEmail());
        if (searchedUser.isPresent()) {
            throw new IllegalStateException("this user already exists");
        }else{
            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        }
        return userRepository.save(newUser);
    }

    @Override
    public UserApp findUser(String email, String password) {
        Optional<UserApp> searchedUser = userRepository.findUserByEmail(email);
        if (searchedUser.isPresent()) {
            throw new IllegalStateException("this user already exists");
        }
        return null;
    }

    @Override
    public UserApp findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public Optional<UserApp> findUserByEmail(String email) {
        Optional<UserApp> searchedUser = userRepository.findUserByEmail(email);
        if(!searchedUser.isPresent()){
            throw new IllegalStateException("this user does not exists");
        }
        return searchedUser;
    }
}
