package com.gabrielpf.wodfeeder.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserInVO {

	@Email(message = "field.email.invalid")
	@NotBlank(message = "field.required")
	@Size(max = 128, message = "field.invalid.size")
	private String username;

	@NotBlank(message = "field.required")
	@Size(min = 8, max = 128, message = "field.invalid.size")
	private String password;

	public UserInVO(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
