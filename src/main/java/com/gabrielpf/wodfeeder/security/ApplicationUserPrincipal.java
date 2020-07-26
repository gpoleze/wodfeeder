package com.gabrielpf.wodfeeder.security;

import static java.util.stream.Collectors.toUnmodifiableSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authGroups
                .parallelStream()
                .map(AuthGroup::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(toUnmodifiableSet());
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
