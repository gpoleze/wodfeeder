package com.gabrielpf.wodfeeder.vo;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.gabrielpf.wodfeeder.model.WorkoutScoring;

public class WorkoutScoringVO {

    @NotBlank
    private final String scoring;

    @NotBlank
    private final UUID id;

    public WorkoutScoringVO(UUID id, String type) {
        this.scoring = type;
        this.id = id;
    }

    public WorkoutScoringVO(WorkoutScoring workoutScoring) {
        this.id = workoutScoring.getId();
        this.scoring = workoutScoring.getScoring();
    }

    public String getScoring() {
        return scoring;
    }

    public UUID getId() {
        return id;
    }
}
