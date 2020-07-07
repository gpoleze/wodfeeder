package com.gabrielpf.wodfeeder.vo;


import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.gabrielpf.wodfeeder.model.Workout;
import com.gabrielpf.wodfeeder.model.WorkoutType;

public class WorkoutVO {
    private final WorkoutType type;

    @NotNull
    private final LocalDate date;

    @NotNull
    private final String exercise;

    @NotNull
    private final int position;

    @Size(max = 1)
    private final String part;

    @Size(max = 50)
    private final String name;

    @Size(max = 50)
    private final String reps;

    @Size(max = 10)
    private final String load;

    private final Integer distance;

    private final Integer duration;

    private final String observations;

    public WorkoutVO(Workout workout) {
        this.date = workout.getDate();
        this.type = workout.getType();
        this.exercise = workout.getExercise();
        this.position = workout.getPosition();
        this.part = workout.getPart();
        this.name = workout.getName();
        this.reps = workout.getReps();
        this.load = workout.getLoad();
        this.distance = workout.getDistance();
        this.duration = workout.getDuration();
        this.observations = workout.getObservations();
    }

    public WorkoutType getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getExercise() {
        return exercise;
    }

    public Integer getPosition() {
        return position;
    }

    public String getPart() {
        return part;
    }

    public String getName() {
        return name;
    }

    public String getReps() {
        return reps;
    }

    public String getLoad() {
        return load;
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getObservations() {
        return observations;
    }
}
