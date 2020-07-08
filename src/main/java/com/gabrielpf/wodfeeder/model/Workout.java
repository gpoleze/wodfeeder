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

    public Workout() {}

    public Long getId() {
        return id;
    }

    public Workout setId(Long id) {
        this.id = id;
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

    public String getPart() {
        return part;
    }

    public Workout setPart(String part) {
        this.part = part;
        return this;
    }

    public String getName() {
        return name;
    }

    public Workout setName(String name) {
        this.name = name;
        return this;
    }

    public String getReps() {
        return reps;
    }

    public Workout setReps(String reps) {
        this.reps = reps;
        return this;
    }

    public String getLoad() {
        return load;
    }

    public Workout setLoad(String load) {
        this.load = load;
        return this;
    }

    public Integer getDistance() {
        return distance;
    }

    public Workout setDistance(Integer distance) {
        this.distance = distance;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public Workout setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public String getObservations() {
        return observations;
    }

    public Workout setObservations(String observations) {
        this.observations = observations;
        return this;
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
