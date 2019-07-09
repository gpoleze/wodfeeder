package com.gabrielpf.wodfeeder.service.auth;

import com.gabrielpf.wodfeeder.model.auth.AuthGroup;
import com.gabrielpf.wodfeeder.model.auth.AuthUserGroup;
import com.gabrielpf.wodfeeder.model.auth.User;
import com.gabrielpf.wodfeeder.repo.auth.AuthUserGroupRepo;
import com.gabrielpf.wodfeeder.repo.auth.UserRepo;
import com.gabrielpf.wodfeeder.security.ApplicationUserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ApplicationUserDetailService implements UserDetailsService {
	private final UserRepo userRepo;
	private final AuthUserGroupRepo authUserGroupRepo;

	public ApplicationUserDetailService(UserRepo repo, AuthUserGroupRepo authUserGroupRepo) {
		this.userRepo = repo;
		this.authUserGroupRepo = authUserGroupRepo;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User with the username " + username + " was not found"));

		return new ApplicationUserPrincipal(user, getAuthGroups(user));
	}

	private List<AuthGroup> getAuthGroups(User user) {
		return authUserGroupRepo
				.findByUser(user)
				.orElseThrow()
				.stream()
				.map(AuthUserGroup::getAuthGroup)
				.collect(toList())
				;
	}

	@Transactional // This method is used by JWTAuthenticationFilter
	public UserDetails loadUserById(Long id) {
		User user = userRepo.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with id : " + id));

		return new ApplicationUserPrincipal(user, getAuthGroups(user));
	}
}
