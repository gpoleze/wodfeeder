package com.gabrielpf.wodfeeder.model.auth;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gabrielpf.wodfeeder.model.EntityWithUuid;

@Entity
@Table(name = "auth_user_group")
public class AuthUserGroup extends EntityWithUuid {

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(targetEntity = AuthGroup.class)
    @JoinColumn(name = "auth_group_id", nullable = false)
    private AuthGroup authGroup;

    protected AuthUserGroup() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AuthGroup getAuthGroup() {
        return authGroup;
    }

    public void setAuthGroup(AuthGroup authGroup) {
        this.authGroup = authGroup;
    }
}
