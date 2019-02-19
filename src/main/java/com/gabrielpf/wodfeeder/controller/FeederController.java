package com.gabrielpf.wodfeeder.controller;

import com.gabrielpf.wodfeeder.model.WOD;
import com.gabrielpf.wodfeeder.vo.WodVO;
import com.rometools.rome.feed.synd.*;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.Collections;

@Controller
public class FeederController {

    private final WodVO vo;

    @Autowired
    public FeederController(WodVO vo) {
        this.vo = vo;
    }

    @RequestMapping("/feed")
    @ResponseBody
    public String getFeed() throws FeedException {
        LocalDate today = LocalDate.now();

        SyndFeed feed = new SyndFeedImpl();
        feed.setFeedType("atom_1.0");

        SyndEntry entry = new SyndEntryImpl();
        entry.setTitle("Workout for " + today);

        SyndContent content = new SyndContentImpl();

        WOD wod = vo.getWorkout(today).orElse(vo.getInstanceWithNoExerciceForTheDate(today));
        content.setValue(wod.getExercises());

        entry.setContents(Collections.singletonList(content));
        feed.setEntries(Collections.singletonList(entry));

        return new SyndFeedOutput().outputString(feed);
    }


}
