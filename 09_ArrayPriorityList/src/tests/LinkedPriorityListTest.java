package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

/** 
 * A JUnit test for LinkedPriorityList.
 * 

*/

import model.LinkedPriorityList; // Changed from ArrayPriorityList

public class LinkedPriorityListTest { // Changed from ArrayPriorityListTest

    @Test
    public void testGenericity() {
        LinkedPriorityList<String> stringList = new LinkedPriorityList<String>(); // Changed from ArrayPriorityList
        stringList.insertElementAt(0, "A");
        stringList.insertElementAt(1, "B");
        stringList.insertElementAt(2, "C");

        LinkedPriorityList<Integer> intList = new LinkedPriorityList<Integer>(); // Changed from ArrayPriorityList
        intList.insertElementAt(0, 1);
        intList.insertElementAt(0, 2);
        intList.insertElementAt(0, 3);

        LinkedPriorityList<Double> doubleList = new LinkedPriorityList<Double>(); // Changed from ArrayPriorityList
        doubleList.insertElementAt(0, 1.1);
        doubleList.insertElementAt(0, 2.2);
        doubleList.insertElementAt(0, 3.3);
    }

    @Test
    public void testToArrayReturnsACloneOfTheInstanceVariable() {
        LinkedPriorityList<Integer> list = new LinkedPriorityList<Integer>(); // Changed from ArrayPriorityList

        list.insertElementAt(0, 77);
        list.insertElementAt(1, 88);
        list.insertElementAt(2, 99);

        Object[] result = list.toArray();
        // Make sure the new array built in toArray has capacity == n
        assertEquals(3, result.length);
        // Make sure the elements and indexes match in the Object[]
        assertEquals(77, result[0]);
        assertEquals(88, result[1]);
        assertEquals(99, result[2]);

        // Make sure you did simply not return a reference to data
        // because a change to result should NOT affect data
        result[0] = 12345678;
        result[1] = Integer.MAX_VALUE;
        result[2] = Integer.MIN_VALUE;
        // Cast need in the assertions
        assertEquals(77, (int) list.getElementAt(0));
        assertEquals(88, (int) list.getElementAt(1));
        assertEquals(99, (int) list.getElementAt(2));
    }

    // We'll discuss exceptions and -> lambdas in Tuesday's online lecture
    @Test
    public void testAddThrowsExpection() {
        LinkedPriorityList<String> list = new LinkedPriorityList<String>(); // Changed from ArrayPriorityList
        list.insertElementAt(0, "1st");
        assertThrows(IllegalArgumentException.class, () -> list.insertElementAt(2, "No"));

    }

    @Test
    public void testSizeAndIsEmpty() {
        LinkedPriorityList<String> stringList = new LinkedPriorityList<String>(); // Changed from ArrayPriorityList
        assertTrue(stringList.isEmpty());
        assertEquals(0, stringList.size());

        stringList.insertElementAt(0, "A");
        assertFalse(stringList.isEmpty());
        assertEquals(1, stringList.size());
    }

    @Test
    public void testInsertElementAt() {
        LinkedPriorityList<String> stringList = new LinkedPriorityList<String>(); // Changed from ArrayPriorityList
        stringList.insertElementAt(0, "A");
        assertEquals("A", stringList.getElementAt(0));

        stringList.insertElementAt(0, "B");
        assertEquals("B", stringList.getElementAt(0));
        assertEquals("A", stringList.getElementAt(1));

        stringList.insertElementAt(2, "C");
        assertEquals("B", stringList.getElementAt(0));
        assertEquals("A", stringList.getElementAt(1));
        assertEquals("C", stringList.getElementAt(2));
    }

    @Test
    public void testRemoveElementAt() {
        LinkedPriorityList<String> stringList = new LinkedPriorityList<String>(); // Changed from ArrayPriorityList
        stringList.insertElementAt(0, "A");
        stringList.insertElementAt(1, "B");
        stringList.insertElementAt(2, "C");

        stringList.removeElementAt(1);
        assertEquals("A", stringList.getElementAt(0));
        assertEquals("C", stringList.getElementAt(1));
    }

    @Test
    public void testLowerPriorityOf() {
        LinkedPriorityList<String> stringList = new LinkedPriorityList<String>(); // Changed from ArrayPriorityList
        stringList.insertElementAt(0, "A");
        stringList.insertElementAt(1, "B");
        stringList.insertElementAt(2, "C");

        stringList.lowerPriorityOf(1);

    }

    @Test
    public void testRaisePriorityOf() {
        LinkedPriorityList<String> stringList = new LinkedPriorityList<String>(); // Changed from ArrayPriorityList
        stringList.insertElementAt(0, "A");
        stringList.insertElementAt(1, "B");
        stringList.insertElementAt(2, "C");

        stringList.raisePriorityOf(1);

    }

    @Test
    public void testMoveToLast() {
        LinkedPriorityList<String> stringList = new LinkedPriorityList<String>(); // Changed from ArrayPriorityList
        stringList.insertElementAt(0, "A");
        stringList.insertElementAt(1, "B");
        stringList.insertElementAt(2, "C");

        stringList.moveToLast(0);
        assertEquals("B", stringList.getElementAt(0));
        assertEquals("C", stringList.getElementAt(1));
        assertEquals("A", stringList.getElementAt(2));
    }

    @Test
    public void testMoveToTop() {
        LinkedPriorityList<String> stringList = new LinkedPriorityList<String>(); // Changed from ArrayPriorityList
        stringList.insertElementAt(0, "A");
        stringList.insertElementAt(1, "B");
        stringList.insertElementAt(2, "C");

        stringList.moveToTop(2);
        assertEquals("C", stringList.getElementAt(0));
        assertEquals("A", stringList.getElementAt(1));
        assertEquals("B", stringList.getElementAt(2));
    }

    @Test 
    public void testToArray() {
        LinkedPriorityList<String> stringList = new LinkedPriorityList<String>(); // Changed from ArrayPriorityList
        stringList.insertElementAt(0, "A");
        stringList.insertElementAt(1, "B");
        stringList.insertElementAt(2, "C");

        Object[] array = stringList.toArray();
        assertEquals("A", array[0]);
        assertEquals("B", array[1]);
        assertEquals("C", array[2]);
    }

    @Test
    public void testInvalidIndex() {
        LinkedPriorityList<String> stringList = new LinkedPriorityList<String>(); // Changed from ArrayPriorityList
        assertThrows(IllegalArgumentException.class, () -> stringList.getElementAt(-1));
        assertThrows(IllegalArgumentException.class, () -> stringList.insertElementAt(-1, "A"));
        assertThrows(IllegalArgumentException.class, () -> stringList.removeElementAt(0));
        assertThrows(IllegalArgumentException.class, () -> stringList.lowerPriorityOf(0));
        assertThrows(IllegalArgumentException.class, () -> stringList.raisePriorityOf(0));
        assertThrows(IllegalArgumentException.class, () -> stringList.moveToLast(0));
        assertThrows(IllegalArgumentException.class, () -> stringList.moveToTop(0));
    }
}