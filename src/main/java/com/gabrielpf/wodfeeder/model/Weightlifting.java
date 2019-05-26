package com.gabrielpf.wodfeeder.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(schema = "public", name = "weightlifting")
@Data
public class Weightlifting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false, unique = true)
    private LocalDate date;

    @Column(name = "exercises", nullable = false)
    private String exercises;

    public Weightlifting(LocalDate date, String exercises) {
        this.date = date;
        this.exercises = exercises;
    }

    private Weightlifting() {}
}
