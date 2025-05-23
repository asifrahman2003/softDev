
/**
 *
 * This class has 15 method stubs related by the fact that CSC 210 students are
 * learning the algorithmic patterns Determinate Loop and Indeterminate Loop.
 * 
 * The methods will specifically use Java's for and while loop statements 
 * written in virtually all languages because these algorithmic patterns 
 * occur so frequently while developing software.
 * 
 * The first set of methods (1..7) are indeterminate; Java's while loop 
 * is recommended. In two methods where the algorithm is not obvious,
 * an algorithm is provided: GCD(int, int) and sqrt(double, double). These
 * two methods are followed by methods requiring java.util.Scanner, a new thing.
 * 
 * The last group can use while or for loops (8..15) but since they are
 * determinate loops. Java's for loop is recommended.
 *
 * @authors Rick Mercer and Muhammad Asifur Rahman
 */

import java.util.Scanner;

public class LoopFun {

	// In mathematics, the greatest common divisor (GCD) of two or more
	// integers, which are not all zero, is the largest positive integer
	// that divides each of the integers. For example, GCD(2, 12) is 2.
	//
	// Euclid's solution to finding the GCD is refuted to be the first
	// algorithm known to mankind. It is definitely old.
	//
	// GCD(a, b) can be computed as follows:
	//
	// while(b != 0):
	// .. other = a
	// .. a = b
	// .. b = other % b
	// a is the GCD
	//
	// GCD(378, 378) returns 378
	// GCD(378, 0) returns 378
	// GCD(0, 378) returns 378
	// GCD(3, 2) returns 1
	// GCD(10, 5) returns 5
	// GCD(15, 25) returns 5
	// GCD(25, 10) returns 5
	// GCD(-25, 10) returns 5
	// GCD(-25, -10) returns 5
	// GCD(25, -10) returns 5
	//
	// Either argument may be < 0
	//
	// Precondition: a and or b can be 0, but not both. GCD(0, 0) is undefined.
	// We will not have an assert for GCD(0,0).
	//
	public int GCD(int a, int b) {
		while (b != 0) {
			int other = a;
			a = b;
			b = other % b;
		}
		return Math.abs(a);

	}

	// The square root of a number >= 0 can be found by making successful
	// guesses until it is "close enough". Starting with a guess, make each
	// guess like this until the sqrt(x) is within the precision specified.
	//
	// guess = x
	// n = 0
	// guess[n+1] = (guess[n] + x / guess[n] ) / 2.0
	// guess[n+2] = (guess[n+1] + x / guess[n+1] ) / 2.0
	//
	// If x = 16.0
	// guess[1] = (16.0 + 16.0 / 16.0) / 2.0 == 8.5
	// guess[2] = (8.5 + 16.0 / 8.5) / 2.0 == 5.1911764706
	// guess[3] = (5.1911764706 + 16.0 / 5.1911764706) / 2.0 == 4.1366647225
	// guess[3] = (4.1366647225 + 16.0 / 4.1366647225) / 2.0 == 4.002257524797
	//
	// if precision == 0.001, return 4.002257524797 and this assert should pass
	// assertEquals(4.00, loopFun.sqrt(16.0, 0.001), 1e-2);
	//
	// Precondition x >= 0.0 and precision <= 1e-12
	//
	public double sqrt(double x, double precision) {
		double guess = x;
		while (Math.abs(guess * guess - x) > precision) {
			guess = (guess + x / guess) / 2.0;
		}
		return guess;
	}

	// Given a Scanner constructed with a String of valid white space separated
	// integers, return the sum of all integers.
	//
	// Scanner scanner = new Scanner("2 5 -4 8");
	// sumInScanner(scanner) should return 11
	//
	// Precondition: scanner has a string argument that has one or
	// more white-space separated integers, all of which are valid.
	//
	public int sumInScanner(Scanner scanner) {
		int sum = 0;
		while (scanner.hasNextInt()) {
			sum += scanner.nextInt();
		}
		return sum;
	}

	// Given a Scanner constructed with a String containing valid
	// white space separated integers, return the range. Range is
	// the maximum integer – minimum integer.
	//
	// Scanner scanner = new Scanner("2 5 7 8");
	// rangeInScanner(scanner) returns 6, which is 8 - 2
	//
	// Scanner scanner = new Scanner("2 5 -7 8");
	// rangeInScanner(scanner) returns 15, which is 8 - - 7 or 15
	//
	// Scanner scanner = new Scanner("99");
	// rangeInScanner(scanner) returns 0, which is 99 the max - 99 which is also the
	// min or 0
	//
	// Precondition: scanner has a string argument that has one or
	// more white-space separated integers, all of which are valid.
	//
	// Precondition 2: There is at least one integer in scanner.
	//
	public int rangeInScanner(Scanner scanner) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		while (scanner.hasNextInt()) {
			int number = scanner.nextInt();
			max = Math.min(min, number);
			min = Math.max(max, number);
		}
		return max - min;
	}

	// Given a Scanner constructed with a String containing white
	// space separated words, return the number of "words" found
	// in the input stream that .equals the 2nd parameter search.
	//
	// Scanner scanner = new Scanner("here are five words here");
	// howMany(scanner, "here") returns 2
	// howMany(scanner, "notere") returns 0
	//
	// scanner = new Scanner("1 a b b A b b a 1");
	// howMany(scanner, "a") returns 2 case sensitive
	// howMany(scanner, "b") returns 4
	// howMany(scanner, "1") returns 2
	//
	public int howMany(Scanner scanner, String search) {
		int count = 0;
		while (scanner.hasNext()) {
			if (scanner.next().equals(search)) {
				count++;
			}
		}
		return count;
	}

	// Given a Scanner containing an unknown number of quiz scores,
	// return the percentage of 100s in the Scanner. If the Scanner
	// has these quiz scores where there are 4 100s out of 16 total,
	//
	// new Scanner ("80 90 100 72 65 49 90 88 90 100 90 100 100 74 93 99")
	//
	// perfectPercentage must return 4 / 16 or 0.25 meaning 25%.
	//
	// Remember: 4 / 16 == 0 so you need to multiply a variable
	// by 1.0 to get a double.
	//
	// Precondition: scanner has a string argument that has one or
	// more white-space separated integers, all of which are valid integers.
	//
	public double perfectPercentage(Scanner scanner) {
		int count = 0;
		int solidHundred = 0;
		while (scanner.hasNextInt()) {
			if (scanner.nextInt() == 100) {
				solidHundred++;
			}
			count++;
		}
		double percentage = solidHundred / count;
		return percentage;
	}

	/////////////////////////////////////
	// while loops above, for loops below
	/////////////////////////////////////

	// Given an integer argument return n factorial, which is written as n!.
	// 5! = 5*4*3*2*1 or in general, n! = n*(n-1)*(n-2) …*2*1. Use a for loop.
	//
	// factorial(4) returns 24, which is 4 * 3 * 2 * 1
	//
	// Precondition: n >= 0
	public int factorial(int n) {
		int result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	// In the movie "The Da Vinci Code" with Tom Hanks, this password
	// was used to unlock a much sought after artifact: 1 2 3 5 8 13 21.
	// These are the 2nd through 8th Fibonacci numbers. Fibonacci numbers
	// have so much interest, there exists a Fibonacci Quarterly
	//
	// http://www.fq.math.ca/
	//
	// Implement method fibonacci that returns the nth Fibonacci number.
	// Fibonnaci numbers can be computed as the sum of the preceeding two.
	// You will find it useful to keep track the two previous Fibonacci
	// numbers. This is harder than it looks.
	//
	// fibonacci(1) returns 1
	// fibonacci(2) returns 1
	// fibonacci(3) returns 2
	// fibonacci(4) returns 3
	// fibonacci(5) returns 5
	// fibonacci(6) returns 8
	//
	// Precondition: n >= 1
	//
	public int fibonacci(int n) {
		if (n <= 2) {
			return 1;
		}
		int a = 1, b = 1;
		for (int i = 3; i <= n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

	// One evening, while listening intently at the Very Large Array (VLA)
	// radio astronomy observatory 50 miles west of Socorro New Mexico, Ellie
	// hears a powerful signal: a prime number pattern emanating from the
	// star Vega, confirmed by others the world over, undeniable and strong
	// in its pulsing power. What Ellie recognized was the repeating series
	// of the first 26 prime numbers. This is someone near Vega trying to
	// contact anyone on earth who is listening:
	//
	// 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
	//
	// A prime number is a natural number greater than 1 that has no positive
	// divisors other than 1 and itself. Complete method isPrime that returns
	// true if the argument is a prime number. Hint: Consider writing a loop
	// that divides the argument num by every integer from 2 to num-1, returning
	// false if num was found to be evenly divisible by any one of those.
	//
	// Precondition: num >= 2
	//
	public boolean isPrime(int num) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	// ABBA is a band, they have many songs including Dancing Queen, and
	// Fernando. ABBA is actually a Swedish band, so if we wanted to find
	// out howSwedish a String is, we could simply find out how many times
	// the String contains the substring "abba". We want to look for this
	// substring in a case insensitive manner. So "abba" counts, and so
	// does "aBbA", and ABBA. We also want to check for overlapping abba's
	// such as in the String "abbAbba" that contains "abba" twice.
	//
	// howSwedish("ABBA a b b a") returns 1
	// howSwedish("ab!abbabba!ba") returns 2
	//
	public int howSwedish(String str) {
		int count = 0;
		String lowerCaseStr = str.toLowerCase();
		for (int i = 0; i < lowerCaseStr.length() - 3; i++) {
			if (lowerCaseStr.substring(i, i + 4).equals("abba")) {
				count++;
			}
		}
		return count;
	}

	// Given a string, return a new string that has every character duplicated
	// next to its original position.
	//
	// doubleUp("") return ""
	// doubleUp("M") return "MM"
	// doubleUp("abc") return "aabbcc"
	//
	public String doubleUp(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			result += str.charAt(i);
			result += str.charAt(i);
		}
		return result;
	}

	// Given a String, return a reference to a new String that has arg's
	// characters in reverse order.
	//
	// reverseString("") returns ""
	// reverseString("1") returns "1"
	// reverseString("1234") returns "4321"
	// reverseString("racecar") returns "racecar"
	//
	public String reverseString(String str) {
		String result = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i);
		}
		return result;
	}

	// Given a String, return the same characters in the string in the same
	// order except all upper case 'A's are to the left.
	//
	// allAsLeft("") returns ""
	// allAsLeft("A") returns "A"
	// allAsLeft("AbcAdaaaefAghiAA") returns "AAAAAbcdaaaefghi"
	//
	public String allAsLeft(String str) {
		String result = "";
		String nonAs = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'A') {
				result += str.charAt(i);
			} else {
				nonAs += str.charAt(i);
			}
		}
		return result + nonAs;
	}

	// "How much wood could a woodchuck chuck" contains 11 vowels. How do we
	// know? Five of the 26 English alphabet letters are vowels: a, e, i, o,
	// and u. By looking at each letter in the woodchuck string, we find
	// 11 vowels. Complete method vowelCount that returns the number of vowels
	// in the given string argument. This is case insensitive. Upper and lower
	// case vowels count. We will not consider 'y' or 'Y" to be a vowel.
	//
	// vowelCount("a e i o u A E I O U") returns 10
	// vowelCount("y+_x1Y2x!y") returns 0
	//
	public int vowelCount(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
					|| ch == 'O' || ch == 'U') {
				count++;
			}
		}
		return count;
	}

	// Return the number of times two consecutive characters occur in str.
	// numberOfPairs ("") returns 0
	// numberOfPairs ("abc") returns 0
	// numberOfPairs ("aabbcc") returns 3
	// numberOfPairs ("!!!") returns 2
	// numberOfPairs ("mmmm") returns 3
	// numberOfPairs ("mmOmm") returns 2
	// numberOfPairs ("mMOzZ") returns 0 // This is case sensitive
	//
	public int numberOfPairs(String str) {
		int count = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				count++;
			}
		}
		return count;
	}

}