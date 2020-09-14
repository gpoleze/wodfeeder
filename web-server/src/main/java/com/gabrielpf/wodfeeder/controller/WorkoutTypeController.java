package com.gabrielpf.wodfeeder.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielpf.wodfeeder.service.WorkoutTypeService;
import com.gabrielpf.wodfeeder.vo.WorkoutTypeVO;

@RestController
@RequestMapping(value = "/api/workout-types", produces = "application/json")
public class WorkoutTypeController {

    private final WorkoutTypeService workoutTypeService;

    public WorkoutTypeController(WorkoutTypeService workoutTypeService) {this.workoutTypeService = workoutTypeService;}

    @GetMapping
    public List<WorkoutTypeVO> workoutTypes() {
        return workoutTypeService.findAll();
    }

}
