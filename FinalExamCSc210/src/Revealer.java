import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Revealer {

	public static String revealPhrase(String input) {
		if (input == null || input.length() == 0) {
			return "";
		}
		StringBuilder revealer = new StringBuilder();
		int index = 0;
		while (index < input.length()) {
			revealer.append(input.charAt(index));
			index += 2;
		}
		return revealer.toString();
	}

	@Test
	public void testRevealPhrase() {

		assertEquals("", revealPhrase(""));

		assertEquals("Y", revealPhrase("Y"));

		assertEquals("Y", revealPhrase("YN"));

		assertEquals("YO", revealPhrase("YNO"));

		assertEquals("YO", revealPhrase("YNOX"));

		assertEquals("YOU", revealPhrase("YNOXU"));

		assertEquals("YOUDIDIT", revealPhrase("YNOXUIDKIEDCIHTE"));

	}
}
