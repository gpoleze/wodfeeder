package com.gabrielpf.wodfeeder.scraper.pages;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class BasePage {

	protected Optional<Document> generateDOM(String url) {

		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Optional.ofNullable(doc);

	}
}

