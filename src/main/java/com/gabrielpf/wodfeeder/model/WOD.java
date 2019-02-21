package com.gabrielpf.wodfeeder.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(schema = "public", name = "workoutOfTheDay")
public class WOD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false, unique = true)
    private LocalDate date;

    @Column(name = "exercises", nullable = false)
    private String exercises;

    public WOD(LocalDate date, String exercises) {
        this.date = date;
        this.exercises = exercises;
    }

    private WOD() {
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getExercises() {
        return exercises;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setExercises(String exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "WOD{" +
                "id=" + id +
                ", date=" + date +
                ", exercises='" + exercises + '\'' +
                '}';
    }
}
