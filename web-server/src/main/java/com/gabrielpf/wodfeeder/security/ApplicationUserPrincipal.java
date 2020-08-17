package com.gabrielpf.wodfeeder.security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.gabrielpf.wodfeeder.model.auth.AuthGroup;
import com.gabrielpf.wodfeeder.model.auth.User;

public class ApplicationUserPrincipal implements OAuth2User, UserDetails {

    private final User user;
    private final List<AuthGroup> authGroups = new ArrayList<>();
    private Map<String, Object> attributes;

    public ApplicationUserPrincipal(User user, List<AuthGroup> authGroups) {
        this.user = user;
        this.authGroups.addAll(authGroups);
    }

    public static ApplicationUserPrincipal create(User user) {
        List<AuthGroup> authorities = Collections.singletonList(new AuthGroup("common"));

        return new ApplicationUserPrincipal(user, authorities);
    }

    public static ApplicationUserPrincipal create(User user, Map<String, Object> attributes) {
        ApplicationUserPrincipal userPrincipal = ApplicationUserPrincipal.create(user);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
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


    @Override
    public Map<String, Object> getAttributes() {
        return Collections.unmodifiableMap(attributes);
    }

    private void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getName() {
        return user.getId().toString();
    }
}
