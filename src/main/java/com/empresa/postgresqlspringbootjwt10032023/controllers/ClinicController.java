package com.empresa.postgresqlspringbootjwt10032023.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.empresa.postgresqlspringbootjwt10032023.models.Clinic;
import com.empresa.postgresqlspringbootjwt10032023.services.ClinicService;
import com.empresa.postgresqlspringbootjwt10032023.models.ClinicResponse;

@CrossOrigin
@RestController
@RequestMapping("/clinics")
public class ClinicController {

    ClinicService clinicService = new ClinicService();

    @PostMapping
    public ResponseEntity<ClinicResponse> store(@RequestBody Clinic clinic) {
        ClinicResponse clinicResponse = clinicService.store(clinic);
        if (clinicResponse.getSqlExecute()) {
            return new ResponseEntity<ClinicResponse>(clinicResponse, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<ClinicResponse>(clinicResponse, HttpStatus.OK);
        }
    }
}