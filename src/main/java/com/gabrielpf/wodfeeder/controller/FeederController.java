package com.gabrielpf.wodfeeder.controller;

import com.gabrielpf.wodfeeder.feeder.Feeder;
import com.rometools.rome.io.FeedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FeederController {

    @Autowired
    private Feeder feed;

    @RequestMapping("/feed")
    public View getFeed() throws FeedException {
        return feed;
    }
}
