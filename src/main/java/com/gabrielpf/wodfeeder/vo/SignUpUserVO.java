package com.gabrielpf.wodfeeder.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpUserVO extends UserInVO {

	@NotBlank(message = "field.required")
	@Size(min = 8, max = 128, message = "field.invalid.size")
	private String confirmPassword;

	public SignUpUserVO(
			@Email(message = "field.email.invalid") @NotBlank(message = "field.required") @Size(max = 128, message = "field.invalid.size") String username,
			@NotBlank(message = "field.required") @Size(min = 8, max = 128, message = "field.invalid.size") String password,
			@NotBlank(message = "field.required") @Size(max = 128, message = "field.invalid.size") String firstName,
			@Size(max = 128, message = "field.invalid.size") String lastName,
			@NotBlank(message = "field.required") @Size(min = 8, max = 128, message = "field.invalid.size") String confirmPassword) {
		super(username, password, firstName, lastName);
		this.confirmPassword = confirmPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}
}
