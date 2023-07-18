package com.empresa.postgresqlspringbootjwt10032023.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import com.empresa.postgresqlspringbootjwt10032023.services.UserService;
import com.empresa.postgresqlspringbootjwt10032023.services.CredentialService;
import com.empresa.postgresqlspringbootjwt10032023.models.User;
import com.empresa.postgresqlspringbootjwt10032023.models.UserEntity;
import com.empresa.postgresqlspringbootjwt10032023.models.Credential;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService = new UserService();

    private CredentialService credentialService;

    public UserController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @GetMapping
    public List<User> index() {
        List<User> users = userService.index();
        return users;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable int id) {
        UserEntity userEntity = userService.show(id);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    @PostMapping
    public void store(@RequestBody UserEntity userEntity) {
        User user = new User();
        user.setName(userEntity.getName());

        int userIdReturned = userService.store(user);

        List<Credential> credentials = userEntity.getCredentials();

        for (Credential credential: credentials) {
            credential.setUserId(userIdReturned);
            credentialService.store(credential);
        }
    }
}