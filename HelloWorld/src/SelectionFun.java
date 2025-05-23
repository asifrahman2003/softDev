
/**
 * A class with ten methods related by the fact that CSC 210 students are
 * learning election control structures, the algorithmic patterns Guarded
 * Selection and Alternative Selection, and the if and if..else statements
 * written is virtually all languages because these algorithmic patterns occur
 * so frequently while developing software
 * 
 * @author Rick Mercer and Muhammad Asifur Rahman
 * @version 1.0
 */
public class SelectionFun {

	/*-
	Given three String arguments, return the String that alphabetically 
	precedes or is equal to the other two string arguments. You will need
	to use String's compareTo method 
	
	  firstOf3Strings("a", "b", "c") returns "a" 
	  firstOf3Strings("X", "b", "c") returns "X"
	  firstOf3Strings("123", "1232", "123 0") returns "123"
	 */
	public String firstOf3Strings(String a, String b, String c) {
		return a;
	}

	/*-
	 * Given a string str, if the string starts with "f" return "Fizz". If the
	 * string ends with "b" return "Buzz". If both the "f" and "b" conditions are
	 * true, return "FizzBuzz". In all other cases, return the string unchanged.
	 * 
	 * 
	 * fizzString("fig") returns "Fizz" fizzString("dib") returns "Buzz"
	 * fizzString("fib") returns "FizzBuzz" fizzString("abc") returns "abc"
	 * 
	 * Precondition: str.length() >= 1
	 */
	public String fizzBuzz(String str) {
		if (str.startsWith("f") && str.endsWith("b")) {
			return "FizzBuzz";
		} else if (str.startsWith("f")) {
			return "Fizz";
		} else if (str.endsWith("b")) {
			return "Buzz";
		} else {
			return str;
		}
	}

	/*-
	 Complete the free function salary that returns a salesperson’s salary
	 for the month according to the following policy:
	
	 Sales    But
	 Over     Not Over    Monthly Salary
	 =======  ========    ==============
	 0        10,000      Base salary
	 10,000   20,000      Base salary plus 5% of sales over 10,000
	 20,000   30,000      Base salary plus 500.00 plus 8% of sales over 20,000
	 30,000               Base salary plus 1300.00 plus 12% of sales over 30,000
	
	 The base salary is $1,500.00, which means salary returns a value that
	 is never less than 1500.00. When sales are over $10,000, commission is
	 added to the base salary. For example, when sales equals 10001, the
	 monthly salary is $1,500.00 + 5% of $1.00 for a total of $1,500.05,
	 and when sales is 20001, the monthly salary is $1,500.00 + $500.00 + 8%
	 of $1.00 for a total of $2,000.08.
	*/
	public double salary(double sales) {
		double baseSalary = 1500.00;
		if (sales <= 10000.00) {
			return baseSalary;
		} else if (sales > 10000.00 && sales <= 20000.00) {
			return ((sales - 10000.00) * .05) + baseSalary;
		} else if (sales > 20000.00 && sales <= 30000.00) {
			return (((sales - 20000.00) * .08) + baseSalary + 500.00);
		} else {
			return (baseSalary + 1300.00 + ((sales - 30000) * .12));
		}
	}

	/*-
	 Complete the free function romanNumeral that returns the numeric
	 equivalent of an upper- or lower-case Roman numeral, which is actually
	 a char. Roman numerals and their decimal equivalents are
	
	 'I' (or 'i') = 1
	 'V' (or 'v') = 5
	 'X' (or 'x') = 10
	 'L' (or 'l') = 50
	 'C' (or 'c') = 100
	 'D' or ('d') = 500
	 'M' (or 'm') = 1,000
	 
	 You are not being asked to convert "LXXXII" to 82.
	 
	 To make a lower-case letter an upper-case, subtract 32 assertTrue('a' - 32 == 'A')
	 
	 Precondition: ch is one the 7 valid Roman numerals in either lower- or upper-case
	*/
	public int romanNumeral(char ch) {
		ch = Character.toUpperCase(ch);
		if (ch == 'I') {
			return 1;
		} else if (ch == 'V') {
			return 5;
		} else if (ch == 'X') {
			return 10;
		} else if (ch == 'L') {
			return 50;
		} else if (ch == 'C') {
			return 100;
		} else if (ch == 'D') {
			return 500;
		} else if (ch == 'M') {
			return 1000;
		} else {
			return 0;
		}
	}

	/////////////////////////////////////////
	// And now for some Calendar functions //
	/////////////////////////////////////////

	/*-
	 Given an integer for the month (1 is January and 12 is December) and a
	 Boolean argument that when true represents the northern hemisphere, return
	 the current season in that hemisphere using the table below.
	
	 month           inNorthernHemisphere   !inNorthernHemisphere
	 ============    ====================   =====================
	 12, 1, or 2     "Winter"               "Summer"
	 3, 4, or 5      "Spring"               "Fall"
	 6, 7, or 8      "Summer"               "Winter"
	 9, 10, or 11     "Fall"                "Spring"
	
	 Precondition: month is always in the range of 1..12 inclusive
	*/
	public String season(int month, boolean inNorthernHemisphere) {
		if ((month == 12 || month == 1 || month == 2) && inNorthernHemisphere) {
			return "Winter";
		} else if ((month >= 3 && month <= 5) && inNorthernHemisphere) {
			return "Spring";
		} else if ((month >= 6 && month <= 8) && inNorthernHemisphere) {
			return "Summer";
		} else if ((month >= 9 && month <= 11) && inNorthernHemisphere) {
			return "Fall";
		} else if ((month == 12 || month == 1 || month == 2) && !inNorthernHemisphere) {
			return "Summer";
		} else if ((month >= 3 && month <= 5) && !inNorthernHemisphere) {
			return "Fall";
		} else if ((month >= 6 && month <= 8) && !inNorthernHemisphere) {
			return "Winter";
		} else if ((month >= 9 && month <= 11) && !inNorthernHemisphere) {
			return "Spring";
		} else {
			return "Invalid input";
		}
	}

	/*-
	In the US, Thanksgiving falls on the 4th Thursday of each November. Complete
	method thanksDate that determines the day of the month that Thanksgiving
	falls on no matter the day on which November begins. November can begin on
	any day where 1 represents Monday, through 7 that represents Sunday. A valid
	call would be thanksDate(2) to indicate the first day of November is Tuesday.
	thanksDate should then return the day of the month upon which Thanksgiving
	falls, which is 24 (as shown in the calendar below). Arguments can only be 1
	(for Monday) through 7 (for Sunday). 
	
	  thanksDate(2) returns 24 1-Nov is Tue
	  thanksDate(5) returns 28 1-Nov is Fri 
	  thanksDate(7) returns 26 1-Nov is Sun
	  thanksDate(0) returns -1    
	*/
	public int thanksDate(int d) {
		if (d < 1 || d > 7) {
			return -1;
		}
		int firstThursday = 0;
		if (d <= 4) {
			firstThursday = 5 - d;
		} else {
			firstThursday = 12 - d;
		}
		return firstThursday + 21;
	}

	/*-
	dayOfWeek returns the string "Monday" if the int argument passed to the
	parameter dayNumber is 1, return "Tuesday" if the argument 2, and so on up
	through returning "Sunday" if the argument is 7. Return "Unknown" if the
	argument is not in the range of 1 through 7. 
	
	dayOfWeek(0) returns "Unknown"
	dayOfWeek(3) returns "Wednesday"
	dayOfWeek(4) returns "Thursday"
	dayOfWeek(6) returns "Saturday"
	dayOfWeek(8) returns "Unknown"
	
	*/
	public String dayOfWeek(int dayNumber) {
		if (dayNumber == 1) {
			return "Monday";
		} else if (dayNumber == 2) {
			return "Tuesday";
		} else if (dayNumber == 3) {
			return "Wednesday";
		} else if (dayNumber == 4) {
			return "Thursday";
		} else if (dayNumber == 5) {
			return "Friday";
		} else if (dayNumber == 6) {
			return "Saturday";
		} else if (dayNumber == 7) {
			return "Sunday";
		} else {
			return "Unknown";
		}
	}

	/*-
	 Write free function validDate to return true if the string argument is
	 a valid calendar date. The arguments always take the form of month, day,
	 and year as positive integers separated by / as in "mm/dd/yyyy".
	 If the String argument does not express a proper date, return false.
	 You will need the static method Integer.parseInt(string possibleInt) that
	 returns the integer value of the string argument with the precondition
	 that the string argument is a valid integer.
	 
	 Integer.parseInt("08") returns 8
	 Integer.parseInt("2021") returns 2021
	
	 validDate("01/31/2016") returns true
	 validDate("12/31/2017") returns true
	 validDate("06/15/2018") returns true
	 validDate("02/28/2019") returns true
	 validDate("02/29/2019") returns false
	 validDate("2019/06/06") returns false
	 
	 Precondition: date is always in the format "mm/dd/yyyy" where m,d,y are digits
	*/
	public boolean validDate(String date) {
		String[] dateParts = date.split("/");
		if (dateParts.length != 3) {
			return false;
		}
		int month = Integer.parseInt(dateParts[0]);
		int day = Integer.parseInt(dateParts[1]);
		int year = Integer.parseInt(dateParts[2]);
		if (month < 1 || month > 12 || day < 1 || day > 31 || year < 0) {
			return false;
		}
		return true;
	}

	/*-
	Complete method daysInMonth to return the number of days in a month for the
	given year. There are 30 days in the months September, April, June, and
	November, or months 9, 4, 6, and 11. February has 28 days unless it is a leap
	year when it has 29. All other months 1, 3, 5, 7, 8, 10, and 12 (December)
	have 31 days. Assume the year is always >= 1582. You may use your own
	existing method isLeapYear. 
	
	daysInMonth(1, 2020) returns 31 
	daysInMonth(2, 2019) returns 28 
	daysInMonth(2, 2016) returns 289
	
	Pre4condition: month is in the range of 1..12.  0 and 13 are not allowed. Don't check. 
	*/
	public int daysInMonth(int month, int year) {
		if (month == 2) {
			if ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) {
				return 29;
			} else {
				return 28;
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		} else {
			return 31;
		}
	}

	/*-
	 Complete method dayNumber to return how many days a valid date is into the
	 year. If the date is invalid, return -1
	
	 dayNumber("13/11/2020") returns -1
	 dayNumber("01/03/2016")returns 3
	 dayNumber("12/31/2017")returns 365
	 dayNumber("12/31/2020") returns 366
	 dayNumber("06/31/2020") returns -1
	 
	 Precondition: date is always in the format "mm/dd/yyyy" where m,d,y are digits
	*/
	public int dayNumber(String date) {
		if (!validDate(date)) {
			return -1;
		}
		String[] dateParts = date.split("/");
		int month = Integer.parseInt(dateParts[0]);
		int day = Integer.parseInt(dateParts[1]);
		int year = Integer.parseInt(dateParts[2]);

		int totalDays = 0;
		int currentMonth = 1;

		while (currentMonth < month) {
			totalDays += daysInMonth(currentMonth, year);
			currentMonth++;
		}

		totalDays += day;

		return totalDays;
	}
}