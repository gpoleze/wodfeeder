package com.gabrielpf.wodfeeder.vo;

import com.gabrielpf.wodfeeder.model.WOD;
import com.gabrielpf.wodfeeder.repo.WodRepo;
import com.gabrielpf.wodfeeder.scraper.pages.WeekWodPage;
import com.gabrielpf.wodfeeder.scraper.pages.WorkoutPage;
import org.openqa.selenium.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class WodVO {

    @Autowired
    private WodRepo repo;

    public Optional<WOD> getWorkout(LocalDate date) {
        if (date == null)
            throw new InvalidArgumentException("Date should not be null");

        return Optional.ofNullable(repo.findAllByDate(date));
    }

    public Map<LocalDate, String> getWorkoutForTheCurrentWeek() {
        Map<LocalDate, String> weekWorkout = new HashMap<>();
        LocalDate firstDayOfWeek = LocalDate.now().minusDays(LocalDate.now().getDayOfWeek().getValue() - 1);

        AtomicBoolean hasMissingDate = new AtomicBoolean(false);

        for (int i = 0; i < 7; i++) {
            LocalDate date = firstDayOfWeek.plusDays(i);
            WOD workout = getWorkout(date).orElseGet(() -> {
                hasMissingDate.set(true);
                return getInstanceWithNoExerciceForTheDate(date);
            });
            weekWorkout.put(date, workout.getExercises());
        }

        if (hasMissingDate.get())
            return scrapThisWeekWorkout();

        return weekWorkout;
    }

    public Map<LocalDate, String> scrapThisWeekWorkout() {
        String lastPostLink = null;
        try {
            WorkoutPage workoutPage = new WorkoutPage("http://crossfitwildlife.com/workouts/");
            lastPostLink = workoutPage.getLastPostLink();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return Collections.EMPTY_MAP;
        }

        Map<LocalDate, String> localDateStringMap = null;
        try {
            WeekWodPage weekWodPage = new WeekWodPage(lastPostLink);
            localDateStringMap = weekWodPage.readDailyWorkouts();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return Collections.EMPTY_MAP;
        }

        localDateStringMap.forEach((date, exercises) -> {
            WOD wod = repo.findAllByDate(date);

            if (wod == null) {
                repo.save(new WOD(date, exercises));
                return;
            }

            if (wod.getExercises().equals(exercises))
                return;

            wod.setExercises(exercises);
            repo.save(wod);


        });

        return localDateStringMap;
    }

    public WOD getInstanceWithNoExerciceForTheDate(LocalDate date) {
        return new WOD(date, "No Exercises found for " + date);
    }

}
