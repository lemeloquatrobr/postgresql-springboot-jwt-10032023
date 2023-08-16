package com.empresa.postgresqlspringbootjwt10032023.services;

import com.empresa.postgresqlspringbootjwt10032023.repositories.ClinicRepository;
import com.empresa.postgresqlspringbootjwt10032023.models.Clinic;
import com.empresa.postgresqlspringbootjwt10032023.models.ClinicResponse;

public class ClinicService {

    ClinicRepository clinicRepository = new ClinicRepository();

    public ClinicResponse index() {
        return clinicRepository.findAll();
    }

    public ClinicResponse store(Clinic clinic) {
        return clinicRepository.save(clinic);
    }
}