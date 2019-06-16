package com.gabrielpf.wodfeeder.auth;

import com.gabrielpf.wodfeeder.model.auth.AuthGroup;
import com.gabrielpf.wodfeeder.model.auth.AuthUserGroup;
import com.gabrielpf.wodfeeder.model.auth.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WodFeederUserPrincipal implements UserDetails {

	private User user;
	private List<AuthUserGroup> authUserGroups;

	public WodFeederUserPrincipal(User user, List<AuthUserGroup> authUserGroups) {
		this.user = user;
		this.authUserGroups = authUserGroups;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (authUserGroups.isEmpty()) return Collections.emptySet();

		return authUserGroups.stream()
				.map(AuthUserGroup::getAuthGroup)
				.map(AuthGroup::getName)
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toSet());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return !user.isExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return !user.isLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !user.isCredentialsExpired();
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}
}
