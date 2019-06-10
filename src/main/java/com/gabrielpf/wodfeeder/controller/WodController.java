package com.gabrielpf.wodfeeder.controller;

import com.gabrielpf.wodfeeder.model.WOD;
import com.gabrielpf.wodfeeder.service.ScheduledTasks;
import com.gabrielpf.wodfeeder.utils.WeekUtil;
import com.gabrielpf.wodfeeder.vo.WodVO;
import com.gabrielpf.wodfeeder.vo.WeeksAndYearsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/wod", produces = "application/json")
public class WodController {

	@Autowired private WodVO wodVO;
	@Autowired private WeeksAndYearsVO weeksAndYearsVO;
	@Autowired private ScheduledTasks tasks;

	@GetMapping("/{date}")
	public WOD workoutOftheDay(@PathVariable("date") String stringDate) {
		LocalDate date = LocalDate.parse(stringDate);

		return wodVO.getWorkout(date).orElseGet(() -> wodVO.getInstanceWithNoExerciceForTheDate(date));
	}

	@GetMapping("/week")
	public List<WOD> weeklyWorkouts() {
		return wodVO.getWodsForTheCurrentWeek();
	}

	@GetMapping("/week/{week}")
	public List<WOD> weeklyWorkouts(@PathVariable(value = "week") Integer week) {
		return wodVO.getWodsForTheCurrentWeek(week);
	}

	@GetMapping("/week/{week}/year/{year}")
	public List<WOD> weeklyWorkouts(@PathVariable("week") Integer week, @PathVariable("year") Integer year) {
		return wodVO.getWodsForTheCurrentWeek(week, year);
	}

	@GetMapping(value = "/weeks")
	public HashMap<String, Object> getWeekAndYears() {
		var map = new HashMap<String,Object>();
		map.put("currentWeek", WeekUtil.getWeekOfYear(LocalDate.now()));
		map.put("currentYear", LocalDate.now().getYear());
		map.put("weeks", weeksAndYearsVO.getWeeks());
		map.put("years", weeksAndYearsVO.getYears());

		return map;
	}

	@GetMapping("/reload")
	public List<WOD> reloadWorkouts() {
		tasks.scrapThisWeekWorkout();
		return weeklyWorkouts();
	}
}
