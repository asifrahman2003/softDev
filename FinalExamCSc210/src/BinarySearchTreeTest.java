import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

	@Test

	public void testAddAndToString() {

		BinarySearchTree<String> set = new BinarySearchTree<String>();

		assertEquals(null, set.get(0)); // empty BST

		set.insert("M");

		set.insert("D");

		set.insert("T");

		set.insert("R");

		assertEquals(null, set.get(4)); // 4 >= n so return null

		assertEquals(null, set.get(-1));

		assertEquals("D", set.get(0));

		assertEquals("M", set.get(1));

		assertEquals("R", set.get(2));

		assertEquals("T", set.get(3));

		set.insert("A");

		assertEquals("A", set.get(0));

		assertEquals("T", set.get(4));
	}
}
