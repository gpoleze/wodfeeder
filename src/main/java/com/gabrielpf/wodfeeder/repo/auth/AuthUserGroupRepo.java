package com.gabrielpf.wodfeeder.repo.auth;

import com.gabrielpf.wodfeeder.model.auth.AuthUserGroup;
import com.gabrielpf.wodfeeder.model.auth.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AuthUserGroupRepo extends CrudRepository<AuthUserGroup, Integer> {
	Optional<List<AuthUserGroup>> findByUser(User user);
}
