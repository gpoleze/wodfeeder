package com.gabrielpf.wodfeeder.repo.auth;

import com.gabrielpf.wodfeeder.model.auth.AuthGroup;
import com.gabrielpf.wodfeeder.model.auth.AuthGroupEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthGroupRepo extends CrudRepository<AuthGroup, Long> {
	Optional<AuthGroup> findByName(AuthGroupEnum name);
}
