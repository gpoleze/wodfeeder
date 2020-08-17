package com.gabrielpf.wodfeeder.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielpf.wodfeeder.configuration.security.TokenAuthenticationService;
import com.gabrielpf.wodfeeder.controller.form.UserLoginForm;
import com.gabrielpf.wodfeeder.security.GoogleAccessTokenVerifier;
import com.gabrielpf.wodfeeder.vo.AuthenticationTokenType;
import com.gabrielpf.wodfeeder.vo.TokenVO;

@RestController
@RequestMapping(path = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenAuthenticationService tokenService;

    @Autowired
    private GoogleAccessTokenVerifier googleVerifier;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TokenVO> login(@RequestBody UserLoginForm form) {
        try {
            final var authenticationToken = form.getAuthenticationToken();
            final var authentication = authManager.authenticate(authenticationToken);
            final var token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(new TokenVO(token, AuthenticationTokenType.BEARER));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(path = "/google", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> googleLogin(@RequestBody String accessToken) {
//        System.out.println(accessToken);
        try {
            googleVerifier.verify(accessToken);
            return ResponseEntity.ok(accessToken);
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
