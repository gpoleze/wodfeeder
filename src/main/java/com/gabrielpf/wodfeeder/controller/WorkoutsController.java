package com.gabrielpf.wodfeeder.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielpf.wodfeeder.service.WorkoutService;
import com.gabrielpf.wodfeeder.vo.WorkoutVO;

@RestController
@RequestMapping(value = "/api/workouts", produces = "application/json")
public class WorkoutsController {

    private final WorkoutService workoutService;

    @Autowired
    public WorkoutsController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public List<WorkoutVO> workouts(@PageableDefault(size=50) Pageable pageable){
        return workoutService.findAll(pageable);
    }

    @GetMapping("/{date}")
    public List<WorkoutVO> workouts(@PathVariable LocalDate date){
        return workoutService.findAllByDate(date);
    }
}
