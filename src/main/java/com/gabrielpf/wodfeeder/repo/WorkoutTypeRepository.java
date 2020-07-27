package com.gabrielpf.wodfeeder.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielpf.wodfeeder.model.WorkoutType;

public interface WorkoutTypeRepository extends JpaRepository<WorkoutType, String> {
}
