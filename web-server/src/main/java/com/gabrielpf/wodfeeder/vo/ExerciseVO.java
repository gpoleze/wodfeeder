package com.gabrielpf.wodfeeder.vo;

import java.util.UUID;

import com.gabrielpf.wodfeeder.model.Exercise;

public class ExerciseVO {

    private final UUID id;
    private final String name;

    public ExerciseVO(Exercise exercise) {
        this.id = exercise.getId();
        this.name = exercise.getName();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
