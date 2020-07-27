package com.gabrielpf.wodfeeder.configuration.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.gabrielpf.wodfeeder.security.ApplicationUserPrincipal;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenAuthenticationService {

    @Value("${wodfeeder.jwt.expiration}")
    private long expirationDuration;

    @Value("${wodfeeder.jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication) {
        final var creationTime = new Date();
        final var expirationTime = new Date(creationTime.getTime() + expirationDuration);

        final var principal = (ApplicationUserPrincipal) authentication.getPrincipal();

        return Jwts.builder()
                .setIssuer("WodFeeder")
                .setIssuedAt(creationTime)
                .setExpiration(expirationTime)
                .setSubject(principal.getUsername())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
