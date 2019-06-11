package com.gabrielpf.wodfeeder.vo;

import com.gabrielpf.wodfeeder.repo.WodRepo;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@Getter
public class WeeksAndYearsVO implements Serializable {

	private final List<Integer> weeks;
	private final List<Integer> years;

	public WeeksAndYearsVO(WodRepo repo) {

		this.weeks = repo.findAllDistinctWeeks();
		this.years = repo.findAllDistinctDates()
				.stream()
				.map(LocalDate::getYear)
				.distinct()
				.sorted()
				.collect(toList());
	}
}
