package com.gabrielpf.wodfeeder.vo;

import com.gabrielpf.wodfeeder.model.auth.User;
import lombok.Getter;

@Getter
public class UserOutVO {

	private final long id;
	private final String username;

	public UserOutVO(long id, String username) {
		this.id = id;
		this.username = username;
	}

	public UserOutVO(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
	}
}
