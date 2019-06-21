package com.gabrielpf.wodfeeder.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class SignUpUserVO{

	@Email(message = "field.email.invalid")
	@NotBlank(message = "field.required")
	@Size(max = 128, message = "field.invalid.size")
	private String username;

	@NotBlank(message = "field.required")
	@Size(min = 8, max = 128, message = "field.invalid.size")
	private String password;

	@NotBlank(message = "field.required")
	@Size(min = 8, max = 128, message = "field.invalid.size")
	private String confirmPassword;

	@NotBlank(message = "field.required")
	@Size(max = 128, message = "field.invalid.size")
	private String firstName;

	@Size(max = 128, message = "field.invalid.size")
	private String lastName;
}
