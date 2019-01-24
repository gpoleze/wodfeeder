package com.gabrielpf.wodfeeder.scraper.pages;

import com.gabrielpf.wodfeeder.scraper.HtmlFileReader;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkoutPageTest {

	@BeforeEach
	void setUp() throws IOException {
		new HtmlFileReader("/workoutsPage.html");
	}

	@Test
	void getLastPostLink() throws UnknownHostException {
		String url = "http://crossfitwildlife.com/workouts/";
		String cssSelector = ".entry-title-link";
		String expected = "http://crossfitwildlife.com/workout-for-the-week-of-january-21-2019-to-january-27-2019/";

		WorkoutPage workoutPage = new WorkoutPage(url);
		String actual = null;
		try {
			actual = workoutPage.getLastPostLink(cssSelector);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}

		assertEquals(expected,actual);
	}

}