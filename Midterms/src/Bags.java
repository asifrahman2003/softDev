import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Bags {
	public int count(String first, String second) {
		int i = first.indexOf(second);

		if (i == -1) {
			return 0;
		}

		String newString = first.substring(i + second.length());
		return 1 + count(newString, second);
	}

	@Test
	public void testCount() {
		assertEquals(2, count("BagStringBag", "Bag"));
		assertEquals(0, count("BagStringBag", "bag"));
		assertEquals(3, count("ababab", "ab"));
		assertEquals(1, count("xxx", "xx"));
	}
}
