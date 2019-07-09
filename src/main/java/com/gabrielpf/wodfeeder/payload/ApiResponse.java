package com.gabrielpf.wodfeeder.payload;

import lombok.Value;
import org.springframework.http.ResponseEntity;

@Value
public class ApiResponse {
	private Boolean success;
	private String message;
}
