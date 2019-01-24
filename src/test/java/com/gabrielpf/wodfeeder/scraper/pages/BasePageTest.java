package com.gabrielpf.wodfeeder.scraper.pages;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

class BasePageTest {
	@Test
	void instantiantingBasePageWithAnInvalidUrlThrowUnknownHostException() {
		String url = "http://www.asdlkj239847.com";

		Executable classInstantiation = () -> new BasePage(url);

		assertThrows(UnknownHostException.class, classInstantiation);
	}


	@Test
	void instantiantingBasePageWithANullDocumentThrowIllegalArgumentException() {
		Document document = null;
		Executable classInstantiation = () -> new BasePage(document);

		assertThrows(IllegalArgumentException.class, classInstantiation);
	}

	@Test
	void instantiantingBasePageWithAnEmptyDocumentThrowPageWithoutContentError() {
		Document document = new Document("");
		Executable classInstantiation = () -> new BasePage(document);

		assertThrows(PageWithoutContentError.class, classInstantiation);
	}

}