package com.gabrielpf.wodfeeder.vo;


import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.gabrielpf.wodfeeder.model.Workout;
import com.gabrielpf.wodfeeder.model.WorkoutType;

public class WorkoutVO {
    @NotNull
    private final String type;

    @NotNull
    private final LocalDate date;

    @NotNull
    private final String exercise;

    @NotNull
    @Min(1)
    private final int position;

    private final String notes;

    public WorkoutVO(Workout workout) {
        this.date = workout.getDate();
        this.type = workout.getType().getType();
        this.exercise = workout.getExercise();
        this.position = workout.getPosition();
        this.notes = workout.getNotes();
    }

    public String getType() {
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

    public String getNotes() {
        return notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkoutVO workoutVO = (WorkoutVO) o;
        return position == workoutVO.position &&
                Objects.equals(type, workoutVO.type) &&
                Objects.equals(date, workoutVO.date) &&
                Objects.equals(exercise, workoutVO.exercise) &&
                Objects.equals(notes, workoutVO.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, date, exercise, position, notes);
    }
}
