import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class removeMethod {
	public class LinkedList<E> {

		private class Node {

			private E data; // Reference to one element
			private Node next; // null, or reference to next node

			public Node(E element, Node nodeRef) {
				data = element;
				next = nodeRef;
			}
		}

		private Node front = null;
		private int n = 0;

		// Add element at the front of the list
		public void addFront(E element) {
			front = new Node(element, front);
			n++;
		}

		public int size() {
			return n;
		}

		public String toString() {
			String result = "";
			Node p = front;
			while (p != null) {
				result += p.data + " ";
				p = p.next;
			}
			return result;
		}

		// TODO: Complete method removeAll(E el) here
		public void removeAll(E el) {
			front = removeAllAssistant(front, el);
		}

		private Node removeAllAssistant(Node presentNode, E el) {
			if (presentNode == null) {
				return null;
			}

			if (presentNode.data.equals(el)) {
				n--;
				return removeAllAssistant(presentNode.next, el);
			}

			presentNode.next = removeAllAssistant(presentNode.next, el);
			return presentNode;
		}
	}

	@Test
	void testRemoveAll() {
		LinkedList<Integer> ints = new LinkedList<>();
		assertEquals(0, ints.size());
		ints.addFront(2);
		ints.addFront(3);
		ints.addFront(5);
		ints.addFront(2);
		ints.addFront(3);
		ints.addFront(6);
		ints.addFront(9);
		assertEquals("9 6 3 2 5 3 2 ", ints.toString());
		assertEquals(7, ints.size());
		ints.removeAll(2);
		ints.removeAll(3);
		assertEquals(3, ints.size());
		assertEquals("9 6 5 ", ints.toString());

	}
}
