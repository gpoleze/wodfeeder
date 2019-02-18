package com.gabrielpf.wodfeeder.controller;

import com.gabrielpf.wodfeeder.vo.WodVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class HomeControler {

    @Autowired
    private WodVO vo;

    //    @RequestMapping(value = "/", produces = "application/json")
    @RequestMapping(value = "/")
    public String home(Model model) {

        Map<LocalDate, String> localDateStringMap = vo.getWorkoutForTheCurrentWeek();

        model.addAttribute("latestWorkouts", new TreeMap<>(localDateStringMap));

        return "home";
    }
}
