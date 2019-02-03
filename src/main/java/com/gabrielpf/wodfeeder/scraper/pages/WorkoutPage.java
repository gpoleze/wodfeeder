package com.gabrielpf.wodfeeder.scraper.pages;

import org.jsoup.nodes.Document;

import java.net.UnknownHostException;

public class WorkoutPage extends BasePage {

	public WorkoutPage(String url) throws UnknownHostException {
		super(url);
	}

	public WorkoutPage(Document document) {
		super(document);
	}

	public String getLastPostLink(String cssSelection){

		return document
				.select(cssSelection)
				.get(0)
				.attr("href");
	}

	public String getLastPostLink(){
		return getLastPostLink(".entry-title-link");
	}

}
