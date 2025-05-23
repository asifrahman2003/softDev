package model;

// PriorityList objects store a collection of elements as an indexed list.
//
// @author Rick Mercer and Muhammad Asifur Rahman
public class ArrayPriorityList<E> implements PriorityList<E> {
	private Object[] elements;
	private int n;

	// Create an empty list with zero elements
	public ArrayPriorityList() {
		elements = new Object[20];
		n = 0;
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public void insertElementAt(int index, E el) throws IllegalArgumentException {
		if (index < 0 || index > size())
			throw new IllegalArgumentException("getIndex=" + index);
		int i = size();
		while (i > index) {
			elements[i] = elements[i - 1];
			i--;
		}

		elements[index] = el;
		n++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getElementAt(int index) throws IllegalArgumentException {
		if (index < 0 || index >= size())
			throw new IllegalArgumentException("getIndex=" + index);

		return (E) elements[index];
	}

	@Override
	public void removeElementAt(int index) throws IllegalArgumentException {
		if (index < 0 || index >= size())
			throw new IllegalArgumentException("getIndex=" + index);
		int i = index;
		while (i < size() - 1) {
			elements[i] = elements[i + 1];
			i++;
		}
		n--;
	}

	@Override
	public void lowerPriorityOf(int index) throws IllegalArgumentException {
		if (index < 0 || index >= size() - 1)
			throw new IllegalArgumentException("getIndex=" + index);

		if (!isEmpty()) {
			E temporaryElement = getElementAt(index);
			elements[index] = elements[index + 1];
			elements[index + 1] = temporaryElement;
		}
	}

	@Override
	public void raisePriorityOf(int index) throws IllegalArgumentException {
		if (index <= 0 || index >= size())
			throw new IllegalArgumentException("getIndex=" + index);

		if (index < size() - 1) {
			E temporaryElement = getElementAt(index);
			elements[index] = elements[index + 1];
			elements[index + 1] = temporaryElement;
		}
	}

	@Override
	public Object[] toArray() {
		Object[] newArray = new Object[size()];
		int i = 0;
		while (i < size()) {
			newArray[i] = elements[i];
			i++;
		}
		return newArray;
	}

	@Override
	public void moveToLast(int index) throws IllegalArgumentException {
		if (index < 0 || index >= size())
			throw new IllegalArgumentException("getIndex=" + index);
		if (index < n - 1) {
			E temporaryElement = getElementAt(index);
			removeElementAt(index);
			insertElementAt(n, temporaryElement);
		}
	}

	@Override
	public void moveToTop(int index) throws IllegalArgumentException {
		if (index < 0 || index >= size())
			throw new IllegalArgumentException("getIndex=" + index);
		if (!isEmpty()) {
			E temporaryElement = getElementAt(index);
			removeElementAt(index);
			insertElementAt(0, temporaryElement);
		}
	}

}