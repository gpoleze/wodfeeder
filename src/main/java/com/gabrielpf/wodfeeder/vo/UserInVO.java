package com.gabrielpf.wodfeeder.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class UserInVO {

	protected static final Logger log = LoggerFactory.getLogger(UserInVO.class.getName());

	@Email(message = "field.email.invalid")
	@NotBlank(message = "field.required")
	@Size(max = 128, message = "field.invalid.size")
	protected String username;

	@NotBlank(message = "field.required")
	@Size(min = 8, max = 128, message = "field.invalid.size")
	protected String password;

	@NotBlank(message = "field.required")
	@Size(max = 128, message = "field.invalid.size")
	protected String firstName;

	@Size(max = 128, message = "field.invalid.size")
	protected String lastName;
}
