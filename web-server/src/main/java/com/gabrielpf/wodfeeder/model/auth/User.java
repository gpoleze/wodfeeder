package com.gabrielpf.wodfeeder.model.auth;

import java.security.Provider;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;

import com.gabrielpf.wodfeeder.model.EntityWithUuid;
import com.gabrielpf.wodfeeder.security.oauth2.user.OAuth2UserInfo;

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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    protected User(){}

    public User(OAuth2UserInfo oAuth2UserInfo, OAuth2UserRequest userRequest) {
        this.firstName = oAuth2UserInfo.getFirstName();
        this.lastName = oAuth2UserInfo.getLastName();
        this.username = oAuth2UserInfo.getEmail();
        this.provider = AuthProvider.valueOf(userRequest.getClientRegistration().getRegistrationId());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isCredentialExpired() {
        return credentialExpired;
    }

    public void setCredentialExpired(boolean credentialExpired) {
        this.credentialExpired = credentialExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public AuthProvider getProvider() {
        return provider;
    }

    public void setProvider(AuthProvider provider) {
        this.provider = provider;
    }
}
