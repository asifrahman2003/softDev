import java.util.Iterator;

public class ArrayBag<T> implements Iterable<T> {

	private Object[] data;
	private int n;

	public ArrayBag() {
		data = new Object[1000];
		n = 0;
	}

	public void add(T element) {
		data[n] = element;
		n++;
	}

	// Precondition: The array is not filled to capacity
	@Override
	public Iterator<T> iterator() {
		return new iteratorHelper();
	}

	private class iteratorHelper implements Iterator<T> {
		private int presentIndex = 0;

		@Override
		public boolean hasNext() {
			return presentIndex < n;
		}

		@Override
		@SuppressWarnings("unchecked")
		public T next() {
			T component = (T) data[presentIndex++];
			return component;
		}
	}
}