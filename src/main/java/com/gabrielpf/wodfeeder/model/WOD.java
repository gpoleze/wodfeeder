package com.gabrielpf.wodfeeder.model;

import java.time.LocalDate;

public class WOD {
	private LocalDate day;
	private String exercises;

	public WOD(LocalDate day, String exercises) {
		this.day = day;
		this.exercises = exercises;
	}
}
