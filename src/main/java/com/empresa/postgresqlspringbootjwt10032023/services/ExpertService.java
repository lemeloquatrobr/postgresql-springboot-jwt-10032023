package com.empresa.postgresqlspringbootjwt10032023.services;

import com.empresa.postgresqlspringbootjwt10032023.repositories.ExpertRepository;
import com.empresa.postgresqlspringbootjwt10032023.models.Expert;
import com.empresa.postgresqlspringbootjwt10032023.responses.ExpertResponse;

public class ExpertService {

    ExpertRepository expertRepository = new ExpertRepository();

    public ExpertResponse index() {
        return expertRepository.findAll();
    }

    public ExpertResponse store(Expert expert) {
        return expertRepository.save(expert);
    }
}