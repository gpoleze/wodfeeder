package com.gabrielpf.wodfeeder.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class HtmlFileReader {
	private String filepath;

	public HtmlFileReader(String filepath) {
		this.filepath = filepath;
	}

	public Elements readHtmlFromFile(String cssSelection) throws IOException {
		return readHtmlFromFile().select(cssSelection);
	}

    public Document readHtmlFromFile() throws IOException {
        File in = new File(filepath);
        return Jsoup.parse(in, null);
    }

}