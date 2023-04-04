package com.empresa.postgresqlspringbootjwt10032023.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.empresa.postgresqlspringbootjwt10032023.services.UserService;
import com.empresa.postgresqlspringbootjwt10032023.models.User;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService = new UserService();

    @GetMapping
    public List<User> index() {

        List<User> users = userService.index();

        return users;
    }
}