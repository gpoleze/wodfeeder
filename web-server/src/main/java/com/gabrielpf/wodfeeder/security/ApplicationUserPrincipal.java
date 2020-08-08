package com.gabrielpf.wodfeeder.security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.gabrielpf.wodfeeder.model.auth.AuthGroup;
import com.gabrielpf.wodfeeder.model.auth.User;

public class ApplicationUserPrincipal implements UserDetails {

    private final User user;
    private final List<AuthGroup> authGroups = new ArrayList<>();

    public ApplicationUserPrincipal(User user, List<AuthGroup> authGroups) {
        this.user = user;
        this.authGroups.addAll(authGroups);
    }

    @Override
    public List<AuthGroup> getAuthorities() {
        return Collections.unmodifiableList(authGroups);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !user.isExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !user.isCredentialExpired();
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
}
