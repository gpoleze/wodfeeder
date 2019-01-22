package ca.gabrielferreira.wodfeeder.scraper.pages.utils;

import ca.gabrielferreira.wodfeeder.scraper.HtmlFileReader;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FindHeaderIndexesTest {

	private static Elements paragraphs;

	@BeforeAll
	private static void setUp() throws IOException {
		paragraphs = new HtmlFileReader().readHtmlFromFile();
	}

	@Test
	void findingIndexesForDayOfWeek() {
		Map<DayOfWeek, Integer> expected = new HashMap<>();
		expected.put(DayOfWeek.MONDAY, 5);
		expected.put(DayOfWeek.TUESDAY, 14);
		expected.put(DayOfWeek.WEDNESDAY, 23);
		expected.put(DayOfWeek.THURSDAY, 31);
		expected.put(DayOfWeek.FRIDAY, 40);
		expected.put(DayOfWeek.SATURDAY, 49);
		expected.put(DayOfWeek.SUNDAY, 53);

		List<String> p = paragraphs.stream().map(Element::text).collect(toList());

		Map<DayOfWeek, Integer> current = new FindHeaderIndexes<DayOfWeek>().find(Arrays.asList(DayOfWeek.values()), p);

		assertEquals(expected, current);
	}

	@Test
	void findingIndexesForOneDayOfWeek() {
		String day = "Body weight:\n" +
				"N/A\n" +
				"Strength:\n" +
				"Bench Press: (12, 9) + 5 X 7 reps Wide grip strict pull ups: (4, 6) + 5 X 8 reps Rest\n" +
				"1 min./station, increase load/set\n" +
				"Workout:\n" +
				"2 rounds:\n" +
				"30 Burpees 50 Flutter kicks (4 count for 1 rep) 50 push ups";

		String h1 = "Body weight:";
		String h2 = "Strength:";
		String h3 = "Workout:";

		List<String> headers = new ArrayList<>();
		headers.add(h1);
		headers.add(h2);
		headers.add(h3);

		Map<String, Integer> expected = new HashMap<>();
		expected.put(h1, 0);
		expected.put(h2, 2);
		expected.put(h3, 5);

		Map<String, Integer> current = new FindHeaderIndexes<String>().find(headers, Arrays.asList(day.split("\n")));

		assertEquals(expected, current);

	}

	@ParameterizedTest
	@CsvFileSource(resources = "/dailyWorkoutReaderTestResults.csv", numLinesToSkip = 1)
	void findingIndexesForAllDayOfWeek(String day, String expectedWorkout, String indexes) {

		List<String> expectedSHeaders = Arrays.asList("Body weight:", "Strength|Big Lift Progression", "Workout:");

		Map<String, Integer> expected = new HashMap<>();
		List<String> indexesList = Arrays.asList(indexes.split(","));

		for (int i = 0; i < indexesList.size(); i++) {
			if (indexesList.get(i).equals("null"))
				continue;

			Integer index = Integer.parseInt(indexesList.get(i));
			expected.put(expectedSHeaders.get(i), index);
		}


		Map<String, Integer> current = new FindHeaderIndexes<String>()
				.find(expectedSHeaders, Arrays.asList(expectedWorkout.split("\n")));

		assertEquals(expected, current);
	}
}

