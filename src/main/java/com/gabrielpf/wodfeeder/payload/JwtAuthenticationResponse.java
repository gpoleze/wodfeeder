package com.gabrielpf.wodfeeder.payload;

import lombok.Value;

@Value
public class JwtAuthenticationResponse {
	private final String accessToken;
	private final String tokeType = "Bearer";

	public JwtAuthenticationResponse(String accessToken) {this.accessToken = accessToken;}
}
