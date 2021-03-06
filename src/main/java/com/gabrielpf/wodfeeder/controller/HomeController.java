package com.gabrielpf.wodfeeder.controller;

import com.gabrielpf.wodfeeder.service.ScheduledTasks;
import com.gabrielpf.wodfeeder.vo.WodVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class HomeController {

    @Autowired
    private WodVO vo;

    @Autowired
    private ScheduledTasks tasks;

    @RequestMapping(value = "/home")
    public String home(Model model) {

        Map<LocalDate, String> localDateStringMap = vo.getWorkoutForTheCurrentWeek();

        model.addAttribute("latestWorkouts", new TreeMap<>(localDateStringMap));

        return "home";
    }
}
