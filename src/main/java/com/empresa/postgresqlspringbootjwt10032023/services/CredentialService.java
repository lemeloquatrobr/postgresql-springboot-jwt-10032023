package com.empresa.postgresqlspringbootjwt10032023.services;

import com.empresa.postgresqlspringbootjwt10032023.repositories.CredentialRepository;
import com.empresa.postgresqlspringbootjwt10032023.models.Credential;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

@Service
public class CredentialService {

    CredentialRepository credentialRepository = new CredentialRepository();

    private PasswordEncoder passwordEncoder;

    public CredentialService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public List<Credential> index() {
        return credentialRepository.findAll();
    }

    public Credential getCredentialByEmail(String email) {
        return credentialRepository.getCredentialByEmail(email);
    }

    public void store(Credential credential) {
        String password = credential.getPassword();
        String bcryptPassword = passwordEncoder.encode(password);
        credential.setPassword(bcryptPassword);

        credentialRepository.save(credential);
    }

    public Boolean validatePassword(String password, String passwordByEmail) {
        return this.passwordEncoder.matches(password, passwordByEmail);
    }

    public String generateToken(Credential credential) {
        String email = credential.getEmail();

        String token = Jwts.builder()
            .setSubject(email)
            .setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + 60 * 60 * 24 * 1000))
            .signWith(SignatureAlgorithm.HS256, "SECRET_KEY")
            .compact();

        return token;
    }
}