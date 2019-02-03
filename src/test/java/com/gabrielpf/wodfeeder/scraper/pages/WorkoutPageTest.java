package com.gabrielpf.wodfeeder.scraper.pages;

import com.gabrielpf.wodfeeder.scraper.HtmlFileReader;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkoutPageTest {

    @BeforeEach
    void setUp() throws IOException {
        new HtmlFileReader("/workoutsPage.html");
    }

    @Test
    void getLastPostLink() throws IOException {
        String cssSelector = ".entry-title-link";
        String expected = "http://crossfitwildlife.com/workout-for-the-week-of-january-21-2019-to-january-27-2019/";

        String filepath = "src/test/resources/workoutsPage.html";
        Document dom = new HtmlFileReader(filepath).readHtmlFromFile();

        WorkoutPage workoutPage = new WorkoutPage(dom);
        String actual = null;
        actual = workoutPage.getLastPostLink(cssSelector);

        assertEquals(expected, actual);
    }

}