import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class MidTerm1Test {

	private MidTerm1 mid = new MidTerm1();

	@Test
	public void testEquallyDifferent() {
		assertTrue(mid.equallyDifferent(2, 4, 6));
		assertTrue(mid.equallyDifferent(4, 6, 2));
		assertFalse(mid.equallyDifferent(4, 6, 3));
		assertTrue(mid.equallyDifferent(2, 4, 6));
		assertTrue(mid.equallyDifferent(4, 6, 2));
		assertTrue(mid.equallyDifferent(6, 4, 2));
		assertTrue(mid.equallyDifferent(3, 3, 3));
		assertTrue(mid.equallyDifferent(-1, 0, 1));
		assertFalse(mid.equallyDifferent(4, 6, 3));
		assertFalse(mid.equallyDifferent(0, 5, 9));
		assertFalse(mid.equallyDifferent(-5, 0, 4));
		assertFalse(mid.equallyDifferent(2, 3, 3));
	}

	@Test
	public void testEesPerWord() {
		assertEquals(5, mid.totalEes(new Scanner("Everyone is awesome")));
		assertEquals(0, mid.totalEes(new Scanner("No way, 0")));
		assertEquals(8, mid.totalEes(new Scanner("eEeE Everywhere found")));
		assertEquals(0, mid.totalEes(new Scanner("")));
	}

	@Test
	public void testruns() {
		char[] e = { '1', '2', '3', '4' };
		assertEquals(0, mid.runs(e));

		char[] a = { '1', '2', '2', '3', '4', '4' };
		assertEquals(2, mid.runs(a));

		char[] b = { 'a', 'a', 'x', 'b', 'b', 'y', 'c', 'c' };
		assertEquals(3, mid.runs(b));

		char[] d = { 'z', 'z', 'z', 'z', 'z' };
		assertEquals(1, mid.runs(d));

		char[] c = { '0', '0', '0', '2', '2', '1', '1', '1', '2', '1', '1', '2', '2' };
		assertEquals(5, mid.runs(c));
	}

	@Test
	public void testOutsideIn() {
		assertEquals("", mid.outside_in(""));
		assertEquals("ab", mid.outside_in("abXYZba"));
		assertEquals("", mid.outside_in("abcdae"));
		assertEquals("a", mid.outside_in("abca"));
		assertEquals("", mid.outside_in("abcdA")); // Case sensitive
		assertEquals("abBba", mid.outside_in("abBba"));
		assertEquals("racecar", mid.outside_in("racecar"));

	}

}
