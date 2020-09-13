package com.gabrielpf.wodfeeder.service;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gabrielpf.wodfeeder.repo.WorkoutTypeRepo;
import com.gabrielpf.wodfeeder.vo.WorkoutTypeVO;

@Service
public class WorkoutTypeService {
    private final WorkoutTypeRepo workoutTypeRepo;

    public WorkoutTypeService(WorkoutTypeRepo workoutTypeRepo) {this.workoutTypeRepo = workoutTypeRepo;}

    public List<WorkoutTypeVO> findAll() {
        return workoutTypeRepo
                .findAll()
                .stream()
                .map(WorkoutTypeVO::new)
                .collect(toUnmodifiableList());
    }
}
