package com.gabrielpf.wodfeeder.security;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gabrielpf.wodfeeder.model.auth.AuthGroup;
import com.gabrielpf.wodfeeder.model.auth.AuthUserGroup;
import com.gabrielpf.wodfeeder.repo.AuthUserGroupRepo;
import com.gabrielpf.wodfeeder.repo.UserRepo;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthUserGroupRepo authUserGroupRepo;

    private static List<AuthGroup> mapToAuthGroup(List<AuthUserGroup> authUserGroup) {
        return authUserGroup.stream().map(AuthUserGroup::getAuthGroup).collect(toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found in the DB"));

        var authGroups = authUserGroupRepo
                .findByUserId(user.getId())
                .map(AuthenticationService::mapToAuthGroup)
                .orElseThrow(() -> new ResourceNotFoundException("No auth user group found for " + username));

        return new ApplicationUserPrincipal(user, authGroups);
    }
}
