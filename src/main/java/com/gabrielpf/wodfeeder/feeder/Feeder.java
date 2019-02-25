package com.gabrielpf.wodfeeder.feeder;

import com.gabrielpf.wodfeeder.model.WOD;
import com.gabrielpf.wodfeeder.vo.WodVO;
import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Content;
import com.rometools.rome.feed.rss.Description;
import com.rometools.rome.feed.rss.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class Feeder extends AbstractRssFeedView {

    @Autowired
    private WodVO vo;

    @Override
    protected void buildFeedMetadata(Map<String, Object> model, Channel feed, HttpServletRequest request) {
        feed.setTitle("WodFeeder RSS Feed");
        feed.setDescription("All your workouts in your hands");
        feed.setLink("https://wodfeeder.herokuapp.com");
    }

    @Override
    protected List<Item> buildFeedItems(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Item> items = new ArrayList<>();

        List<WOD> wods = vo.getWodsForTheCurrentWeek();

        wods.forEach(wod -> {

                    String title = "Workout of the Day " + wod.getDate();
                    String link = "https://wodfeeder.herokuapp.com/wod/" + wod.getDate();
                    Description description = new Description();
                    description.setValue("Let's see what goodies we have today and rock it out!");

                    Content content = new Content();
                    content.setValue(wod.getExercises());

                    Item entryOne = new Item();

                    entryOne.setTitle(title);
                    entryOne.setLink(link);
                    entryOne.setDescription(description);
                    entryOne.setPubDate(Date.from(wod.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                    entryOne.setContent(content);

                    items.add(entryOne);
                }
        );

        return items;
    }
}
