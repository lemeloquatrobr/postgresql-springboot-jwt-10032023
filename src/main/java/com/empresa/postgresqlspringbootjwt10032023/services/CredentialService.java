package com.empresa.postgresqlspringbootjwt10032023.services;

import com.empresa.postgresqlspringbootjwt10032023.repositories.CredentialRepository;
import com.empresa.postgresqlspringbootjwt10032023.models.Credential;

public class CredentialService {

    CredentialRepository credentialRepository = new CredentialRepository();

    public void store(Credential credential) {
        credentialRepository.save(credential);
    }
}