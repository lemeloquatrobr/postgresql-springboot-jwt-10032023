package com.empresa.postgresqlspringbootjwt10032023.services;

import com.empresa.postgresqlspringbootjwt10032023.repositories.CredentialRepository;
import com.empresa.postgresqlspringbootjwt10032023.models.Credential;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CredentialService {

    CredentialRepository credentialRepository = new CredentialRepository();

    private PasswordEncoder passwordEncoder;

    public CredentialService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void store(Credential credential) {
        String password = credential.getPassword();
        String bcryptPassword = passwordEncoder.encode(password);
        credential.setPassword(bcryptPassword);

        credentialRepository.save(credential);
    }
}