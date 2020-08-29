package com.gabrielpf.wodfeeder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.gabrielpf.wodfeeder.model.WorkoutType;

@Repository
@RestResource(exported = false)
public interface WorkoutTypeRepository extends JpaRepository<WorkoutType, String> {
}
