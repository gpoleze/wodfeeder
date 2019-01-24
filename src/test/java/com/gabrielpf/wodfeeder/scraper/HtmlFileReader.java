package com.gabrielpf.wodfeeder.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class HtmlFileReader {
	private String filepath;

	public HtmlFileReader(String filepath) {
		this.filepath = filepath;
	}

	public Elements readHtmlFromFile(String cssSelection) throws IOException {
		File in = new File(filepath);
		Document dom = Jsoup.parse(in, null);

		Elements elements = dom.select(cssSelection);
		return elements;
	}

}