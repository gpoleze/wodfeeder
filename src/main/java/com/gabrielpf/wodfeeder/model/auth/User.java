package com.gabrielpf.wodfeeder.model.auth;

import com.gabrielpf.wodfeeder.vo.UserInVO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "expired")
	private boolean expired;

	@Column(name = "locked")
	private boolean locked;

	@Column(name = "credentials_expired")
	private boolean credentialsExpired;

	@Column(name = "enabled")
	private boolean enabled;

	private User() {}

	public User(UserInVO userInVO) {
		this.username = userInVO.getUsername();
		this.password = userInVO.getPassword();
		this.firstName = userInVO.getFirstName();
		this.lastName = userInVO.getLastName();

		this.expired = false;
		this.locked = false;
		this.credentialsExpired = false;
		this.enabled = true;
	}

}
