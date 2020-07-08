package com.gabrielpf.wodfeeder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielpf.wodfeeder.model.Workout;
import com.gabrielpf.wodfeeder.repo.WorkoutRepo;
import com.gabrielpf.wodfeeder.vo.WorkoutVO;

@RestController
@RequestMapping(value = "/api/workouts", produces = "application/json")
public class WorkoutsController {

    private final WorkoutRepo workoutRepo;

    @Autowired
    public WorkoutsController(WorkoutRepo workoutRepo) {this.workoutRepo = workoutRepo;}

    @GetMapping
    public List<WorkoutVO> workouts(){
        final var workouts = workoutRepo.findAll();
        final var workoutsVO = new ArrayList<WorkoutVO>();
        for(Workout workout: workouts){
            workoutsVO.add(new WorkoutVO(workout));
        }
        return workoutsVO;
    }
}
