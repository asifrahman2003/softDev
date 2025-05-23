import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class midterm2 {
	public int foo(int[] x, int[] y) {
		return fooAssistant(x, y, 0, 0, 0);
	}

	private int fooAssistant(int[] x, int[] y, int index, int counting, int difference) {
		if (index >= x.length) {
			return counting;
		}

		if (Math.abs(x[index] - y[index]) == 1 || Math.abs(x[index] - y[index]) == 2) {
			counting++;
		}

		return fooAssistant(x, y, index + 1, counting, difference);
	}

	@Test
	public void testFoo() {
		assertEquals(2, foo(new int[] { 1, 1, 3 }, new int[] { 2, 3, 10 }));

		assertEquals(3, foo(new int[] { 1, 2, 3 }, new int[] { 3, 4, 5 }));

		assertEquals(0, foo(new int[] { 1, 2, 5, 77 }, new int[] { 1, 5, 2, 77 }));

		assertEquals(2, foo(new int[] { -1, -2, -3 }, new int[] { -1, -3, -5 }));
	}
}
