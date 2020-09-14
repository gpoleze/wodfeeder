package com.gabrielpf.wodfeeder.controller.form;

import java.time.LocalDate;
import java.util.StringJoiner;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.gabrielpf.wodfeeder.model.Workout;
import com.gabrielpf.wodfeeder.model.WorkoutScoring;
import com.gabrielpf.wodfeeder.model.WorkoutType;

public class WorkoutForm {

    @NotNull
    private LocalDate date;

    @NotNull
    @Min(1)
    private int position;

    @NotBlank
    private String type;

    @NotBlank
    private String exercise;

    private String notes;

    @NotBlank
    private String scoring;

    protected WorkoutForm() {}

    public WorkoutForm(LocalDate date, int position, String type, String exercise, String notes, String scoring) {
        this.date = date;
        this.position = position;
        this.type = type;
        this.exercise = exercise;
        this.notes = notes;
        this.scoring = scoring;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPosition() {
        return position;
    }

    public String getType() {
        return type;
    }

    public String getExercise() {
        return exercise;
    }

    public String getNotes() {
        return notes;
    }

    public String getScoring() {
        return scoring;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", WorkoutForm.class.getSimpleName() + "[", "]")
                .add("date=" + date)
                .add("position=" + position)
                .add("type='" + type + "'")
                .add("exercise='" + exercise + "'")
                .add("notes='" + notes + "'")
                .toString();
    }

    public Workout convert(WorkoutType workoutType, WorkoutScoring workoutScoring) {
        return new Workout(date, position, workoutType, exercise, notes, workoutScoring);
    }
}
