package com.gabrielpf.wodfeeder.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.gabrielpf.wodfeeder.model.auth.User;

import io.swagger.v3.oas.annotations.Hidden;

public class CreateUserForm {

    @NotBlank
    private final String firstName;

    @NotBlank
    private final String lastName;

    @NotBlank
    @Email
    private final String username;

    @NotBlank
    @Length(min = 8)
    private final String password;

    public CreateUserForm(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Hidden
    public User getUser(){
        return new User()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUsername(username)
                .setPassword(password)
                .setExpired(false)
                .setLocked(false)
                .setCredentialExpired(false)
                .setEnabled(true);
    }
}
