package ca.gabrielferreira.wodfeeder.scraper.pages.utils;

import ca.gabrielferreira.wodfeeder.scraper.HtmlFileReader;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DailyWorkoutReaderTest {

	private DailyWorkoutReader dailyWorkout;

	@Before
	public void setUp() throws IOException {
		Elements paragraphs = new HtmlFileReader().readHtmlFromFile();
		dailyWorkout = new DailyWorkoutReader(paragraphs);
	}

	@Test
	public void generateListOfWorkays() throws Exception {
		Map<DayOfWeek, Integer> expected = new HashMap<>();
		expected.put(DayOfWeek.MONDAY, 5);
		expected.put(DayOfWeek.TUESDAY, 14);
		expected.put(DayOfWeek.WEDNESDAY, 23);
		expected.put(DayOfWeek.THURSDAY, 31);
		expected.put(DayOfWeek.FRIDAY, 40);
		expected.put(DayOfWeek.SATURDAY, 49);
		expected.put(DayOfWeek.SUNDAY, 53);

		Map<DayOfWeek, Integer> workouts = dailyWorkout.generateListOfWorkouts();
		assertEquals(expected, workouts);

	}

}