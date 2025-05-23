import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Main {

	public class LinkedList<T> {
		private Node<T> head;

		@SuppressWarnings("hiding")
		private class Node<T> {
			T data;
			Node<T> next;

			Node(T data) {
				this.data = data;
				this.next = null;
			}
		}

		public void additionToLastOfString(T el) {
			Node<T> latestNode = new Node<>(el);
			if (head == null) {
				head = latestNode;
			} else {
				Node<T> presentNode = head;
				while (presentNode.next != null) {
					presentNode = presentNode.next;
				}
				presentNode.next = latestNode;
			}
		}

		@Override
		public String toString() {
			StringBuilder finalOutcome = new StringBuilder("[");
			Node<T> presentNode = head;
			while (presentNode != null) {
				finalOutcome.append(presentNode.data);
				if (presentNode.next != null) {
					finalOutcome.append(", ");
				}
				presentNode = presentNode.next;
			}
			finalOutcome.append("]");
			return finalOutcome.toString();
		}
	}

	@Test
	public void testAddLastWithStrings() {

		LinkedList<String> strs = new LinkedList<>();

		assertEquals("[]", strs.toString());

		strs.additionToLastOfString("A");

		assertEquals("[A]", strs.toString());

		strs.additionToLastOfString("B");

		assertEquals("[A, B]", strs.toString());

		strs.additionToLastOfString("C");

		strs.additionToLastOfString("D");

		assertEquals("[A, B, C, D]", strs.toString());

	}

	@Test

	public void testAddLastWithIntegers() {

		LinkedList<Integer> strs = new LinkedList<>();

		assertEquals("[]", strs.toString());

		strs.additionToLastOfString(1);

		assertEquals("[1]", strs.toString());

		strs.additionToLastOfString(2);

		assertEquals("[1, 2]", strs.toString());

		strs.additionToLastOfString(3);

		assertEquals("[1, 2, 3]", strs.toString());

	}
}
