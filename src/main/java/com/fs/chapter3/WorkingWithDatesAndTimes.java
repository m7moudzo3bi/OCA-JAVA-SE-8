package com.fs.chapter3;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @author Zo3bi
 *
 */
public class WorkingWithDatesAndTimes {

	////////////////////////////////////////////////
	public static void nowExample() {
		System.out.println(LocalDate.now()); // 2022-05-29
		System.out.println(LocalTime.now()); // 21:08:09.284914600
		System.out.println(LocalDateTime.now()); // 2022-05-29T21:08:33.057361700
	}

	////////////////////////////////////////////////
	public static void localDateOfExample() {
		LocalDate myBirthday1 = LocalDate.of(1997, Month.OCTOBER, 28); // 1997-10-28
		System.out.println(myBirthday1);

		LocalDate myBirthday2 = LocalDate.of(1997, 10, 28); // 1997-10-28
		System.out.println(myBirthday2);
	}

	////////////////////////////////////////////////
	public static void localTimeOfExample() {
		LocalTime workTime1 = LocalTime.of(8, 30); // 08:30
		System.out.println(workTime1);

		LocalTime workTime2 = LocalTime.of(8, 30, 0); // 08:30
		System.out.println(workTime2);

		LocalTime workTime3 = LocalTime.of(8, 30, 10); // 08:30:10
		System.out.println(workTime3);
	}

	////////////////////////////////////////////////
	public static void localDateTimeOfExample() {
		LocalDateTime t1 = LocalDateTime.of(1997, 10, 28, 10, 10, 10); // 1997-10-28T10:10:10
		System.out.println(t1);

		LocalDate date1 = LocalDate.of(1997, Month.OCTOBER, 28);
		LocalTime time1 = LocalTime.of(11, 11, 11, 11);

		LocalDateTime t2 = LocalDateTime.of(date1, time1); // 1997-10-28T11:11:11.000000011
		System.out.println(t2);
	}

	////////////////////////////////////////////////
	public static void doesNotCompileExampel() {
		// LocalDate date = new LocalDate(); //private constructor DOES NOT COMPLIE
		// LocalTime time = new LocalTime(); // private constructor DOES NOT COMPLIE
		// LocalDateTime dateTime = new LocalDateTime(); // private constructor DOES NOT
		// COMPLIE
	}

	////////////////////////////////////////////////
	public static void manipulatigDateExample() {
		LocalDate d1 = LocalDate.of(1997, Month.OCTOBER, 28);
		d1.plusMonths(1); // Immutable does not effect
		System.out.println(d1); // 1997-10-28

		d1 = d1.plusDays(1);
		System.out.println(d1); // 1997-10-29

		d1 = d1.plusMonths(1);
		System.out.println(d1); // 1997-11-29

		d1 = d1.plusYears(1);
		System.out.println(d1); // 1998-11-29

		d1 = d1.plusWeeks(4); // 1998-12-27
		System.out.println(d1);

		d1 = d1.minusYears(1);
		System.out.println(d1); // 1997-12-27

		d1 = d1.minusWeeks(4); // 1997-11-29
		System.out.println(d1);

		d1 = d1.minusMonths(1); // 1997-10-29
		System.out.println(d1);

		d1 = d1.minusYears(1);
		System.out.println(d1); // 1996-10-29
	}

	////////////////////////////////////////////////
	public static void manipulatigTimeExample() {
		LocalTime t1 = LocalTime.of(11, 11);
		System.out.println(t1); // 11:11

		t1 = t1.plusHours(1).plusMinutes(60).plusSeconds(60 * 24).plusNanos(100);
		System.out.println(t1); // 13:35:00.000000100

		t1 = t1.minusHours(1).minusMinutes(60).minusSeconds(60).plusHours(1);
		System.out.println(t1); // 12:34:00.000000100
	}

	////////////////////////////////////////////////
	public static void manipulatigDateTimeExample() {
		LocalDate d1 = LocalDate.of(1997, Month.OCTOBER, 28);
		LocalTime t1 = LocalTime.of(11, 11);
		LocalDateTime dt = LocalDateTime.of(d1, t1);
		dt = dt.minusDays(30).minusHours(10).minusYears(1).minusSeconds(100);
		System.out.println(dt); // 1996-09-28T01:09:20
	}

	////////////////////////////////////////////////
	public static void isBeforeExample() {
		LocalDate d1 = LocalDate.of(1997, Month.OCTOBER, 28);
		LocalDate d2 = LocalDate.of(1998, Month.MAY, 28);

		boolean before = d1.isBefore(d2); // true
		System.out.println(before);

		LocalTime t1 = LocalTime.of(11, 11);
		LocalTime t2 = LocalTime.of(12, 10);

		boolean before2 = t1.isBefore(t2);
		System.out.println(before2); // true
	}

	////////////////////////////////////////////////
	public static void periodExample() {
		// Period period = new Period(); // private constructor
		Period period = Period.ofMonths(1);
		LocalDate d1 = LocalDate.of(1997, Month.OCTOBER, 28);
		d1 = d1.plus(period); // 1997-11-28
		System.out.println(d1);

		Period period2 = Period.ofDays(1);
		LocalDateTime t1 = LocalDateTime.of(1997, 10, 28, 11, 11);
		t1 = t1.plus(period2);
		System.out.println(t1); // 1997-10-29T11:11
	}

	////////////////////////////////////////////////
	public static void getExample() {
		LocalDate d1 = LocalDate.of(1997, Month.OCTOBER, 28);
		System.out.println(d1.getYear()); // 1997
		System.out.println(d1.getDayOfMonth()); // 28
		System.out.println(d1.getDayOfWeek()); // TUESDAY
		System.out.println(d1.getMonth()); // OCTOBER

		LocalTime t1 = LocalTime.of(11, 11);
		System.out.println(t1.getHour()); // 11
		System.out.println(t1.getMinute()); // 11
		System.out.println(t1.getSecond()); // 0
		System.out.println(t1.getNano()); // 0
	}

	////////////////////////////////////////////////
	public static void formattingDatesExample() {
		LocalDate d1 = LocalDate.of(1997, Month.OCTOBER, 28);
		DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
		System.out.println(d1.format(isoDate)); // 1997-10-28

		DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(df.format(d1)); // 10/28/97

		DateTimeFormatter df2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		System.out.println(df2.format(d1)); // Oct 28, 1997
	}

	////////////////////////////////////////////////
	public static void formattingTimeExample() {
		LocalTime t1 = LocalTime.of(11, 11);
		DateTimeFormatter isoTime = DateTimeFormatter.ISO_TIME;
		System.out.println(t1.format(isoTime)); // 11:11:00

		DateTimeFormatter dfs = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		System.out.println(dfs.format(t1)); // 11:11 AM

		DateTimeFormatter df2 = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
		System.out.println(df2.format(t1)); // 11:11:00 AM
	}

	////////////////////////////////////////////////
	public static void formattingDateTimeExample() {
		LocalDate d1 = LocalDate.of(1997, Month.OCTOBER, 28);
		LocalTime t1 = LocalTime.of(11, 11);
		LocalDateTime dt = LocalDateTime.of(d1, t1);
		DateTimeFormatter ft = DateTimeFormatter.ISO_DATE_TIME;
		System.out.println(dt.format(ft)); // 1997-10-28T11:11:00

		DateTimeFormatter df1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println(df1.format(dt)); // 10/28/97, 11:11 AM

		DateTimeFormatter df2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		System.out.println(df2.format(dt)); // Oct 28, 1997, 11:11:00 AM
	}

	////////////////////////////////////////////////
	public static void ofPatternExample() {
		// Formatting
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println(df.format(LocalDate.now())); // 2022-05-29

		DateTimeFormatter df2 = DateTimeFormatter.ofPattern("hh:mm");
		System.out.println(df2.format(LocalTime.of(11, 11))); // 11:11

		DateTimeFormatter df3 = DateTimeFormatter.ofPattern("yyyy/MMM/dd hh:mm");
		System.out.println(df3.format(LocalDateTime.of(1997, Month.OCTOBER, 10, 11, 11)));
		// 1997/Oct/10 11:11

		// --------------------------------
		// Parsing
		DateTimeFormatter df4 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate parseDate = LocalDate.parse("1997-10-28", df4);
		System.out.println(parseDate); // 1997-10-28 LocalDate

		LocalDate parseDateAuto = LocalDate.parse("1997-10-28");
		System.out.println(parseDateAuto); // 1997-10-28

		LocalTime parseTime = LocalTime.parse("11:05");
		System.out.println(parseTime);
	}

	////////////////////////////////////////////////
	public static void main(String[] args) {
		ofPatternExample();
	}
}
