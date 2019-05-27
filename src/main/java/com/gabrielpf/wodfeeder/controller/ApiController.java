package com.gabrielpf.wodfeeder.controller;

import com.gabrielpf.wodfeeder.service.ScheduledTasks;
import com.gabrielpf.wodfeeder.vo.WodVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private WodVO vo;

	@Autowired
	private ScheduledTasks tasks;

	private final Gson gson = new Gson();
	private final GsonBuilder gsonBuilder = new GsonBuilder();

	@GetMapping(value = "/week", produces = "application/json")
	public String index() {
		Map<LocalDate, String> workoutForTheCurrentWeek = vo.getWorkoutForTheCurrentWeek();
		return gsonBuilder.setPrettyPrinting().create().toJson(workoutForTheCurrentWeek);
	}

	@GetMapping("/hello")
	public String hello() {

		return "Hello, the time at the server is now " + LocalDateTime.now() + "\n";
	}
}
