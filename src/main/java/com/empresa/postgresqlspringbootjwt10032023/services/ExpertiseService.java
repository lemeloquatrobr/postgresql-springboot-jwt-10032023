package com.empresa.postgresqlspringbootjwt10032023.services;

import com.empresa.postgresqlspringbootjwt10032023.repositories.ExpertiseRepository;
import com.empresa.postgresqlspringbootjwt10032023.models.Expertise;
import com.empresa.postgresqlspringbootjwt10032023.responses.ExpertiseResponse;

public class ExpertiseService {

    ExpertiseRepository expertiseRepository = new ExpertiseRepository();

    // public ExpertiseResponse index() {
    //     return expertiseRepository.findAll();
    // }

    public ExpertiseResponse store(Expertise expertise) {
        return expertiseRepository.save(expertise);
    }
}