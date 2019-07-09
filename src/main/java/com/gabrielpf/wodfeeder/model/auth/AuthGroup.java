package com.gabrielpf.wodfeeder.model.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auth_group")
@Data
@NoArgsConstructor
public class AuthGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	private AuthGroupEnum name;

	public AuthGroup(AuthGroupEnum groupEnum) {
		this.name = groupEnum;
	}

}