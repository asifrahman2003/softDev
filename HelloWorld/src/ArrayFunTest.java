
/** 
 * This class has @Test methods for testing all required methods in ArrayFun.java.
 * There are very limited, but each of the 14 Java methods have an @Test
 * started, which is more help than the previous assignment
 * 
 * @author Rick Mercer and Muhammad Asifur Rahman
 * 
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

public class ArrayFunTest {

	// If you include this instance variable, you can use myFun in all @Tests:
	private ArrayFun myFun = new ArrayFun();

	@Test
	public void testNumberOfPairs1() {
		String[] array = { "a", "b", "b", "a" };
		assertEquals(1, myFun.numberOfPairs(array));
		// Or pass a new array as the argument itself
		assertEquals(2, myFun.numberOfPairs(new String[] { "a", "a", "a" }));

		String[] array1 = {};
		assertEquals(0, myFun.numberOfPairs(array1));

		String[] array2 = { "a" };
		assertEquals(0, myFun.numberOfPairs(array2));

		String[] array3 = { "a", "b", "c" };
		assertEquals(0, myFun.numberOfPairs(array3));

		String[] array4 = { "a", "a", "b" };
		assertEquals(1, myFun.numberOfPairs(array4));

		String[] array5 = { "a", "a", "b", "b", "c", "c" };
		assertEquals(3, myFun.numberOfPairs(array5));

		String[] array6 = { "a", "a", "b", "b", "c", "c", "d", "d" };
		assertEquals(4, myFun.numberOfPairs(array6));

		String[] array7 = { "a", "A", "b", "B", "c", "C" };
		assertEquals(0, myFun.numberOfPairs(array7));
	}

	@Test
	public void testNumberOfPairs() {
		assertEquals(0, myFun.numberOfPairs(new String[] { "a", "A", "a" }));
	}

	@Test
	public void testNumberOfVowels() {
		assertEquals(3, myFun.numberOfVowels(new char[] { 'a', 'e', 'i' }));

		char[] array = { 'b', 'c', 'd', 'f', 'g' };
		assertEquals(0, myFun.numberOfVowels(array));

		char[] array1 = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x',
				'y', 'z' };
		assertEquals(0, myFun.numberOfVowels(array1));

		char[] array2 = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		assertEquals(5, myFun.numberOfVowels(array2));

		char[] array3 = { 'a', 'E', 'i', 'O', 'u', 'A', 'e', 'I', 'o', 'U' };
		assertEquals(10, myFun.numberOfVowels(array3));
	}

	@Test
	public void testSumGreaterThan() {
		double[] x = { 1, 2, 3 };
		// sum of elements in x is 6
		assertFalse(myFun.sumGreaterThan(x, 6));
		assertTrue(myFun.sumGreaterThan(x, 3));
		double[] y = {};
		assertFalse(myFun.sumGreaterThan(y, -1));

		double[] array = { -1.0, -2.0, -3.0 };
		assertFalse(myFun.sumGreaterThan(array, -3.0));

		double[] array2 = { 1.0, -2.0, 3.0 };
		assertFalse(myFun.sumGreaterThan(array2, 3.0));

		double[] array3 = { 1.0, 2.0, 3.0 };
		assertFalse(myFun.sumGreaterThan(array3, 6.0));
	}

	@Test
	public void testFrequency1() {
		Scanner scanner = new Scanner("5 0 1 2 1 5 2");
		int[] result = myFun.frequency(scanner);
		assertEquals(11, result.length);

		Scanner scanner1 = new Scanner("5 0 1 2 1 5 2 3 4 6 7 8 9 10");
		int[] result1 = myFun.frequency(scanner1);
		assertEquals(11, result1.length);
		assertEquals(1, result1[0]);
		assertEquals(2, result1[1]);
		assertEquals(2, result1[2]);
		assertEquals(1, result1[3]);
		assertEquals(1, result1[4]);
		assertEquals(2, result1[5]);
		assertEquals(1, result1[6]);
		assertEquals(1, result1[7]);
		assertEquals(1, result1[8]);
		assertEquals(1, result1[9]);
		assertEquals(1, result1[10]);
	}

	@Test
	public void testHowMany() {
		String[] two = { "5", "5" };
		assertEquals(2, myFun.howMany(two, "5"));

		String[] arr1 = { "A", "a", "A", "a" };
		assertEquals(2, myFun.howMany(arr1, "A"));

		String[] arr2 = { "And", "there", "goes", "another" };
		assertEquals(1, myFun.howMany(arr2, "another"));

		String[] arr3 = { "And", "there", "goes", "another" };
		assertEquals(0, myFun.howMany(arr3, "Not Here"));

		String[] arr4 = {};
		assertEquals(0, myFun.howMany(arr4, "empty array"));

		String[] arr5 = { "5", "5" };
		assertEquals(2, myFun.howMany(arr5, "5"));
	}

	@Test
	public void testEvensLeft() {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		myFun.evensLeft(a);
		// left side of the array at indexes 0..2 is even
		for (int i = 0; i <= 3; i++)
			assertEquals(0, a[i] % 2);
		// right side of the array at indexes 3..6 is odd
		for (int i = 4; i <= 6; i++)
			assertEquals(1, a[i] % 2);

		int[] b = { 51, 52, 53, 54, 55, 56, 57, 58 };
		myFun.evensLeft(b);
		// left side of the array at indexes 0..2 is even
		for (int i = 0; i <= 3; i++)
			assertEquals(0, b[i] % 2);
		// right side of the array at indexes 3..6 is odd
		for (int i = 4; i <= 6; i++)
			assertEquals(1, b[i] % 2);
	}

	@Test
	public void testReplace1() {
		char[] a = { 'A', 'B', 'C', 'D', 'B' };
		char[] a1 = myFun.replaced(a, 'B', 'Z');
		assertEquals('A', a1[0]);
		assertEquals('Z', a1[1]);

		char[] c = { 'n', 'n', 'n', 'D', 'n' };
		char[] c1 = myFun.replaced(c, 'n', 'T');
		assertEquals('T', c1[0]);
		assertEquals('T', c1[1]);
		assertEquals('T', c1[2]);
		assertEquals('D', c1[3]);
		assertEquals('T', c1[4]);

		char[] d = {};
		char[] d1 = myFun.replaced(d, 'n', 'T');
		assertEquals(0, d1.length);
	}

	@Test
	public void testShiftNTimes2() {
		int[] x = { 1, 2, 3, 4 };
		myFun.shiftNTimes(x, 2);
		assertEquals(3, x[0]);

		int[] y = { 1, 2, 3, 4, 5, 6, 7 };
		myFun.shiftNTimes(y, 3);
		assertEquals(4, y[0]);
		assertEquals(5, y[1]);
		assertEquals(6, y[2]);
		assertEquals(7, y[3]);
		assertEquals(1, y[4]);
		assertEquals(2, y[5]);
		assertEquals(3, y[6]);

		int[] z = { 1, 2, 3, 4, 5, 6, 7 };
		myFun.shiftNTimes(z, 0);
		assertEquals(1, z[0]);

		int[] w = { 3 };
		myFun.shiftNTimes(w, 5);
		assertEquals(3, w[0]);
	}

	@Test
	public void testFound1() {
		String[] a = { "A", "B", "C" };
		assertTrue(myFun.found("A", a));

		String[] arr2 = { "A", "B", "C" };
		assertFalse(myFun.found("a", arr2));

		String[] arr3 = { "a", "b", "c", "d" };
		assertFalse(myFun.found("x", arr3));

		String[] arr4 = {};
		assertFalse(myFun.found("x", arr4));

		String[] arr5 = { "apple", "banana", "cherry", "date" };
		assertTrue(myFun.found("banana", arr5));
	}

	@Test
	public void testRange() {
		int[] x = { -1, 1, -2, 2, -3, 4, -4, 4 };
		assertEquals(8, myFun.range(x));

		int[] arr2 = { 5, 5, 5, 5, 5, 5 };
		assertEquals(0, myFun.range(arr2));

		int[] arr3 = { -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5 };
		assertEquals(10, myFun.range(arr3));

		int[] arr4 = { 1 };
		assertEquals(0, myFun.range(arr4));

		int[] arr5 = { 1, 2, 3, 4, 5 };
		assertEquals(4, myFun.range(arr5));
	}

	@Test
	public void fizzBuzz0() {
		String[] strs = myFun.fizzBuzz(14, 21);
		assertEquals(7, strs.length);
		assertEquals("14", strs[0]);
		assertEquals("FizzBuzz", strs[1]);

		String[] strs1 = myFun.fizzBuzz(1, 1);
		assertEquals(0, strs1.length);

		String[] strs2 = myFun.fizzBuzz(3, 6);
		assertEquals(3, strs2.length);
		assertEquals("Fizz", strs2[0]);
	}

	@Test
	public void testLargestWidth3() {
		int[] a = { 1, 2, 1, 1, 3 };
		int a1 = myFun.largestWidth(a);
		assertEquals(4, a1);

		int[] arr1 = { 1, 2, 1, 1, 3 };
		int result1 = myFun.largestWidth(arr1);
		assertEquals(4, result1);

		// Test 2
		int[] arr2 = { 1, 4, 2, 1, 4, 1, 4 };
		int result2 = myFun.largestWidth(arr2);
		assertEquals(6, result2);

		// Test 3
		int[] arr3 = { 5, 5, 5, 5 };
		int result3 = myFun.largestWidth(arr3);
		assertEquals(4, result3);

		// Test 4
		int[] arr4 = { 99 };
		int result4 = myFun.largestWidth(arr4);
		assertEquals(1, result4);

		// Test 5
		int[] arr5 = {};
		int result5 = myFun.largestWidth(arr5);
		assertEquals(0, result5);

		int[] arr6 = null;
		int result6 = myFun.largestWidth(arr6);
		assertEquals(0, result6);
	}

	@Test
	public void testThrees() {
		assertFalse(myFun.threes(new int[] { 1, 2, 1, 2, 1 }));

		boolean result1 = myFun.threes(new int[] { 2, 1, 3, 5 });
		assertTrue(result1);

		boolean result2 = myFun.threes(new int[] { 2, 1, 2, 5 });
		assertFalse(result2);

		boolean result3 = myFun.threes(new int[] { 2, 4, 2, 5 });
		assertTrue(result3);

		boolean result4 = myFun.threes(new int[] { 1, 2, 1, 2, 1 });
		assertFalse(result4);

		boolean result5 = myFun.threes(new int[] { 2, 2, 2 });
		assertTrue(result5);
	}

	@Test
	public void testBalanceSum() {
		assertTrue(myFun.balanceSum(new int[] { 1, 1, 1, 2, 1 }));

		boolean result1 = myFun.balanceSum(new int[] { 6, 1, 2, 1, 4 });
		assertTrue(result1);

		boolean result2 = myFun.balanceSum(new int[] { 2, 3, 4, 1, 2 });
		assertFalse(result2);

		boolean result3 = myFun.balanceSum(new int[] { 1, 2, 3, 4, 5 });
		assertFalse(result3);

		boolean result4 = myFun.balanceSum(new int[] { 10, 10 });
		assertTrue(result4);

		boolean result5 = myFun.balanceSum(new int[] { 1, 1, 1, 2, 1 });
		assertTrue(result5);
	}
}