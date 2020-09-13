package com.gabrielpf.wodfeeder.vo;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.gabrielpf.wodfeeder.model.WorkoutType;

public class WorkoutTypeVO {
    @NotBlank
    private final String type;

    @NotBlank
    private final UUID id;

    public WorkoutTypeVO(String type, UUID id) {
        this.type = type;
        this.id = id;
    }

    public WorkoutTypeVO(WorkoutType workoutType) {
        this.type = workoutType.getType();
        this.id = workoutType.getId();
    }

    public String getType() {
        return type;
    }

    public UUID getId() {
        return id;
    }
}
