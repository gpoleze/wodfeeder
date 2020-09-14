package com.gabrielpf.wodfeeder.repo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.gabrielpf.wodfeeder.model.WorkoutScoring;

@Repository
@RestResource(exported = false)
public interface WorkoutScoringRepo extends JpaRepository<WorkoutScoring, UUID> {
    Optional<WorkoutScoring> findByScoring(String scoring);
}
