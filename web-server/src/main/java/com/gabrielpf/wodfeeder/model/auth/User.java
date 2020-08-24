package com.gabrielpf.wodfeeder.model.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gabrielpf.wodfeeder.controller.form.CreateUserForm;
import com.gabrielpf.wodfeeder.model.EntityWithUuid;

@Entity
@Table(name = "user")
public class User extends EntityWithUuid {

    @Column(name = "first_name", nullable = false, length = 128)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 128)
    private String lastName;

    @Column(unique = true, nullable = false, length = 128)
    private String username;

    @Column(nullable = false, length = 128)
    private String password;

    @Column
    private boolean expired = false;

    @Column
    private boolean locked = false;

    @Column(name = "credentials_expired")
    private boolean credentialExpired = false;

    @Column
    private boolean enabled = true;

    public User() {}

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isExpired() {
        return expired;
    }

    public User setExpired(boolean expired) {
        this.expired = expired;
        return this;
    }

    public boolean isLocked() {
        return locked;
    }

    public User setLocked(boolean locked) {
        this.locked = locked;
        return this;
    }

    public boolean isCredentialExpired() {
        return credentialExpired;
    }

    public User setCredentialExpired(boolean credentialExpired) {
        this.credentialExpired = credentialExpired;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public User setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }
}
