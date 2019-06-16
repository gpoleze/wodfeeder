package com.gabrielpf.wodfeeder.auth;

import com.gabrielpf.wodfeeder.repo.AuthGroupRepo;
import com.gabrielpf.wodfeeder.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class WodFeederUserDetailsService implements UserDetailsService {

	private final UserRepo userRepo;
	private final AuthGroupRepo authGroupRepo;

	public WodFeederUserDetailsService(UserRepo repo, AuthGroupRepo authGroupRepo) {
		this.userRepo = repo;
		this.authGroupRepo = authGroupRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		var user = userRepo
				.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with the username " + username));

		var authGroups = authGroupRepo.findByUser(user).orElse(Collections.emptyList());

		return new WodFeederUserPrincipal(user, authGroups);
	}
}
