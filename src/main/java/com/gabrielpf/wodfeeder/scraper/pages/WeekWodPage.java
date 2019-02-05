package com.gabrielpf.wodfeeder.scraper.pages;

import com.gabrielpf.wodfeeder.scraper.pages.utils.DailyWorkoutReader;
import org.jsoup.nodes.Document;

import java.net.UnknownHostException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class WeekWodPage extends BasePage {

    private DailyWorkoutReader workouts;

    public WeekWodPage(String url) throws UnknownHostException {
        super(url);
        workouts = readParagraphs(document);
    }

    public WeekWodPage(Document document) {
        super(document);
        workouts = readParagraphs(document);
    }

    public DailyWorkoutReader readParagraphs(Document document) {
        return new DailyWorkoutReader(document.select("p"));
    }

    public LocalDate readPublishingDate() {

        String publishedTimeString = document.select(".entry-time").attr("datetime");

        LocalDateTime publishedTime = LocalDateTime.parse(publishedTimeString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return publishedTime.toLocalDate();
    }

    public Map<LocalDate, String> readDailyWorkouts() {
        LocalDate publishingDate = readPublishingDate();
        final int dayOfWeek = publishingDate.getDayOfWeek().getValue() == 7 ? 0 : publishingDate.getDayOfWeek().getValue();

        return Arrays.stream(DayOfWeek.values())
                .filter(day -> day != DayOfWeek.SUNDAY)
                .collect(toMap(day -> publishingDate.plusDays(day.getValue() - dayOfWeek), workouts::getWorkoutForDay));
    }


}