package com.gabrielpf.wodfeeder.vo;

import org.springframework.hateoas.RepresentationModel;

import com.gabrielpf.wodfeeder.model.auth.User;

public class UserVO extends RepresentationModel<UserVO> {
    private final String id;
    private final String lastName;
    private final String username;
    private final String firstName;

    public UserVO(User user) {
        this.id = user.getId().toString();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }

    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }
}
