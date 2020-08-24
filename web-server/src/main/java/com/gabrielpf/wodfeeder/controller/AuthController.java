package com.gabrielpf.wodfeeder.controller;

import javax.validation.Valid;

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
import com.gabrielpf.wodfeeder.controller.form.CreateUserForm;
import com.gabrielpf.wodfeeder.controller.form.UserLoginForm;
import com.gabrielpf.wodfeeder.service.UserService;
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
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TokenVO> login(@Valid @RequestBody UserLoginForm form) {
        final var authenticationToken = form.getAuthenticationToken();
        final var authentication = authManager.authenticate(authenticationToken);
        final var token = tokenService.generateToken(authentication);
        return ResponseEntity.ok(new TokenVO(token, AuthenticationTokenType.BEARER));
    }

    @PostMapping(value = "/signUp", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signUp(@Valid @RequestBody CreateUserForm form) {
        final var user = form.getUser();

        if (userService.hasUser(user))
            return ResponseEntity.status(400).body("Username already exists");

        try {
            final var userVO = userService.save(user);
            return ResponseEntity.ok(userVO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
