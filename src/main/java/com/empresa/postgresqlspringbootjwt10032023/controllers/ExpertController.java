package com.empresa.postgresqlspringbootjwt10032023.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.empresa.postgresqlspringbootjwt10032023.models.Expert;
import com.empresa.postgresqlspringbootjwt10032023.services.ExpertService;
import com.empresa.postgresqlspringbootjwt10032023.responses.ExpertResponse;

@CrossOrigin
@RestController
@RequestMapping("/experts")
public class ExpertController {

    ExpertService expertService = new ExpertService();

    @GetMapping
    public ResponseEntity<ExpertResponse> index() {
        ExpertResponse expertResponse = expertService.index();
        if (expertResponse.getSqlExecute()) {
            return new ResponseEntity<ExpertResponse>(expertResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<ExpertResponse>(expertResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<ExpertResponse> store(@RequestBody Expert expert) {
        ExpertResponse expertResponse = expertService.store(expert);
        if (expertResponse.getSqlExecute()) {
            return new ResponseEntity<ExpertResponse>(expertResponse, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<ExpertResponse>(expertResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}