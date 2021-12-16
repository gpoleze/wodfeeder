package com.gabrielpf.wodfeeder.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exercise_set")
public class ExerciseSet extends EntityWithUuid {

    @ManyToOne(targetEntity = Exercise.class)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exerciseId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private short reps;

    @Column
    private float weight;

    @ManyToOne(targetEntity = WeightType.class)
    @JoinColumn(name = "weight_type")
    private WeightType weightType;

    @Column
    private String observation;

    protected ExerciseSet() {}

    public Exercise getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Exercise exerciseId) {
        this.exerciseId = exerciseId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public short getReps() {
        return reps;
    }

    public void setReps(short reps) {
        this.reps = reps;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public WeightType getWeightType() {
        return weightType;
    }

    public void setWeightType(WeightType weightType) {
        this.weightType = weightType;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
