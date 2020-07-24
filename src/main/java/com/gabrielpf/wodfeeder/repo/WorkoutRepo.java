package com.gabrielpf.wodfeeder.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.gabrielpf.wodfeeder.model.Workout;

@Repository
@RestResource(exported = false)
public interface WorkoutRepo extends JpaRepository<Workout, UUID> {
    Optional<List<Workout>> findByDate(LocalDate date);
}
