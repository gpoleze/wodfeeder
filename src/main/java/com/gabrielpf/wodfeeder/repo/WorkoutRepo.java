package com.gabrielpf.wodfeeder.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gabrielpf.wodfeeder.model.Workout;

@Repository
public interface WorkoutRepo extends CrudRepository<Workout, Long> {
    Optional<List<Workout>> findByDate(LocalDate date);
}
