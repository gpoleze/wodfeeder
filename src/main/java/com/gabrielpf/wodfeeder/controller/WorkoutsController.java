package com.gabrielpf.wodfeeder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielpf.wodfeeder.vo.WorkoutVO;

@RestController
public class WorkoutsController {

    @GetMapping("/api/workouts")
    public WorkoutVO workouts(){
        return new WorkoutVO();
    }
}
