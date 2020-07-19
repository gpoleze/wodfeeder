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

    @Column(nullable = false)
    private String exercise;

    @Column(nullable = false)
    private Integer position;

    @Column
    private String notes;

    public Workout() {}

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

    public Integer getPosition() {
        return position;
    }

    public Workout setPosition(Integer position) {
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
}
