package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** 
 * A JUnit test for ArrayPriorityList.
 * 
 *@author Rick Mercer and Muhammad Asifur Rahman
*/

import model.ArrayPriorityList;

public class ArrayPriorityListTest {

	@Test
	public void testGenericity() {
		ArrayPriorityList<String> stringList = new ArrayPriorityList<String>();
		stringList.insertElementAt(0, "Hello");
		stringList.insertElementAt(1, "World");
		stringList.insertElementAt(2, "!");

		ArrayPriorityList<Integer> intList = new ArrayPriorityList<Integer>();
		intList.insertElementAt(0, 10);
		intList.insertElementAt(0, 20);
		intList.insertElementAt(0, 30);

		ArrayPriorityList<Double> doubleList = new ArrayPriorityList<Double>();
		doubleList.insertElementAt(0, 1.5);
		doubleList.insertElementAt(0, 2.7);
		doubleList.insertElementAt(0, 3.9);

		assertEquals("Hello", stringList.getElementAt(0));
		assertEquals("World", stringList.getElementAt(1));
		assertEquals("!", stringList.getElementAt(2));

		assertEquals(30, (int) intList.getElementAt(0));
		assertEquals(20, (int) intList.getElementAt(1));
		assertEquals(10, (int) intList.getElementAt(2));

		assertEquals(3.9, (double) doubleList.getElementAt(0));
		assertEquals(2.7, (double) doubleList.getElementAt(1));
		assertEquals(1.5, (double) doubleList.getElementAt(2));
	}

	@Test
	public void testRemoveElementAt() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 2);

		list.removeElementAt(0);

		assertEquals(1, list.size());
		assertEquals(2, list.getElementAt(0));

		assertThrows(IllegalArgumentException.class, () -> list.removeElementAt(-1));
		assertThrows(IllegalArgumentException.class, () -> list.removeElementAt(1));
	}

	@Test
	public void testLowerPriorityOfWithNonEmptyList() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 2);
		list.insertElementAt(2, 3);

		list.lowerPriorityOf(1);

		// After lowering priority, the list should be: [1, 3, 2]
		assertEquals(1, (int) list.getElementAt(0));
		assertEquals(3, (int) list.getElementAt(1));
		assertEquals(2, (int) list.getElementAt(2));
	}

	@Test
	public void testLowerPriorityOfWithOutOfBoundsIndex() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 2);

		// Attempting to lower priority at an out-of-bounds index should throw an
		// exception
		assertThrows(IllegalArgumentException.class, () -> list.lowerPriorityOf(-1));
		assertThrows(IllegalArgumentException.class, () -> list.lowerPriorityOf(1));
	}

	@Test
	public void testLowerPriorityOfWithDuplicateElements() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 1);
		list.insertElementAt(2, 1);

		list.lowerPriorityOf(0);

		// After lowering priority, the list should be: [1, 1, 1]
		assertEquals(1, (int) list.getElementAt(0));
		assertEquals(1, (int) list.getElementAt(1));
		assertEquals(1, (int) list.getElementAt(2));
	}

	@Test
	public void testRaisePriorityOf() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 2);
		list.insertElementAt(2, 3);

		list.raisePriorityOf(1);

		assertEquals(1, list.getElementAt(0));
		assertEquals(3, list.getElementAt(1));

		assertThrows(IllegalArgumentException.class, () -> list.raisePriorityOf(-1));
		assertThrows(IllegalArgumentException.class, () -> list.raisePriorityOf(3));
	}

	@Test
	public void testToArrayWithEmptyList() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();

		Object[] result = list.toArray();

		// The resulting array should be of length 0
		assertEquals(0, result.length);
	}

	@Test
	public void testToArrayWithNonEmptyList() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 2);
		list.insertElementAt(2, 3);

		Object[] result = list.toArray();

		// The resulting array should have the same elements in the same order
		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
		assertEquals(3, result[2]);
		assertEquals(3, result.length);
	}

	@Test
	public void testToArrayWithDuplicateElements() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 1);
		list.insertElementAt(2, 1);

		Object[] result = list.toArray();

		// The resulting array should have the same elements in the same order
		assertEquals(1, result[0]);
		assertEquals(1, result[1]);
		assertEquals(1, result[2]);
		assertEquals(3, result.length);
	}

	@Test
	public void testToArrayDoesNotModifyOriginalList() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 2);
		list.insertElementAt(2, 3);

		Object[] result = list.toArray();

		// Modify the resulting array to see if it's a clone
		result[0] = 12345678;
		result[1] = Integer.MAX_VALUE;
		result[2] = Integer.MIN_VALUE;

		// Verify that the original list is not affected
		assertEquals(1, (int) list.getElementAt(0));
		assertEquals(2, (int) list.getElementAt(1));
		assertEquals(3, (int) list.getElementAt(2));
	}

	@Test
	public void testRaisePriorityOfWithNonEmptyList() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 2);
		list.insertElementAt(2, 3);

		list.raisePriorityOf(1);

		// After raising priority, the list should be: [1, 3, 2]
		assertEquals(1, (int) list.getElementAt(0));
		assertEquals(3, (int) list.getElementAt(1));
		assertEquals(2, (int) list.getElementAt(2));
	}

	@Test
	public void testRaisePriorityOfWithOutOfBoundsIndex() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 2);

		// Attempting to raise priority at an out-of-bounds index should throw an
		// exception
		assertThrows(IllegalArgumentException.class, () -> list.raisePriorityOf(-1));
		assertThrows(IllegalArgumentException.class, () -> list.raisePriorityOf(2));
	}

	@Test
	public void testRaisePriorityOfWithLastElement() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 2);
	}

	@Test
	public void testMoveToLastWithNonEmptyList() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 2);
		list.insertElementAt(2, 3);

		list.moveToLast(1);

		// After moving, the list should be: [1, 3, 2]
		assertEquals(1, (int) list.getElementAt(0));
		assertEquals(3, (int) list.getElementAt(1));
		assertEquals(2, (int) list.getElementAt(2));
	}

	@Test
	public void testMoveToLastWithOutOfBoundsIndex() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 2);

		// Attempting to move an element at an out-of-bounds index should throw an
		// exception
		assertThrows(IllegalArgumentException.class, () -> list.moveToLast(2));
		assertThrows(IllegalArgumentException.class, () -> list.moveToLast(-1));
	}

	@Test
	public void testMoveToLastWithSingleElement() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);

		// Moving the only element should not change the list
		list.moveToLast(0);
		assertEquals(1, (int) list.getElementAt(0));
	}

	@Test
	public void testMoveToLastWithDuplicateElements() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 1);
		list.insertElementAt(2, 1);

		// Moving an element in a list with duplicate elements should work correctly
		list.moveToLast(1);

		// After moving, the list should be: [1, 1, 1]
		assertEquals(1, (int) list.getElementAt(0));
		assertEquals(1, (int) list.getElementAt(1));
		assertEquals(1, (int) list.getElementAt(2));
	}

	@Test
	public void testMoveToTopWithNonEmptyList() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 2);
		list.insertElementAt(2, 3);

		list.moveToTop(1);

		// After moving, the list should be: [2, 1, 3]
		assertEquals(2, (int) list.getElementAt(0));
		assertEquals(1, (int) list.getElementAt(1));
		assertEquals(3, (int) list.getElementAt(2));
	}

	@Test
	public void testMoveToTopWithOutOfBoundsIndex() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 2);

		// Attempting to move an element at an out-of-bounds index should throw an
		// exception
		assertThrows(IllegalArgumentException.class, () -> list.moveToTop(2));
		assertThrows(IllegalArgumentException.class, () -> list.moveToTop(-1));
	}

	@Test
	public void testMoveToTopWithSingleElement() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);

		// Moving the only element should not change the list
		list.moveToTop(0);
		assertEquals(1, (int) list.getElementAt(0));
	}

	@Test
	public void testMoveToTopWithDuplicateElements() {
		ArrayPriorityList<Integer> list = new ArrayPriorityList<>();
		list.insertElementAt(0, 1);
		list.insertElementAt(1, 1);
		list.insertElementAt(2, 1);

		// Moving an element in a list with duplicate elements should work correctly
		list.moveToTop(1);

		// After moving, the list should be: [1, 1, 1]
		assertEquals(1, (int) list.getElementAt(0));
		assertEquals(1, (int) list.getElementAt(1));
		assertEquals(1, (int) list.getElementAt(2));
	}

	// We'll discuss exceptions and -> lambdas in Tuesday's online lecture
	@Test
	public void testAddThrowsExpection() {
		ArrayPriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "1st");
		assertThrows(IllegalArgumentException.class, () -> list.insertElementAt(2, "No"));
		assertThrows(IllegalArgumentException.class, () -> list.getElementAt(2));
		assertThrows(IllegalArgumentException.class, () -> list.moveToTop(2));
		assertThrows(IllegalArgumentException.class, () -> list.moveToLast(2));
		assertThrows(IllegalArgumentException.class, () -> list.raisePriorityOf(2));
		assertThrows(IllegalArgumentException.class, () -> list.lowerPriorityOf(2));
		assertThrows(IllegalArgumentException.class, () -> list.lowerPriorityOf(-1));

	}

}