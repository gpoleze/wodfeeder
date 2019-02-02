package com.gabrielpf.wodfeeder.scraper.pages.utils;

import org.jsoup.select.Elements;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DailyWorkoutReader {
	private final Elements paragraphs;
	private final Map<DayOfWeek, Integer> daylyWorkouts;

	public DailyWorkoutReader(Elements paragraphs) {
		this.paragraphs = paragraphs;
		daylyWorkouts = generateListOfWorkouts();
	}

	/**
	 * Reads the paragraphs of a html to find the index where the days of the week are.
	 *
	 * @return a map for each day of the week its index position
	 */
	private Map<DayOfWeek, Integer> generateListOfWorkouts() {

		HashMap<DayOfWeek, Integer> workoutsStartLine = new HashMap<>();

		Arrays.stream(DayOfWeek.values()).forEach(day -> {
			OptionalInt line = IntStream.range(0, paragraphs.size())
					.filter(i -> paragraphs.get(i).text().toUpperCase().equals(day.name()))
					.findFirst();
			workoutsStartLine.put(day, line.getAsInt());
		});
		return Collections.unmodifiableMap(workoutsStartLine);
	}

	/**
	 * For a given day of the week, return its workouts
	 * @param day the day of week to get the workout
	 * @return the workout for that day of week
	 */
	public String getWorkoutForDay(DayOfWeek day) {
		if (day == DayOfWeek.SUNDAY)
			return "Rest";

		DayOfWeek nextDay = day.plus(1);

		String s = IntStream.range(0, paragraphs.size())
				.filter(i -> i > daylyWorkouts.get(day) && i < daylyWorkouts.get(nextDay))
				.boxed()
				.map(i -> paragraphs.get(i).text())
				.collect(Collectors.joining("\n"));

		return s;
	}

}