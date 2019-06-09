package com.gabrielpf.wodfeeder.vo;

import com.gabrielpf.wodfeeder.utils.WeekUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WeekUtilTest {

	@Test
	void firstWeekOfYear() {
		LocalDate tuesday = LocalDate.of(2019, 1, 1);

		int sunday = WeekUtil.getWeekOfYear(tuesday.minusDays(2));
		assertEquals(1, sunday);

		assertEquals(1, WeekUtil.getWeekOfYear(tuesday));

		int saturday = WeekUtil.getWeekOfYear(tuesday.plusDays(4));
		assertEquals(1, saturday);
	}

	@Test
	void lastWeekOfYear() {
		LocalDate monday = LocalDate.of(2018, 12, 31);

		int sunday = WeekUtil.getWeekOfYear(monday.minusDays(8));
		assertEquals(52, sunday);

		int saturday = WeekUtil.getWeekOfYear(monday.minusDays(2));
		assertEquals(52, saturday);
	}

	@Test
	void WeekInMiddleOfYear() {
		LocalDate sunday = LocalDate.of(2019, 5, 26);

		assertEquals(22, WeekUtil.getWeekOfYear(sunday));

		int previousSaturday = WeekUtil.getWeekOfYear(sunday.minusDays(1));
		assertEquals(21, previousSaturday);

		int nextSaturday = WeekUtil.getWeekOfYear(sunday.plusDays(6));
		assertEquals(22, nextSaturday);
	}

	@Test
	void FirstDayOfAWeekIsSunday() {
		// January 1st 2019 was a Tuesday
		LocalDate tuesday = LocalDate.of(2019, 1, 1);

		int saturday = WeekUtil.getWeekOfYear(tuesday.plusDays(4));
		assertEquals(1, saturday);

		int sunday = WeekUtil.getWeekOfYear(tuesday.plusDays(5));
		assertEquals(2, sunday);

		int monday = WeekUtil.getWeekOfYear(tuesday.plusDays(6));
		assertEquals(2, monday);

	}

	@Test
	void getFirstDayOfWeekForFirstDayOfYear() {

		LocalDate sunday = LocalDate.of(2018, 12, 30);

		LocalDate week = WeekUtil.getFirstDayOfWeek(1, 2019);
		assertEquals(sunday, week);

	}

	@Test
	void getFirstDayOfWeekForLastDayOfYear() {
		LocalDate sunday = LocalDate.of(2018, 12, 23);

		LocalDate week = WeekUtil.getFirstDayOfWeek(52, 2018);
		assertEquals(sunday, week);
	}

	@Test
	void getFirstDayOfWeekForDayMiddleOfYear() {
		LocalDate sunday = LocalDate.of(2019, 5, 26);

		LocalDate week = WeekUtil.getFirstDayOfWeek(22, 2019);
		assertEquals(sunday, week);
	}
}