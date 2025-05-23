package model;

/**
 * This interface describes an abstract data type to store elements where
 * indexes represent priorities and the priorities can change in several ways.
 * 
 * @author Rick Mercer and Muhammad Asifur Rahman
 * @param <E> The type of all elements stored in this collection
 */
public class LinkedPriorityList<E> implements PriorityList<E> {

	private class Node {

		private E data;
		private Node next;

		public Node(E element, Node link) {
			data = element;
			next = link;
		}
	}

	private Node first;
	private int n;

	public LinkedPriorityList() {
		first = null;
		n = 0;
	}

	/**
	 * Return the number of elements currently in this PriorityList
	 * 
	 * @return The number of elements in this PriorityList
	 */
	public int size() {
		return n;
	}

	/**
	 * Return true if there are zero elements in this PriorityList
	 * 
	 * @return true if size() == 0 or false if size() > 0
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * If possible, insert the element at the given index. If index is out of the
	 * valid range of 0..size(), throw new IllegalArgumentException(); When size is
	 * 3, the only possible values for index are 0, 1, 2, AND 3 because you can add
	 * an element as the new last.
	 * 
	 * @param index The index of the element to move.
	 * @param el    The element to insert
	 * @throws IllegalArgumentException
	 */
	public void insertElementAt(int index, E el) throws IllegalArgumentException {
		if (index < 0 || index > n) {
			throw new IllegalArgumentException("Index out of bounds");
		}
		Node createdNode = new Node(el, null);
		if (index == 0) {
			createdNode.next = first;
			first = createdNode;
		} else {
			Node previousNode = first;
			int i = 0;
			while (i < index - 1) {
				previousNode = previousNode.next;
				i++;
			}
			createdNode.next = previousNode.next;
			previousNode.next = createdNode;
		}
		n++;
	}

	/**
	 * If possible, return a reference to the element at the given index. If index
	 * is out of the valid range of 0..size()-1, throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 * 
	 * @param index The index where the element gets inserted into. All other
	 *              elements must remain this list.
	 * @return A reference to the element at index index.
	 * @throws IllegalArgumentException
	 */
	public E getElementAt(int index) throws IllegalArgumentException {
		if (index < 0 || index >= n) {
			throw new IllegalArgumentException("Index out of bounds");
		}
		Node presentNode = first;
		int i = 0;
		while (i < index) {
			presentNode = presentNode.next;
			i++;
		}
		return presentNode.data;
	}

	/**
	 * If possible, remove the element at the given index. If index is out of the
	 * valid range of 0..size()-1, throw new IllegalArgumentException(); When size
	 * is 3, the only possible values for index are 0, 1, and 2.
	 * 
	 * @param index The index of the element to remove. All other elements must
	 *              remain.
	 * @throws IllegalArgumentException
	 */
	public void removeElementAt(int index) throws IllegalArgumentException {
		if (index < 0 || index >= n) {
			throw new IllegalArgumentException("Index out of bounds");
		}
		if (index == 0) {
			first = first.next;
		} else {
			Node previousNode = first;
			int i = 0;
			while (i < index - 1) {
				previousNode = previousNode.next;
				i++;
			}
			previousNode.next = previousNode.next.next;
		}
		n--;
	}

	/**
	 * If possible, swap the element located at index with the element at index + 1.
	 * An attempt to lower the priority of the element at index size()-1 has no
	 * effect. If index is out of the valid range of 0..size()-1, throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 * 
	 * @param index The index of the element to be changed with one next to it.
	 * @throws IllegalArgumentException
	 */
	public void lowerPriorityOf(int index) throws IllegalArgumentException {
		if (index < 0 || index >= n - 1) {
			throw new IllegalArgumentException("Index out of bounds");
		}
		Node previousNode = first;
		Node presentNode = first.next;
		int i = 0;
		while (i < index) {
			previousNode = previousNode.next;
			presentNode = presentNode.next;
			i++;
		}
		E temporaryElement = previousNode.data;
		previousNode.data = presentNode.data;
		presentNode.data = temporaryElement;
	}

	/**
	 * If possible, swap the element located at index with the element at index-1.
	 * An attempt to raise the priority at index 0 has no effect. If index is out of
	 * the valid range of 0..size()-1, throw new IllegalArgumentException(); When
	 * size is 3, the only possible values for index are 0, 1, and 2.
	 * 
	 * @param index The index of the element to be changed with one next to it.
	 * @throws IllegalArgumentException
	 */
	public void raisePriorityOf(int index) throws IllegalArgumentException {
		if (index <= 0 || index >= n) {
			throw new IllegalArgumentException("Index out of bounds");
		}
		if (index == 1) {
			Node nodeOne = first;
			Node nodeTwo = nodeOne.next;
			E temporaryElement = nodeOne.data;
			nodeOne.data = nodeTwo.data;
			nodeTwo.data = temporaryElement;
			first = nodeTwo;
		} else {
			Node previousNode = first;
			int i = 0;
			if (index > 2) {
				do {
					previousNode = previousNode.next;
					i++;
				} while (i < index - 2);
			}
			Node presentNode = previousNode.next;
			Node nextNode = presentNode.next;
			previousNode.next = presentNode.next;
			presentNode.next = nextNode.next;
			nextNode.next = presentNode;
		}
	}

	/**
	 * Return a copy of all elements as an array of Objects that is the size of this
	 * PriorityList and in the same order. If there are no elements in this list,
	 * return new Object[0]; A change to the return value must not affect this
	 * PriorityList object.
	 * 
	 * @return An array of Objects where capacity == size()
	 */
	public Object[] toArray() {
		Object[] newArray = new Object[n];
		Node presentNode = first;
		int i = 0;
		while (i < n) {
			newArray[i] = presentNode.data;
			presentNode = presentNode.next;
			i++;
		}
		return newArray;
	}

	/**
	 * If possible, move the element at the given index to the end of this list. An
	 * attempt to move the last element to the last has no effect. If the index is
	 * out of the valid range 0..size()-1 throw new IllegalArgumentException(); When
	 * size is 3, the only possible values for index are 0, 1, and 2.
	 * 
	 * @param index The index of the element to be changed to be the last index.
	 * @throws IllegalArgumentException
	 */
	public void moveToLast(int index) throws IllegalArgumentException {
		if (index < 0 || index >= n) {
			throw new IllegalArgumentException("Index out of bounds");
		}
		E temporaryElement = getElementAt(index);
		removeElementAt(index);
		insertElementAt(n, temporaryElement);
	}

	/**
	 * If possible, move the element at the given index to the front of this list An
	 * attempt to move the top element to the top has no effect. If the index is out
	 * of the valid range of 0..size()-1, throw new IllegalArgumentException(); When
	 * size is 3, the only possible values for index are 0, 1, and 2.
	 * 
	 * @param index The index of the element to be changed to the first index.
	 * @throws IllegalArgumentException
	 */
	public void moveToTop(int index) throws IllegalArgumentException {
		if (index < 0 || index >= n) {
			throw new IllegalArgumentException("Index out of bounds");
		}
		E temporaryElement = getElementAt(index);
		removeElementAt(index);
		insertElementAt(0, temporaryElement);
	}
}