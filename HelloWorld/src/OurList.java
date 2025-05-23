
public class OurList<E> {
	private class Node {

		private E data; // Reference to one element
		private Node next; // null, or reference to next node

		public Node(E element) {
			data = element;
			next = null;
		}

		public Node(E element, Node nodeRef) {
			data = element;
			next = nodeRef;
		}
	}

	// An external reference to the first element
	private Node front;
	int n;

	public OurList() {
		front = null;
		n = 0;
	}

	// Insert an element at the specified location.
	// Precondition: insertIndex >= 0 and insertIndex <= size().
	public void add(int insertIndex, E element) {
		if (front == null)
			front = new Node(element);
		else if (insertIndex == 0)
			front = new Node(element, front);
		else {
			Node ref = front;
			for (int c = 1; c < insertIndex; c++) {
				ref = ref.next;
			}
			ref.next = new Node(element, ref.next);
		}
		n++;
	}

	int size() {
		return n;
	}

	// Remove the first occurrence of element and return true. If
	// element is not found leave the list unchanged and return false
	public boolean remove(E element) {
		if (front == null) {
			return false;
		}

		if (front.data.equals(element)) {
			front = front.next;
			n--;
			return true;
		}

		Node presentNode = front;
		while (presentNode.next != null) {
			if (presentNode.next.data.equals(element)) {
				presentNode.next = presentNode.next.next;
				n--;
				return true;
			}
			presentNode = presentNode.next;
		}
		return false;
	}
}
