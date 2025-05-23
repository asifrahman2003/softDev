
/*
 * This class is the beginning of a UnitTest for the 15 methods
 * specified in functions.java.
 *   
 * Although each @Test has one assertion, you will need
 * to add more assertions to be sure your methods work. 
 * FYI: Our grading unit test has the same 15 @Test methods 
 * but also about 80 assertions (assertTrue, assertFalse, assertEquals).
 *       
 * Remember that when comparing two doubles, you must supply
 * a 3rd argument as the error factor. 1e-12 works well most of 
 * the time, except for range below where we use 0.01 to be close.
 * 
 * Programmers: Rick Mercer and Muhammad Asifur Rahman
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class JavaFunTest {

	// Construct an object to send 15 different messages to in the @Test methods
	// below
	JavaFun functions = new JavaFun();

	// Recommended: Run one @Test method at a time as you work on only
	// one method at a time.
	//
	// 1. Highlight the method name, testTriangleArea() is the first one below
	// 2. From the top menu, select: Run > Run
	//
	// You can also run all @Test methods by focusing on the file, not
	// on one @Test name before selecting Run > Run from the main menu.
	//

	@Test
	public void testTriangleArea() {
		assertEquals(12.5, functions.triangleArea(5.0, 5.0));
		assertEquals(12, functions.triangleArea(4.0, 6.0));
		assertEquals(14, functions.triangleArea(4.0, 7.0));
		assertEquals(8, functions.triangleArea(4.0, 4.0));
		assertEquals(27, functions.triangleArea(9.0, 6.0));

	}

	@Test
	public void testRound() {
		assertEquals(3.46, functions.round(3.4567, 2));
		assertEquals(4.8, functions.round(4.790, 1));
		assertEquals(8.77, functions.round(8.765, 2));
		assertEquals(10, functions.round(9.99, 0));
		assertEquals(5.41, functions.round(5.413, 2));
	}

	@Test
	public void testRange() {
		assertEquals(883.7, functions.range(30.0, 100.0));
		assertEquals(0.0, functions.range(90.0, 100.0));
		assertEquals(883.7, functions.range(60.0, 100.0));
		assertEquals(0.0, functions.range(0.0, 100.0));
		assertEquals(655.9, functions.range(20.0, 100.0));

	}

	@Test
	public void testMiddleTwo() {
		assertEquals("ab", functions.middleTwo("abc"));
		assertEquals("pp", functions.middleTwo("apple"));
		assertEquals("el", functions.middleTwo("hello"));
		assertEquals("or", functions.middleTwo("world"));
		assertEquals("ru", functions.middleTwo("construction"));
		assertEquals("ve", functions.middleTwo("diverse"));
	}

	// To Run all tests, select Run > Run As > JUnit Test (or Run > Run)
	@Test
	public void testAntimatter() {
		assertEquals("Anti-Shoes", functions.antiMatter("Shoes"));
		assertEquals("Anti-Comunist", functions.antiMatter("Comunist"));
		assertEquals("Anti-Political", functions.antiMatter("Political"));
		assertEquals("Anti-Social", functions.antiMatter("Social"));
		assertEquals("Anti-Classic", functions.antiMatter("Classic"));
	}

	@Test
	// To Run all tests, select Run > Run
	public void testAbba() {
		assertEquals("abba", functions.abba("a", "b"));
		assertEquals("acca", functions.abba("a", "c"));
		assertEquals("moom", functions.abba("m", "o"));
		assertEquals("noon", functions.abba("n", "o"));
		assertEquals("lkkl", functions.abba("l", "k"));
	}

	@Test
	public void testNearTen() {
		assertTrue(functions.nearTen(8));
		assertTrue(functions.nearTen(12));
		assertTrue(functions.nearTen(29));
		assertFalse(functions.nearTen(15));
		assertFalse(functions.nearTen(23));
	}

	@Test
	public void testLikeSix() {
		assertTrue(functions.likeSix(6, 4));
		assertTrue(functions.likeSix(10, 4));
		assertTrue(functions.likeSix(12, 6));
		assertFalse(functions.likeSix(5, 8));
		assertFalse(functions.likeSix(9, 4));
	}

	@Test
	public void testEndUp() {
		assertEquals("TRE", functions.endCAP("tre"));
		assertEquals("pretEND", functions.endCAP("pretend"));
		assertEquals("heLLO", functions.endCAP("hello"));
		assertEquals("macbOOK", functions.endCAP("macbook"));
		assertEquals("calculaTOR", functions.endCAP("calculator"));
	}

	@Test
	public void testMakeTags() {
		assertEquals("<i>Yay</i>", functions.makeTags("i", "Yay"));
		assertEquals("<address>here</address>", functions.makeTags("address", "here"));
		assertEquals("<body>Heart</body>", functions.makeTags("body", "Heart"));
		assertEquals("<here>Email</here>", functions.makeTags("here", "Email"));
		assertEquals("<type>Password</type>", functions.makeTags("type", "Password"));
	}

	@Test
	public void testSplitstring() {
		assertEquals("Wil dcat", functions.splitString("Wildcat"));
		assertEquals("Wil dca", functions.splitString("Wildca"));
		assertEquals("Gh ost", functions.splitString("Ghost"));
		assertEquals("Exting uisher", functions.splitString("Extinguisher"));
		assertEquals("Sate lite", functions.splitString("Satelite"));
	}

	@Test
	public void testFailedInlat() {
		assertEquals("gares", functions.inLat("gears"));
		assertEquals("cloor", functions.inLat("color"));
		assertEquals("egear", functions.inLat("eager"));
		assertEquals("galos", functions.inLat("goals"));
		assertEquals("ioncs", functions.inLat("icons"));
	}

	@Test
	public void testIntrouble() {
		assertTrue(functions.inTrouble(true, true));
		assertTrue(functions.inTrouble(false, false));
		assertFalse(functions.inTrouble(false, true));
		assertFalse(functions.inTrouble(true, false));
	}

	@Test
	public void alone() {
		assertTrue(functions.alone(13, 99));
		assertTrue(functions.alone(78, 17));
		assertTrue(functions.alone(55, 18));
		assertFalse(functions.alone(21, 39));
		assertFalse(functions.alone(17, 19));
	}

	@Test
	public void testIsLeapYear() {
		assertTrue(functions.isLeapYear(1600));
		assertTrue(functions.isLeapYear(1904));
		assertTrue(functions.isLeapYear(2016));
		assertFalse(functions.isLeapYear(1902));
		assertFalse(functions.isLeapYear(1700));
	}
}