package com.gabrielpf.wodfeeder.vo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class WeekUtil {

	public static int getWeekOfYear(final LocalDate date) {
		WeekFields weekFields = WeekFields.of(DayOfWeek.SUNDAY, 1);
		return date.get(weekFields.weekOfWeekBasedYear());
	}

	public static LocalDate getFirstDayOfWeek(final int week) {
		return getFirstDayOfWeek(week, LocalDate.now().getYear());
	}

	public static LocalDate getFirstDayOfWeek(final int week, final int year) {
		final LocalDate date = LocalDate.of(year, 1, 1);
		final LocalDate firstDayOfTheWeek = date.minusDays(date.getDayOfWeek().getValue());

		return firstDayOfTheWeek.plusWeeks(week - 1);
	}
}
