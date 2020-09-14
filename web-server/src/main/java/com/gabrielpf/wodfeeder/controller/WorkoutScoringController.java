package com.gabrielpf.wodfeeder.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielpf.wodfeeder.service.WorkoutScoringService;
import com.gabrielpf.wodfeeder.vo.WorkoutScoringVO;

@RestController
@RequestMapping(value = "/api/workout-scoring", produces = "application/json")
public class WorkoutScoringController {

    private final WorkoutScoringService scoringService;

    public WorkoutScoringController(WorkoutScoringService scoringService) {this.scoringService = scoringService;}

    @GetMapping
    public List<WorkoutScoringVO> workoutScorings() {
        return scoringService.findAll();
    }

}
