package com.gabrielpf.wodfeeder.scraper.pages;

public class PageWithoutContentError extends Error {
	public PageWithoutContentError() {
		super();
	}

	public PageWithoutContentError(String message) {
		super(message);
	}

	public PageWithoutContentError(String message, Throwable cause) {
		super(message, cause);
	}

	public PageWithoutContentError(Throwable cause) {
		super(cause);
	}
}
