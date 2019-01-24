package com.gabrielpf.wodfeeder.scraper.pages.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class FindHeaderIndexes<T> {

	public Map<T, Integer> find(List<T> headers, List<String> indexes) {

		if (headers.isEmpty() || indexes.isEmpty()) return Collections.emptyMap();

		HashMap<T, Integer> headerIndexes = new HashMap<>();

		headers.forEach(header -> {
					Pattern pattern = Pattern.compile("(?i)" + header.toString());
					OptionalInt line = IntStream.range(0, indexes.size())
							.filter(i -> pattern.matcher(indexes.get(i)).find())
							.findFirst();
					if (line.isPresent())
						headerIndexes.put(header, line.getAsInt());
				});
		return Collections.unmodifiableMap(headerIndexes);
	}

}
