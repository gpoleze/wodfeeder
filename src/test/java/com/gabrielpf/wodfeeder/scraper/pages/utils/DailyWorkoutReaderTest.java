package com.gabrielpf.wodfeeder.scraper.pages.utils;

import com.gabrielpf.wodfeeder.scraper.HtmlFileReader;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DailyWorkoutReaderTest {

	private DailyWorkoutReader dailyWorkout;

	@BeforeEach
	void setUp() throws IOException {
		Elements paragraphs = new HtmlFileReader("./src/test/resources/weeklyWorkputPageFragment.html")
				.readHtmlFromFile(".entry-content p");
		dailyWorkout = new DailyWorkoutReader(paragraphs);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/dailyWorkoutReaderTestResults.csv",numLinesToSkip = 1)
	void getWorkoutForDay(String day, String expected) {
		String current = dailyWorkout.getWorkoutForDay(DayOfWeek.valueOf(day));
		assertEquals(expected, current);
	}

}