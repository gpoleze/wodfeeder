package com.gabrielpf.wodfeeder.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserInVO {

	@Email(message = "field.email.invalid")
	@NotBlank(message = "field.required")
	@Size(max = 128, message = "field.invalid.size")
	private String username;

	@NotBlank(message = "field.required")
	@Size(min = 8, max = 128, message = "field.invalid.size")
	private String password;
}
