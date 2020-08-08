package com.gabrielpf.wodfeeder.vo;


import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import com.gabrielpf.wodfeeder.model.Workout;

public class WorkoutVO extends RepresentationModel<WorkoutVO> {
    private final String type;

    private final UUID id;
    private final LocalDate date;
    private final String exercise;
    private final int position;
    private final String notes;

    public WorkoutVO(Workout workout) {
        this.id = workout.getId();
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

    public int getPosition() {
        return position;
    }

    public String getNotes() {
        return notes;
    }

    public UUID getId() {
        return id;
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
