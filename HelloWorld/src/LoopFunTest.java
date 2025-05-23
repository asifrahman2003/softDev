
/*-
 * This unit test is a small beginning to test the 15 methods 
 * in the file LoopFun.  You are now asked to add an additional 
 * twelve @Test methods and assertions inside.
 * 
 * @authors Rick Mercer and Muhammad Asifur Rahman
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class LoopFunTest {

	// The one instance variable that is accessible to all methods
	private LoopFun loopFun = new LoopFun();

	@Test
	public void testGCDWhen() {
		assertEquals(3, loopFun.GCD(3, 0));
		assertEquals(4, loopFun.GCD(-4, -16));
		assertEquals(378, loopFun.GCD(378, 378));
		assertEquals(378, loopFun.GCD(378, 0));
		assertEquals(378, loopFun.GCD(0, 378));
		assertEquals(1, loopFun.GCD(3, 2));
		assertEquals(5, loopFun.GCD(10, 5));
		assertEquals(5, loopFun.GCD(15, 25));
		assertEquals(5, loopFun.GCD(25, 10));
		assertEquals(5, loopFun.GCD(-25, -10));
		assertEquals(5, loopFun.GCD(25, -10));
	}

	@Test
	public void testSqrt() {
		// sqrt is tricky to write but the asserts are worse with two precisions
		// to deal with. Consider this @Test a gift. You shouldn't have to
		// write any more asserts for sqrt if all of these pass.
		assertEquals(4.0, loopFun.sqrt(16.0, 1e-14));
		assertEquals(10.0, loopFun.sqrt(100, 1e-14));
		assertEquals(1.4142135, loopFun.sqrt(2, 1e-7), 6e-7);
		assertEquals(1.457, loopFun.sqrt(2.1234, 1e-4), 6e-4);
		assertEquals(3.16, loopFun.sqrt(10.0, 1e-4), 1e-2);
		assertEquals(2.00, loopFun.sqrt(4.0, 0.001), 1e-2);
		assertEquals(3.0, loopFun.sqrt(9.0, 1e-14));
		assertEquals(5.0, loopFun.sqrt(25.0, 1e-14));
		assertEquals(1.7320508, loopFun.sqrt(3.0, 1e-7), 6e-7);
		assertEquals(1.5, loopFun.sqrt(2.25, 1e-4), 6e-4);
		assertEquals(3.3166248, loopFun.sqrt(11.0, 1e-4), 1e-2);
	}

	@Test
	public void testsumInScanner() {
		Scanner stream = new Scanner("3 1 2 4");
		assertEquals(10, loopFun.sumInScanner(stream));

		Scanner stream1 = new Scanner("10 20 30 40");
		assertEquals(100, loopFun.sumInScanner(stream1));

		Scanner stream2 = new Scanner("-1 -2 -3 -4");
		assertEquals(-10, loopFun.sumInScanner(stream2));

		Scanner stream3 = new Scanner("0 0 0 0");
		assertEquals(0, loopFun.sumInScanner(stream3));

		Scanner stream4 = new Scanner("1 2 3 4 5 6 7 8 9");
		assertEquals(45, loopFun.sumInScanner(stream4));
	}

	@Test
	public void testrangeInScanner() {
		Scanner scanner = new Scanner("99");
		assertEquals(0, loopFun.rangeInScanner(scanner));

		Scanner scanner1 = new Scanner("2 5 7 8");
		assertEquals(6, loopFun.rangeInScanner(scanner1));

		Scanner scanner2 = new Scanner("2 5 -7 8");
		assertEquals(15, loopFun.rangeInScanner(scanner2));

		Scanner scanner3 = new Scanner("-10 -20 -30 -40");
		assertEquals(30, loopFun.rangeInScanner(scanner3));

		Scanner scanner4 = new Scanner("1 2 3 4 5 6 7 8 9");
		assertEquals(8, loopFun.rangeInScanner(scanner4));
	}

	@Test
	public void testhowMany() {
		Scanner scanner = new Scanner("here are five words here");
		assertEquals(2, loopFun.howMany(scanner, "here"));

		Scanner scanner1 = new Scanner("1 a b b A b b a 1");
		assertEquals(2, loopFun.howMany(scanner1, "a"));

		Scanner scanner2 = new Scanner("1 a b b A b b a 1");
		assertEquals(4, loopFun.howMany(scanner2, "b"));

		Scanner scanner3 = new Scanner("1 a b b A b b a 1");
		assertEquals(2, loopFun.howMany(scanner3, "1"));

		Scanner scanner4 = new Scanner("here are five words here");
		assertEquals(0, loopFun.howMany(scanner4, "notere"));

	}

	@Test
	public void testperfectPercentage() {
		Scanner scanner = new Scanner("80 90 100 72 65 49 90 88 90 100 90 100 100 74 93 99");
		assertEquals(4 / 16, loopFun.perfectPercentage(scanner));

		Scanner scanner1 = new Scanner("100 100 100 100");
		assertEquals(1.0, loopFun.perfectPercentage(scanner1));

		Scanner scanner2 = new Scanner("80 90 70 60");
		assertEquals(0.0, loopFun.perfectPercentage(scanner2));

		Scanner scanner3 = new Scanner("100 90 100 90");
		assertEquals(2 / 4, loopFun.perfectPercentage(scanner3));

		Scanner scanner4 = new Scanner("100 90 80 70 60 50");
		assertEquals(1 / 6, loopFun.perfectPercentage(scanner4));

	}

	@Test
	public void testfactorial() {
		assertEquals(24, loopFun.factorial(4));
		assertEquals(1, loopFun.factorial(0));
		assertEquals(1, loopFun.factorial(1));
		assertEquals(2, loopFun.factorial(2));
		assertEquals(6, loopFun.factorial(3));
		assertEquals(120, loopFun.factorial(5));
		assertEquals(720, loopFun.factorial(6));

	}

	@Test
	public void testfibonacci() {
		assertEquals(1, loopFun.fibonacci(2));
		assertEquals(8, loopFun.fibonacci(6));
		assertEquals(1, loopFun.fibonacci(1));
		assertEquals(2, loopFun.fibonacci(3));
		assertEquals(3, loopFun.fibonacci(4));
		assertEquals(5, loopFun.fibonacci(5));
		assertEquals(13, loopFun.fibonacci(7));
		assertEquals(21, loopFun.fibonacci(8));

	}

	@Test
	public void testisPrime() {
		assertTrue(loopFun.isPrime(2));
		assertTrue(loopFun.isPrime(3));
		assertFalse(loopFun.isPrime(4));
		assertTrue(loopFun.isPrime(5));
		assertFalse(loopFun.isPrime(6));
		assertTrue(loopFun.isPrime(7));
		assertFalse(loopFun.isPrime(8));
		assertFalse(loopFun.isPrime(9));
		assertTrue(loopFun.isPrime(11));
		assertFalse(loopFun.isPrime(15));
		assertTrue(loopFun.isPrime(17));
	}

	@Test
	public void testhowSwedish() {
		assertEquals(1, loopFun.howSwedish("ABBA a b b a"));
		assertEquals(2, loopFun.howSwedish("ab!abbabba!ba"));
		assertEquals(0, loopFun.howSwedish("abc"));
		assertEquals(3, loopFun.howSwedish("abbaABBAAbBa"));
		assertEquals(0, loopFun.howSwedish(""));
	}

	@Test
	public void testDoubleUp() {
		assertEquals("", loopFun.doubleUp(""));
		assertEquals("MM", loopFun.doubleUp("M"));
		assertEquals("aabbcc", loopFun.doubleUp("abc"));
		assertEquals("112233", loopFun.doubleUp("123"));
		assertEquals("!!@@##", loopFun.doubleUp("!@#"));
		assertEquals("HHHH", loopFun.doubleUp("HH"));
		assertEquals("aabbccddeeff", loopFun.doubleUp("abcdef"));
		assertEquals("112233445566", loopFun.doubleUp("123456"));
		assertEquals("!!@@##$$%%^^&&", loopFun.doubleUp("!@#$%^&"));
	}

	@Test
	public void testReverseString() {
		assertEquals("", loopFun.reverseString(""));
		assertEquals("1", loopFun.reverseString("1"));
		assertEquals("4321", loopFun.reverseString("1234"));
		assertEquals("racecar", loopFun.reverseString("racecar"));
		assertEquals("dcba", loopFun.reverseString("abcd"));
		assertEquals("gfedcba", loopFun.reverseString("abcdefg"));
		assertEquals("54321", loopFun.reverseString("12345"));
		assertEquals("dcba", loopFun.reverseString("abcd"));
		assertEquals("ihgfedcba", loopFun.reverseString("abcdefghi"));
		assertEquals("onmlkjihgfedcba", loopFun.reverseString("abcdefghijklmno"));
		assertEquals("tsrqponmlkjihgfedcba", loopFun.reverseString("abcdefghijklmnopqrst"));
	}

	@Test
	public void testAllAsLeft() {
		assertEquals("", loopFun.allAsLeft(""));
		assertEquals("A", loopFun.allAsLeft("A"));
		assertEquals("AAAAAbcdaaaefghi", loopFun.allAsLeft("AbcAdaaaefAghiAA"));
		assertEquals("AAabcde", loopFun.allAsLeft("abcAdeA"));
		assertEquals("AAbcdEa", loopFun.allAsLeft("AbcAdEa"));
		assertEquals("Aabc", loopFun.allAsLeft("abcA"));
		assertEquals("AAAbcdEa", loopFun.allAsLeft("AbcAdEaA"));
		assertEquals("Aabcdefghijklmnopqrstuvwxyz", loopFun.allAsLeft("abcdefghijklmnopqrstuvwxyzA"));
		assertEquals("AAAAAAA", loopFun.allAsLeft("AAAAAAA"));
		assertEquals("Aa", loopFun.allAsLeft("Aa"));
	}

	@Test
	public void testVowelCount() {
		assertEquals(10, loopFun.vowelCount("a e i o u A E I O U"));
		assertEquals(0, loopFun.vowelCount("y+_x1Y2x!y"));
		assertEquals(11, loopFun.vowelCount("How much wood could a woodchuck chuck"));
		assertEquals(2, loopFun.vowelCount("HELLO"));
		assertEquals(2, loopFun.vowelCount("Java"));
		assertEquals(1, loopFun.vowelCount("cat"));
		assertEquals(3, loopFun.vowelCount("hello world"));
		assertEquals(0, loopFun.vowelCount("rhythm"));
		assertEquals(5, loopFun.vowelCount("beautiful"));
		assertEquals(5, loopFun.vowelCount("queueing"));
	}

	@Test
	public void testNumberOfPairs() {
		assertEquals(0, loopFun.numberOfPairs(""));
		assertEquals(0, loopFun.numberOfPairs("abc"));
		assertEquals(3, loopFun.numberOfPairs("aabbcc"));
		assertEquals(2, loopFun.numberOfPairs("!!!"));
		assertEquals(3, loopFun.numberOfPairs("mmmm"));
		assertEquals(2, loopFun.numberOfPairs("mmOmm"));
		assertEquals(0, loopFun.numberOfPairs("mMOzZ"));
	}
}
