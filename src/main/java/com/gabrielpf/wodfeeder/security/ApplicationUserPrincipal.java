package com.gabrielpf.wodfeeder.security;

import com.gabrielpf.wodfeeder.model.auth.AuthGroup;
import com.gabrielpf.wodfeeder.model.auth.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toSet;

public class ApplicationUserPrincipal implements UserDetails {

	private final User user;
	private final List<AuthGroup> authGroups;

	public ApplicationUserPrincipal(User user, List<AuthGroup> authGroups) {
		this.user = user;
		this.authGroups = authGroups;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (authGroups == null) return Collections.emptySet();

		return authGroups
				.stream()
				.map(AuthGroup::getName)
				.map(Enum::toString)
				.map(SimpleGrantedAuthority::new)
				.collect(toSet());
	}

	public long getId() {return user.getId();}

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
