package com.gabrielpf.wodfeeder.service;

import com.gabrielpf.wodfeeder.model.WOD;
import com.gabrielpf.wodfeeder.repo.WodRepo;
import com.gabrielpf.wodfeeder.scraper.pages.WeekWodPage;
import com.gabrielpf.wodfeeder.scraper.pages.WorkoutPage;
import com.gabrielpf.wodfeeder.utils.WeekUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private final WodRepo repo;
    private final String URL = "http://crossfitwildlife.com/workouts/";

    @Autowired
    public ScheduledTasks(WodRepo repo) {
        this.repo = repo;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void scrapThisWeekWorkout() {
        String methodName = new Object() {
        }
                .getClass()
                .getEnclosingMethod()
                .getName();
        log.info("Starting the scheduled task " + ScheduledTasks.class.getName() + "." + methodName);

        log.info("Scrapping the webpage " + URL);

        log.info("Getting URL for last posted article");
        Optional<String> lastPostLink = getLastPostUrl();

        if (!lastPostLink.isPresent()) {
            log.error("Leaving " + methodName + " method wihtout finishing it");
            return;
        }

	    updateWeeks();
        Map<LocalDate, String> localDateStringMap = getLocalDateStringMap(lastPostLink.get());

        saveToDatabase(localDateStringMap);

    }

    public void saveToDatabase(Map<LocalDate, String> localDateStringMap) {
        localDateStringMap.forEach((date, exercises) -> {
            WOD wod = repo.findAllByDate(date);

            if (wod == null) {
                WOD entity = new WOD(date, exercises);
                log.info("Saving on the database: " + entity);
                repo.save(entity);
                return;
            }

            if (wod.getExercises().equals(exercises)) {
                log.info("The entity is already present in the database, and there is no update:" + wod);
                return;
            }

            log.info("The entity " + wod + "is already present in the database, and had the exercises updated to " + exercises);
            wod.setExercises(exercises);
            repo.save(wod);

        });
    }

    public Map<LocalDate, String> getLocalDateStringMap(String lastPostLink) {
        log.info("Scrapping the webpage " + lastPostLink);

        Map<LocalDate, String> localDateStringMap = null;

        try {
            WeekWodPage weekWodPage = new WeekWodPage(lastPostLink);
            localDateStringMap = weekWodPage.readDailyWorkouts();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return localDateStringMap != null ? localDateStringMap : Collections.emptyMap();
    }

    public Optional<String> getLastPostUrl() {
        String lastPostLink = null;

        try {
            WorkoutPage workoutPage = new WorkoutPage(URL);
            lastPostLink = workoutPage.getLastPostLink();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        log.info("Link found was " + lastPostLink);

        return Optional.ofNullable(lastPostLink);
    }

	private void updateWeeks() {
		List<WOD> wods = repo.findAllByWeek(0);

		log.info("Rows with zeroed week: " + wods);

		wods.forEach(wod -> {
			int week = WeekUtil.getWeekOfYear(wod.getDate());
			wod.setWeek(week);
			repo.save(wod);
		});
	}

}
