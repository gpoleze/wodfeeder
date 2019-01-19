package ca.gabrielferreira.wodfeeder.scraper.pages.utils;

import org.jsoup.select.Elements;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class DailyWorkoutReader {
	private final Elements paragraphs;

	public DailyWorkoutReader(Elements paragraphs) {
		this.paragraphs = paragraphs;
	}

	public Map<DayOfWeek, Integer> getWorkouts() {
		return generateListOfWorkouts();
	}

	public Map<DayOfWeek, Integer> generateListOfWorkouts() {

		HashMap<DayOfWeek, Integer> workoutsStartLine = new HashMap<>();

		Arrays.stream(DayOfWeek.values()).forEach(day -> {
			OptionalInt line = IntStream.range(0, paragraphs.size())
					.filter(i -> paragraphs.get(i).text().toUpperCase().equals(day.name()))
					.findFirst();
			workoutsStartLine.put(day, line.getAsInt());
		});
		return Collections.unmodifiableMap(workoutsStartLine);
	}

	public Elements getParagraphs() {
		return paragraphs;
	}
}