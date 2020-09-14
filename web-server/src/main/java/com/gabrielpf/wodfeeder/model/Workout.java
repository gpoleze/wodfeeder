package com.gabrielpf.wodfeeder.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "workout")
public class Workout extends EntityWithUuid{

    @Column(nullable = false)
    private LocalDate date;

    @OneToOne(targetEntity = WorkoutType.class)
    @JoinColumn(name = "type", nullable = false)
    private WorkoutType type;

    @OneToOne(targetEntity = WorkoutScoring.class)
    @JoinColumn(name = "scoring", nullable = false)
    private WorkoutScoring scoring;

    @Column(nullable = false)
    private String exercise;

    @Column(nullable = false)
    private int position;

    @Column
    private String notes;

    public Workout() {}

    public Workout(LocalDate date, int position, WorkoutType workoutType, String exercise, String notes, WorkoutScoring scoring) {
        this.date = date;
        this.position = position;
        this.type = workoutType;
        this.exercise = exercise;
        this.notes = notes;
        this.scoring = scoring;
    }

    @Override
    public Workout setId(UUID id) {
        super.setId(id);
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public Workout setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public WorkoutType getType() {
        return type;
    }

    public Workout setType(WorkoutType type) {
        this.type = type;
        return this;
    }

    public String getExercise() {
        return exercise;
    }

    public Workout setExercise(String exercise) {
        this.exercise = exercise;
        return this;
    }

    public int getPosition() {
        return position;
    }

    public Workout setPosition(int position) {
        this.position = position;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public Workout setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public WorkoutScoring getScoring() {
        return scoring;
    }

    public Workout setScoring(WorkoutScoring scoring) {
        this.scoring = scoring;
        return this;
    }
}
