package com.gabrielpf.wodfeeder.model.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "auth_user_group")
@Data
@NoArgsConstructor
public class AuthUserGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne(targetEntity = AuthGroup.class)
	@JoinColumn(name = "auth_group_id", nullable = false)
	private AuthGroup authGroup;

	public AuthUserGroup(User user, AuthGroup authGroup) {
		this.user = user;
		this.authGroup = authGroup;
	}
}
