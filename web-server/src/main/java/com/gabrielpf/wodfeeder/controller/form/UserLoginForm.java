package com.gabrielpf.wodfeeder.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.swagger.v3.oas.annotations.Hidden;

public class UserLoginForm {
    @NotEmpty
    @Email
    private String username;

    @NotEmpty
    @Length(min = 8)
    private String password;

    protected UserLoginForm() {}

    public UserLoginForm(@NotEmpty @Email String username, @NotEmpty @Length(min = 8) String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Hidden
    public UsernamePasswordAuthenticationToken getAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
