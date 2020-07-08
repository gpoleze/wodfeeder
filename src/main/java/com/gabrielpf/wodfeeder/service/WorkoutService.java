package com.gabrielpf.wodfeeder.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gabrielpf.wodfeeder.model.Workout;
import com.gabrielpf.wodfeeder.repo.WorkoutRepo;
import com.gabrielpf.wodfeeder.vo.WorkoutVO;

@Service
public class WorkoutService {

    private final WorkoutRepo repo;

    public WorkoutService(WorkoutRepo repo) {this.repo = repo;}

    public List<WorkoutVO> findAllWorkouts(){
        final var workouts = repo.findAll();
        final var workoutsVO = new ArrayList<WorkoutVO>();
        for(Workout workout: workouts){
            workoutsVO.add(new WorkoutVO(workout));
        }
        return workoutsVO;
    }

    public List<WorkoutVO> findAllByDate(LocalDate date){
        return repo.findByDate(date)
                .orElse(Collections.emptyList())
                .stream()
                .map(WorkoutVO::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
