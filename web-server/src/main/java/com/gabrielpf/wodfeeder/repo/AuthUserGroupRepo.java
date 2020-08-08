package com.gabrielpf.wodfeeder.repo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielpf.wodfeeder.model.auth.AuthUserGroup;

public interface AuthUserGroupRepo extends JpaRepository<AuthUserGroup, UUID> {
    Optional<List<AuthUserGroup>> findByUserId(UUID userId);
}
