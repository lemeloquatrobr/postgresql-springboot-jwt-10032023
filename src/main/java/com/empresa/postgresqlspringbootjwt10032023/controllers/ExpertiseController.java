package com.empresa.postgresqlspringbootjwt10032023.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.empresa.postgresqlspringbootjwt10032023.models.Expertise;
import com.empresa.postgresqlspringbootjwt10032023.services.ExpertiseService;
import com.empresa.postgresqlspringbootjwt10032023.responses.ExpertiseResponse;

@CrossOrigin
@RestController
@RequestMapping("/expertises")
public class ExpertiseController {

    ExpertiseService expertiseService = new ExpertiseService();

    // @GetMapping
    // public ResponseEntity<ExpertiseResponse> index() {
    //     ExpertiseResponse expertiseResponse = expertiseService.index();
    //     if (expertiseResponse.getSqlExecute()) {
    //         return new ResponseEntity<ExpertiseResponse>(expertiseResponse, HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<ExpertiseResponse>(expertiseResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    @PostMapping
    public ResponseEntity<ExpertiseResponse> store(@RequestBody Expertise expertise) {
        ExpertiseResponse expertiseResponse = expertiseService.store(expertise);
        if (expertiseResponse.getSqlExecute()) {
            return new ResponseEntity<ExpertiseResponse>(expertiseResponse, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<ExpertiseResponse>(expertiseResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}