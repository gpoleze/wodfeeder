package com.gabrielpf.wodfeeder.feeder;

import com.rometools.rome.feed.synd.*;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Feeder {

    private final SyndFeed feed;

    public Feeder() {
        feed = new SyndFeedImpl();
        feed.setFeedType("rss_1.0");
        feed.setTitle("Workout of the Day");
        feed.setLink("192.168.0.10/2019-02-02");
        feed.setDescription("Let's see what goodies we have today and rock it out!");
    }

    private Feeder setEntry(SyndEntry entry) {
        entry.setTitle("Entry title");
        entry.setLink("http://www.somelink.com/entry1");

        feed.setEntries(Arrays.asList(entry));
        return this;
    }

    private Feeder addDescription(SyndEntry entry) {
        SyndContent description = new SyndContentImpl();
        description.setType("text/html");
        description.setValue("First entry");

        entry.setDescription(description);

        return this;
    }

    private Feeder addCategory(SyndEntry entry) {
        List<SyndCategory> categories = new ArrayList<>();
        SyndCategory category = new SyndCategoryImpl();
        category.setName("Sophisticated category");
        categories.add(category);

        entry.setCategories(categories);

        return this;
    }

    public String publish() {
        SyndFeedOutput syndFeedOutput = new SyndFeedOutput();
        String output = "";
        try {
            output = syndFeedOutput.outputString(feed);
        } catch (FeedException e) {
            e.printStackTrace();
        }
        return output;
    }
}
