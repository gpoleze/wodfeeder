package com.gabrielpf.wodfeeder.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(schema = "public", name = "workoutOfTheDay")
@Data
public class WOD {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "date", nullable = false, unique = true)
	private LocalDate date;

	@Column(name = "exercises", nullable = false)
	private String exercises;

//	@Column(name = "warmUp", nullable = true)
//	private WarmUp warmUp;
//
//	@Column(name = "weightlifting", nullable = true)
//	private Weightlifting weightlifting;
//
//	public WOD(LocalDate date, String exercises, WarmUp warmUp, Weightlifting weightlifting) {
//		this.date = date;
//		this.exercises = exercises;
//		this.warmUp = warmUp;
//		this.weightlifting = weightlifting;
//	}

	public WOD(LocalDate date, String exercises) {
		this.date = date;
		this.exercises = exercises;
//		this.warmUp = null;
//		this.weightlifting = null;
	}

	private WOD() {}
}
