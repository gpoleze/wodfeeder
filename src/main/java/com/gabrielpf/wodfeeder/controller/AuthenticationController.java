package com.gabrielpf.wodfeeder.controller;

import com.gabrielpf.wodfeeder.dao.UserDao;
import com.gabrielpf.wodfeeder.model.auth.AuthGroupEnum;
import com.gabrielpf.wodfeeder.model.auth.AuthUserGroup;
import com.gabrielpf.wodfeeder.payload.ApiResponse;
import com.gabrielpf.wodfeeder.payload.JwtAuthenticationResponse;
import com.gabrielpf.wodfeeder.repo.auth.AuthGroupRepo;
import com.gabrielpf.wodfeeder.repo.auth.AuthUserGroupRepo;
import com.gabrielpf.wodfeeder.repo.auth.UserRepo;
import com.gabrielpf.wodfeeder.security.JwtTokenProvider;
import com.gabrielpf.wodfeeder.validation.SignUpUserVOValidation;
import com.gabrielpf.wodfeeder.vo.SignUpUserVO;
import com.gabrielpf.wodfeeder.vo.UserInVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthenticationController {

	protected static final Logger log = LoggerFactory.getLogger(UserDao.class.getName());

	private final UserDao dao;
	private final UserRepo userRepo;
	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider tokenProvider;
	private final AuthUserGroupRepo authUserGroupRepo;
	@Autowired
	private AuthGroupRepo authGroupRepo;

	public AuthenticationController(UserDao dao, UserRepo userRepo, AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider, AuthUserGroupRepo authUserGroupRepo) {
		this.dao = dao;
		this.userRepo = userRepo;
		this.authenticationManager = authenticationManager;
		this.tokenProvider = tokenProvider;
		this.authUserGroupRepo = authUserGroupRepo;
	}

	@InitBinder("signUpUserVO")
	public void initBinder(WebDataBinder binder) { binder.addValidators(new SignUpUserVOValidation()); }

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody SignUpUserVO signUpUserVO, BindingResult result) {
		log.info("Sign Up process started for " + signUpUserVO.getUsername());

		if (result.hasErrors()) {
			log.error("Request body not valid");
			return new ResponseEntity<>(
					new ApiResponse(false, result.getAllErrors().toString()),
					BAD_REQUEST
			);
		}

		if (dao.existsByUsername(signUpUserVO.getUsername())) {
			log.info("Username " + signUpUserVO.getUsername() + " is already taken");
			return new ResponseEntity<>(
					new ApiResponse(false, "Username is already taken"),
					BAD_REQUEST
			);
		}

		var user = dao.saveUser(signUpUserVO);
		var authGroup = authGroupRepo.findByName(AuthGroupEnum.USER)
				.orElseThrow(() -> new RuntimeException("AuthGroup " + AuthGroupEnum.USER + " not found"));

		log.info(String.format("Persisting Auth user Group with the User: %s and the Auth Group: %s", user.getUsername(), authGroup.getName()));
		final var save = authUserGroupRepo.save(new AuthUserGroup(user, authGroup));

		final var uri = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("/api/user/{username}")
				.buildAndExpand(user.getUsername()).toUri();

		return ResponseEntity
				.created(uri)
				.body(new ApiResponse(true, "User registered successfully"));
	}

	@PostMapping(value = "/signin")
	public ResponseEntity<?> signIn(@RequestBody @Valid UserInVO userInVO) {
		log.info("Sign In process started");

		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userInVO.getUsername(), userInVO.getPassword())
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenProvider.generateToken(authentication);

		log.info("Sign In as " + userInVO.getUsername());
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}
}
