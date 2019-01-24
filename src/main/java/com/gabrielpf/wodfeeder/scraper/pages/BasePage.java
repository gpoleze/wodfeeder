package com.gabrielpf.wodfeeder.scraper.pages;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.UnknownHostException;

public class BasePage {

	protected Document document;

	public BasePage(String url) throws UnknownHostException {
		this.document = generateDOM(url);
	}

	public BasePage(Document document) {
		if (document == null)
			throw new IllegalArgumentException("The paramenter must not be null");

		this.document = validateDOM(document, "The document has no content");
	}

	private Document generateDOM(String url) throws UnknownHostException {

		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (doc == null)
			throw new UnknownHostException();

		return validateDOM(doc, "The url " + url + "has no content");
	}

	private Document validateDOM(Document doc, String message) {
		if (doc.select("body *").isEmpty()) {
			throw new PageWithoutContentError(message);
		}

		return doc;
	}

	public Document getDocument() {
		return document;
	}
}

