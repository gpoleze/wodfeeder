package com.gabrielpf.wodfeeder.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gabrielpf.wodfeeder.model.Workout;

@Repository
public interface WorkoutRepo extends PagingAndSortingRepository<Workout, UUID> {
    Optional<List<Workout>> findByDate(LocalDate date);
}
