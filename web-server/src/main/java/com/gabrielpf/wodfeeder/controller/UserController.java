package com.gabrielpf.wodfeeder.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielpf.wodfeeder.controller.form.CreateUserForm;

@RestController
@RequestMapping(path = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private AuthController authController;

    @PreAuthorize("hasAuthority('admin')")
    // TODO - group authorities into Roles -> https://www.baeldung.com/role-and-privilege-for-spring-security-registration
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserForm form) {
        return authController.signUp(form);
    }
}
