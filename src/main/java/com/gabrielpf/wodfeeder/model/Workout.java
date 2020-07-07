package com.gabrielpf.wodfeeder.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "workout")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @OneToOne(targetEntity = WorkoutType.class)
    @JoinColumn(name = "type", nullable = false)
    private WorkoutType type;

    @Column(nullable = false)
    private String exercise;

    @Column(nullable = false)
    private Integer position;

    @Column(length = 1)
    private String part;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String reps;

    @Column(length = 10)
    private String load;

    @Column
    private Integer distance;

    @Column
    private Integer duration;

    @Column
    private String observations;

    protected Workout() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public WorkoutType getType() {
        return type;
    }

    public void setType(WorkoutType type) {
        this.type = type;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return position == workout.position &&
                distance == workout.distance &&
                duration == workout.duration &&
                Objects.equals(id, workout.id) &&
                Objects.equals(date, workout.date) &&
                type == workout.type &&
                Objects.equals(exercise, workout.exercise) &&
                Objects.equals(part, workout.part) &&
                Objects.equals(name, workout.name) &&
                Objects.equals(reps, workout.reps) &&
                Objects.equals(load, workout.load) &&
                Objects.equals(observations, workout.observations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, type, exercise, position, part, name, reps, load, distance, duration, observations);
    }
}
