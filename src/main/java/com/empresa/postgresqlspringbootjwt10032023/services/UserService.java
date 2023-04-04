package com.empresa.postgresqlspringbootjwt10032023.services;

import java.util.List;

import com.empresa.postgresqlspringbootjwt10032023.repositories.UserRepository;
import com.empresa.postgresqlspringbootjwt10032023.models.User;

public class UserService {

    UserRepository userRepository = new UserRepository();

    public List<User> index() {
        return userRepository.findAll();
    }
}