package com.gabrielpf.wodfeeder.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.gabrielpf.wodfeeder.model.Exercise;

@Repository
@RestResource(exported = false)
public interface ExerciseRepo extends JpaRepository<Exercise, UUID> {
    List<Exercise> findByNameContainingIgnoringCase(String name);
}
