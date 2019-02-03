package com.gabrielpf.wodfeeder;

import com.gabrielpf.wodfeeder.feeder.Feeder;
import com.gabrielpf.wodfeeder.scraper.pages.WeekWodPage;
import com.gabrielpf.wodfeeder.scraper.pages.WorkoutPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class HomeControler {

    //    @RequestMapping(value = "/", produces = "application/json")
    @RequestMapping(value = "/")
    public String home(Model model) {
        String lastPostLink = null;
        try {
            WorkoutPage workoutPage = new WorkoutPage("http://crossfitwildlife.com/workouts/");
            lastPostLink = workoutPage.getLastPostLink();
        } catch (UnknownHostException e) {
            e.printStackTrace();
//            return HttpStatus.NOT_FOUND;
        }


        Map<LocalDate, String> localDateStringMap = null;
        try {
            WeekWodPage weekWodPage = new WeekWodPage(lastPostLink);
            localDateStringMap = weekWodPage.readDailyWorkouts();
        } catch (UnknownHostException e) {
//            return HttpStatus.NOT_FOUND;
        }

        model.addAttribute("latestWorkouts", new TreeMap<>(localDateStringMap));

        return "home";
    }
}
