package com.gabrielpf.wodfeeder.configuration.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.gabrielpf.wodfeeder.security.ApplicationUserPrincipal;
import com.gabrielpf.wodfeeder.security.AuthenticationService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Service
public class TokenAuthenticationService {

    @Value("${wodfeeder.jwt.expiration}")
    private long expirationDuration;

    @Value("${wodfeeder.jwt.secret}")
    private String secret;

    @Autowired
    private AuthenticationService authenticationService;

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

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            return false;
        }
    }

    public ApplicationUserPrincipal getUserPrincipal(String token) {
        final var username = Jwts
                .parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return authenticationService.loadUserByUsername(username);
    }
}
