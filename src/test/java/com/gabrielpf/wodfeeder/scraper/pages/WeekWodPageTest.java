package com.gabrielpf.wodfeeder.scraper.pages;

import com.gabrielpf.wodfeeder.scraper.HtmlFileReader;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeekWodPageTest extends BasePageTest {


    private WeekWodPage weekWodPage;
    private static Map<DayOfWeek, LocalDate> expectedDates = new HashMap<>();

    @BeforeAll
    static void setUpAll() {
        populateExpectedResults();
    }

    @BeforeEach
    void setUpEach() throws IOException {
        HtmlFileReader htmlFileReader = new HtmlFileReader("src/test/resources/weeklyWorkputPageFragment.html");
        Document document = htmlFileReader.readHtmlFromFile();
        weekWodPage = new WeekWodPage(document);
    }

    private static void populateExpectedResults() {
        LocalDate sunday = LocalDate.parse("2019-01-06");
        Arrays.stream(DayOfWeek.values()).forEachOrdered(day -> expectedDates.put(day, sunday.plusDays(day.getValue())));
    }

    @Test
    void readPublishingDate() {

        LocalDate actual = weekWodPage.readPublishingDate();

        LocalDateTime publishedDate = LocalDateTime.parse("2019-01-06T07:00:05+00:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        assertEquals("2019-01-06", actual.toString());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dailyWorkoutReaderTestResults.csv", numLinesToSkip = 1)
    void readDailyWorkouts(String day, String expected) {


        Map<LocalDate, String> actual = weekWodPage.readDailyWorkouts();

        LocalDate keyDate = expectedDates.get(DayOfWeek.valueOf(day));

        assertEquals(expected, actual.get(keyDate));
    }
}