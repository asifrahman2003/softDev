/**
 * StringSet objects store a set of strings.
 * 
 * @author Rick Mercer and Muhammad Asifur Rahman
 */

public class StringSet {

	private String[] elements;
	private int size;

	// Construct an empty set (no elements yet)
	public StringSet(int capacity) {
		elements = new String[capacity];
		size = 0;
	}

	// Add a string to this StringSet if it is not already in this StringSet and
	// return true. If the stringToAdd is already in this set, return false.
	// This StringSet may be filled to capacity. If so, grow the array.
	public boolean add(String stringToAdd) {
		if (size == elements.length) {
			String[] newSegments = new String[elements.length * 2];

			int i = 0;
			while (i < size) {
				newSegments[i] = elements[i];
				i++;
			}
			elements = newSegments;
		}
		int i = 0;

		while (i < size) {
			if (elements[i].equals(stringToAdd)) {
				return false;
			}
			i++;
		}
		elements[size] = stringToAdd;
		size++;
		return true;
	}

	// Determine if stringToAdd is, or is not in this set
	public boolean contains(String stringToAdd) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(stringToAdd)) {
				return true;
			}
		}
		return false;
	}

	// Return how many consecutive meaningful elements are in the array
	public int size() {
		return size;
	}

	// Return true if there are no elements in this set
	public boolean isEmpty() {
		return size == 0;
	}

	// toString shows all elements surrounded by square brackets { } and
	// all elements separated by ", " as shown in this @Test method.
	//
	// @Test
	// public void testToString() {
	// StringSet names = new StringSet(10);
	// assertEquals("{}", names.toString());
	// assertTrue(names.add("Kim"));
	// assertEquals("{Kim}", names.toString());
	// assertTrue(names.add("Chris"));
	// assertEquals("{Kim, Chris}", names.toString());
	// assertTrue(names.add("Devon"));
	// assertEquals("{Kim, Chris, Devon}", names.toString());
	// assertTrue(names.add("Ali"));
	// assertEquals("{Kim, Chris, Devon, Ali}", names.toString());
	// }
	//
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("{");
		for (int i = 0; i < size; i++) {
			stringBuilder.append(elements[i]);
			if (i < size - 1) {
				stringBuilder.append(", ");
			}
		}
		stringBuilder.append("}");
		return stringBuilder.toString();
	}

	// Remove element if it is in this set, otherwise return false
	public boolean remove(String element) {
		if (contains(element)) {
			int index = -1;
			int i = 0;
			while (i < size) {
				if (elements[i].equals(element)) {
					index = i;
					break;
				}
				i++;
			}
			i = index;
			while (i < size - 1) {
				elements[i] = elements[i + 1];
				i++;
			}
			size--;
			return true;
		}
		return false;
	}

	// Complete method intersection to return the intersection of two StringSets.
	// oneStringSet.intersection(StringSet other) returns a StringSet that contains
	// all elements of oneStringSet that also belong to other. For example,
	// {"a", "b", "c"}.intersection ({"b", "c", "d"})) returns {"b", "c"}
	// Do not modify either StringSet involved in the message.
	public StringSet intersection(StringSet other) {
		StringSet general = new StringSet(elements.length);
		int i = 0;
		while (i < size) {
			if (other.contains(elements[i])) {
				general.add(elements[i]);
			}
			i++;
		}
		return general;
	}

	// Complete method union to return the union of two StringSets.
	// oneStringSet.union(StringSet other) should return a StringSet that contains
	// all
	// elements that are in oneStringSet or in other, possibly both. For example,
	// {"a", "b", "c", "f"}.union( {"b", "c", "e"}) returns {"a", "b", "c", "e",
	// "f"}.
	// Do not modify either StringSet involved in the message.
	public StringSet union(StringSet other) {
		StringSet newSet = new StringSet(elements.length + other.elements.length);
		int i = 0;
		while (i < size) {
			newSet.add(elements[i]);
			i++;
		}

		i = 0;
		while (i < other.size) {
			newSet.add(other.elements[i]);
			i++;
		}
		return newSet;
	}
}