package com.gabrielpf.wodfeeder.controller;

import com.gabrielpf.wodfeeder.model.WOD;
import com.gabrielpf.wodfeeder.vo.WodVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/wod")
public class WodController {

    @Autowired
    private WodVO vo;

    @RequestMapping("/{date}")
    public String workoutOftheDay(@PathVariable("date") String stringDate, Model model) {
        LocalDate date = LocalDate.parse(stringDate);

        WOD wod = vo.getWorkout(date).orElseGet(() -> vo.getInstanceWithNoExerciceForTheDate(date));

        model.addAttribute("wod", wod.getExercises());
        model.addAttribute("date", date);

        return "wod";
    }
}
