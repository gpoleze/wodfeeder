package com.gabrielpf.wodfeeder.model.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.gabrielpf.wodfeeder.model.EntityWithUuid;

@Entity
@Table(name = "auth_group")
public class AuthGroup extends EntityWithUuid implements GrantedAuthority {

    @Column(nullable = false, unique = true)
    private String name;

    protected AuthGroup() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
