
/*
 * This unit test has at least one @Test method for each of the ten methods 
 * in SelectionFun.java.  * However, they are incomplete, and do not represent 
 * 100% code coverage. The assertions come nowhere close.  This is meant to
 * encourage you to think of other needed test cases and add your own asserts.
 * We will be running a unit test that is much larger than this starter unit test.
 * 
 * Programmers: Rick Mercer and Muhammad Asifur Rahman
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SelectionFunTest {

	private SelectionFun myFun = new SelectionFun();

	@Test
	public void testFailedSalary() {
		assertEquals(1500.0, myFun.salary(9999.00), 0.001);
		assertEquals(2400.0, myFun.salary(25000.00), 0.001);
		assertEquals(1750.0, myFun.salary(15000.00), 0.001);
		assertEquals(3400.0, myFun.salary(35000.00), 0.001);

	}

	@Test
	public void testFailedFirstofthree() {
		assertEquals("a", myFun.firstOf3Strings("a", "b", "c"));
		assertEquals("hello", myFun.firstOf3Strings("hello", "world", "foo"));
		assertEquals("fizz", myFun.firstOf3Strings("fizz", "buzz", "fizzbuzz"));
		assertEquals("", myFun.firstOf3Strings("", "x", "x"));
	}

	@Test
	public void testFizzBuzz1() {
		assertEquals("Fizz", myFun.fizzBuzz("f"));
		assertEquals("abc", myFun.fizzBuzz("abc"));
		assertEquals("FizzBuzz", myFun.fizzBuzz("fib"));
		assertEquals("Buzz", myFun.fizzBuzz("cab"));
		assertEquals("null", myFun.fizzBuzz("null"));
	}

	@Test
	public void testFailedRomannumeralAllUpperCase() {
		assertEquals(1, myFun.romanNumeral('I'));
		assertEquals(5, myFun.romanNumeral('V'));
		assertEquals(10, myFun.romanNumeral('X'));
		assertEquals(50, myFun.romanNumeral('L'));
		assertEquals(100, myFun.romanNumeral('C'));
		assertEquals(500, myFun.romanNumeral('D'));
		assertEquals(1000, myFun.romanNumeral('M'));
		assertEquals(0, myFun.romanNumeral('K'));
	}

	@Test
	public void testFailedRomannumeralAllLowerCase() {
		assertEquals(1, myFun.romanNumeral('i'));
		assertEquals(5, myFun.romanNumeral('v'));
		assertEquals(10, myFun.romanNumeral('x'));
		assertEquals(50, myFun.romanNumeral('l'));
		assertEquals(100, myFun.romanNumeral('c'));
		assertEquals(500, myFun.romanNumeral('d'));
		assertEquals(1000, myFun.romanNumeral('m'));
		assertEquals(0, myFun.romanNumeral('k'));
	}

	@Test
	public void testSeason12_1_2True() {
		assertEquals("Testing season", "Winter", myFun.season(12, true));
		assertEquals("Testing season", "Spring", myFun.season(3, true));
		assertEquals("Testing season", "Summer", myFun.season(6, true));
		assertEquals("Testing season", "Fall", myFun.season(9, true));

		// Southern Hemisphere Tests
		assertEquals("Testing season", "Summer", myFun.season(12, false));
		assertEquals("Testing season", "Fall", myFun.season(3, false));
		assertEquals("Testing season", "Winter", myFun.season(6, false));
		assertEquals("Testing season", "Spring", myFun.season(9, false));

		// Edge Cases
		assertEquals("Testing season", "Invalid input", myFun.season(0, true)); // Invalid month
		assertEquals("Testing season", "Invalid input", myFun.season(13, false)); // Invalid month

	}

	@Test
	public void testFailedThanksdate1() {
		assertEquals(25, myFun.thanksDate(1));
		assertEquals(24, myFun.thanksDate(2)); // November starts on Tuesday
		assertEquals(28, myFun.thanksDate(5)); // November starts on Friday
		assertEquals(26, myFun.thanksDate(7)); // November starts on Sunday
		assertEquals(-1, myFun.thanksDate(0)); // Invalid input
		assertEquals(-1, myFun.thanksDate(8));
	}

	@Test
	public void testFailedDaynumber1() {
		assertEquals(31, myFun.dayNumber("01/31/2017"));
		assertEquals(-1, myFun.dayNumber("13/11/2020"));
		assertEquals(3, myFun.dayNumber("01/03/2016"));
		assertEquals(365, myFun.dayNumber("12/31/2017"));
		assertEquals(366, myFun.dayNumber("12/31/2020"));

	}

	@Test
	public void testFailedDayofweek1() {
		assertEquals("Monday", myFun.dayOfWeek(1));
		assertEquals("Tuesday", myFun.dayOfWeek(2));
		assertEquals("Wednesday", myFun.dayOfWeek(3));
		assertEquals("Thursday", myFun.dayOfWeek(4));
		assertEquals("Friday", myFun.dayOfWeek(5));
		assertEquals("Saturday", myFun.dayOfWeek(6));
		assertEquals("Sunday", myFun.dayOfWeek(7));
		assertEquals("Unknown", myFun.dayOfWeek(8));
	}

	@Test
	public void testFailedDaysinmonthWhenNotALeapYear2() {
		assertEquals(31, myFun.daysInMonth(7, 2018));
		assertEquals(28, myFun.daysInMonth(2, 2019));
		assertEquals(30, myFun.daysInMonth(11, 2022));
		assertEquals(31, myFun.daysInMonth(12, 2017));
	}

	@Test
	public void testFailedDaysinmonthWhenALeapYear2() {
		assertEquals(29, myFun.daysInMonth(2, 2000));
		assertEquals(29, myFun.daysInMonth(2, 2020));
	}

	@Test
	public void testFailedDaysinmonthForBoundaryYears() {
		assertEquals(31, myFun.daysInMonth(1, 1582));
	}

	@Test
	public void testFailedValidDateWhenTheyAreAllValid1() {
		assertTrue(myFun.validDate("01/01/2018"));
		assertTrue(myFun.validDate("01/01/1582"));
		assertTrue(myFun.validDate("01/01/2018"));
		assertTrue(myFun.validDate("01/31/2016"));
		assertTrue(myFun.validDate("12/31/2017"));
		assertTrue(myFun.validDate("06/15/2018"));
		assertTrue(myFun.validDate("02/28/2019"));
	}

	@Test
	public void testFailedValidDateWhenTheyNotValid2() {
		assertFalse(myFun.validDate("13/32/1582"));
		assertFalse(myFun.validDate("2020/11/13")); // Invalid format
		assertFalse(myFun.validDate("01-03-2016")); // Invalid format
		assertFalse(myFun.validDate("12/31")); // Incomplete format
		assertFalse(myFun.validDate("13/11/2020")); // Invalid day
	}

}
