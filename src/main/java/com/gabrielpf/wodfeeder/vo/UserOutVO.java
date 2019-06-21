package com.gabrielpf.wodfeeder.vo;

import com.gabrielpf.wodfeeder.model.auth.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserOutVO {

	private final long id;
	private final String username;
	private final String firstName;
	private final String lastName;

	public UserOutVO(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
	}
}
