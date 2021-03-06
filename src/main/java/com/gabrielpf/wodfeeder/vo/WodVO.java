package com.gabrielpf.wodfeeder.vo;

import com.gabrielpf.wodfeeder.model.WOD;
import com.gabrielpf.wodfeeder.repo.WodRepo;
import com.gabrielpf.wodfeeder.utils.WeekUtil;
import org.openqa.selenium.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.gabrielpf.wodfeeder.utils.WeekUtil.getWeekOfYear;

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


		for (int i = 0; i < 7; i++) {
			LocalDate date = firstDayOfWeek.plusDays(i);
			WOD workout = getWorkout(date).orElseGet(() -> {
				return getInstanceWithNoExerciceForTheDate(date);
			});
			weekWorkout.put(date, workout.getExercises());
		}

		return weekWorkout;
	}

	public WOD getInstanceWithNoExerciceForTheDate(LocalDate date) {
		return new WOD(date, "No Exercises found for " + date);
	}

	public List<WOD> getWodsForTheCurrentWeek() {
		return getWodsForTheCurrentWeek(getWeekOfYear(LocalDate.now()), LocalDate.now().getYear());
	}

	public List<WOD> getWodsForTheCurrentWeek(Integer week) {
		return getWodsForTheCurrentWeek(week, LocalDate.now().getYear());
	}

	public List<WOD> getWodsForTheCurrentWeek(Integer week, Integer year) {
		List<WOD> wods = new ArrayList<>();

		LocalDate firstDayOfWeek = WeekUtil.getFirstDayOfWeek(week, year);
		for (int i = 0; i < 7; i++) {
			LocalDate date = firstDayOfWeek.plusDays(i);
			WOD wod = getWorkout(date).orElseGet(() -> {
				return getInstanceWithNoExerciceForTheDate(date);
			});
			wods.add(wod);
		}

		return wods;
	}
}
