package ca.gabrielferreira.wodfeeder.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class HtmlFileReader {

	public Elements readHtmlFromFile() throws IOException {
		String pathname = "./src/test/resources/weeklyWorkputPageFragment.html";
		File in = new File(pathname);
		Document dom = Jsoup.parse(in, null);

		Elements elements = dom.select(".entry-content p");
		return elements;
	}
}