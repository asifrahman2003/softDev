
/**
 * A JUnit test for class StringSet.
 * 
 * @author Muhammad Asifur Rahman
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringSetTest {

	@Test
	public void testadd() {
		StringSet set = new StringSet(5);
		assertTrue(set.add("Kim"));
		assertTrue(set.add("Chris"));
		assertFalse(set.add("Kim")); // Trying to add "Kim" again, should return false
		assertTrue(set.add("Devon"));
		assertTrue(set.add("Ali"));
		assertFalse(set.add("Ali")); // Trying to add "Ali" again, should return false
		assertTrue(set.add("Eva"));
		assertFalse(set.add("Eva")); // Adding "Eva" again, should return false
		assertTrue(set.add("Mike"));
		assertTrue(set.add("Jack"));
		assertFalse(set.add("Jack")); // Trying to add "Jack" again, should return false
		assertTrue(set.add("Alex"));
		assertTrue(set.add("John"));
		assertTrue(set.add("Emily"));
		assertTrue(set.add("Sam"));
		assertTrue(set.add("Liam"));
		assertTrue(set.add("Emma"));
		assertTrue(set.add("Noah"));
	}

	@Test
	public void testcontains() {
		StringSet set = new StringSet(5);
		set.add("Kim");
		set.add("Chris");
		assertTrue(set.contains("Kim"));
		assertTrue(set.contains("Chris"));
		assertFalse(set.contains("Devon")); // "Devon" was not added, should return false
	}

	@Test
	public void testsize() {
		StringSet set = new StringSet(5);
		assertEquals(0, set.size());
		set.add("Kim");
		assertEquals(1, set.size());
		set.add("Chris");
		assertEquals(2, set.size());
		set.remove("Kim");
		assertEquals(1, set.size());
	}

	@Test
	public void testisEmpty() {
		StringSet set = new StringSet(5);
		assertTrue(set.isEmpty());
		set.add("Kim");
		assertFalse(set.isEmpty());
		set.remove("Kim");
		assertTrue(set.isEmpty());
	}

	@Test
	public void testtoStringTest() {
		StringSet set = new StringSet(5);
		assertEquals("{}", set.toString());
		set.add("Kim");
		assertEquals("{Kim}", set.toString());
		set.add("Chris");
		assertEquals("{Kim, Chris}", set.toString());
		set.add("Devon");
		assertEquals("{Kim, Chris, Devon}", set.toString());
		set.add("Ali");
		assertEquals("{Kim, Chris, Devon, Ali}", set.toString());
	}

	@Test
	public void testremove() {
		StringSet set = new StringSet(5);
		assertFalse(set.remove("Kim")); // Removing from an empty set, should return false

		set.add("Kim");
		assertFalse(set.remove("Chris")); // Removing a non-existing element, should return false
		assertTrue(set.remove("Kim"));

		set.add("Chris");
		set.add("Devon");
		assertTrue(set.remove("Devon"));
		assertFalse(set.remove("Devon")); // Trying to remove "Devon" again, should return false

		set.add("Ali");
		assertTrue(set.remove("Ali"));
		assertFalse(set.remove("Ali")); // Trying to remove "Ali" again, should return false

		set.add("Eva");
		set.add("Mike");
		set.add("Jack");
		set.add("Alex");
		set.add("John");
		set.add("Emily");
		set.add("Sam");
		set.add("Liam");
		set.add("Emma");
		set.add("Noah");

		assertTrue(set.remove("John"));
		assertTrue(set.remove("Sam"));
		assertTrue(set.remove("Liam"));
		assertTrue(set.remove("Noah"));
		assertFalse(set.remove("Noah")); // Trying to remove "Noah" again, should return false

		assertFalse(set.remove("David")); // Removing a non-existing element, should return false
	}

	@Test
	public void testintersection() {
		StringSet set1 = new StringSet(5);
		set1.add("Kim");
		set1.add("Chris");
		set1.add("Devon");
		StringSet set2 = new StringSet(5);
		set2.add("Chris");
		set2.add("Ali");
		StringSet result = set1.intersection(set2);
		assertEquals("{Chris}", result.toString());
	}

	@Test
	public void testunion() {
		StringSet set1 = new StringSet(5);
		set1.add("Kim");
		set1.add("Chris");
		set1.add("Devon");
		StringSet set2 = new StringSet(5);
		set2.add("Chris");
		set2.add("Ali");
		StringSet result = set1.union(set2);
		assertEquals("{Kim, Chris, Devon, Ali}", result.toString());
	}

}
