package com.gabrielpf.wodfeeder.model;

import com.gabrielpf.wodfeeder.utils.WeekUtil;
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

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "week")
	private int week;

	@Column(name = "exercises")
	private String exercises;

	@ManyToOne(targetEntity = WarmUp.class)
	@JoinColumn(name = "warmUpId")
	private WarmUp warmUp;

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
		this.week = WeekUtil.getWeekOfYear(date);
		this.exercises = exercises;
//		this.warmUp = null;
//		this.weightlifting = null;
	}

	private WOD() {}
}
