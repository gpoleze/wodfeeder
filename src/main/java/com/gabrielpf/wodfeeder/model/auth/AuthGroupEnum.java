package com.gabrielpf.wodfeeder.model.auth;

public enum AuthGroupEnum {
	USER("USER"), ADMIN("ADMIN");

	private final String authGroup;

	AuthGroupEnum(String authGroup) {this.authGroup = authGroup;}

	public String getAuthGroup() {
		return authGroup;
	}
}
