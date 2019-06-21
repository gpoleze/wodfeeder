package com.gabrielpf.wodfeeder.controller;

import com.gabrielpf.wodfeeder.dao.UserDao;
import com.gabrielpf.wodfeeder.validation.SignUpUserVOValidation;
import com.gabrielpf.wodfeeder.vo.SignUpUserVO;
import com.gabrielpf.wodfeeder.vo.UserInVO;
import com.gabrielpf.wodfeeder.vo.UserOutVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_UTF8_VALUE)
public class AuthenticationController {

	protected static final Logger log = LoggerFactory.getLogger(UserDao.class.getName());

	@Autowired
	UserDao dao;

	@InitBinder("SignUpUserVOValidation")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new SignUpUserVOValidation());
	}

	@PostMapping("/signup")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public UserOutVO signup(@Valid SignUpUserVO signUpUserVO) {
		System.out.println(signUpUserVO);
		log.info("Sign Up process started");
		return dao.saveUser(signUpUserVO);
	}

	@PostMapping(value = "/signin", consumes = APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public UserOutVO signIn(@RequestBody @Valid UserInVO userInVO) {
		log.info("Sign In process started");
		System.out.println(userInVO);
		return dao.findByUserInVo(userInVO);
	}
}
