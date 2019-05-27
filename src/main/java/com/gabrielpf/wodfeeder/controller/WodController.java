package com.gabrielpf.wodfeeder.controller;

import com.gabrielpf.wodfeeder.model.WOD;
import com.gabrielpf.wodfeeder.vo.WodVO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/wod", produces = "application/json")
public class WodController {

	@Autowired
	private WodVO vo;
	private final Gson gson = new Gson();

	@GetMapping("/{date}")
	public String workoutOftheDay(@PathVariable("date") String stringDate) {
		LocalDate date = LocalDate.parse(stringDate);

		WOD wod = vo.getWorkout(date).orElseGet(() -> vo.getInstanceWithNoExerciceForTheDate(date));

		return gson.toJson(wod);
	}

	@GetMapping("/week")
	public String weeklyWorkouts() {
		return gson.toJson(vo.getWodsForTheCurrentWeek());
	}

	@GetMapping("/week/{week}")
	public String weeklyWorkouts(@PathVariable(value = "week") Integer week) {
		return gson.toJson(vo.getWodsForTheCurrentWeek(week));
	}

	@GetMapping("/week/{week}/year/{year}")
	public String weeklyWorkouts(@PathVariable("week") Integer week, @PathVariable("year") Integer year) {
		return gson.toJson(vo.getWodsForTheCurrentWeek(week, year));
	}
}
