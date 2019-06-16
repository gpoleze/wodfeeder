package com.gabrielpf.wodfeeder.validation;

import com.gabrielpf.wodfeeder.vo.SignUpUserVO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SignUpUserVOValidation implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return SignUpUserVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "field.required");

		var signUpUserVO = (SignUpUserVO) target;

		if (!signUpUserVO.getPassword().equals(signUpUserVO.getConfirmPassword())) {
			errors.reject("password", "field.password.mismatch");
			errors.reject("confirmPassword", "field.password.mismatch");
		}
	}
}
