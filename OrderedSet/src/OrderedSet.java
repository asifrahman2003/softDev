/*
 Develop class OrderedSet<E extends Comparable<E>> as a generic collection
 that stores nodes in a binary search tree data structure. Each node has
 a reference to data, a left binary search tree, and a right binary search
 tree. The type to be stored is limited to those that implement interface
 Comparable interface or any interface that extends Comparable. Construct an
 OrderedSet of elements where the elements are not comparable is not possible.
 
 @authors Rick Mercer and Muhammad Asifur Rahman
 */

public class OrderedSet<T extends Comparable<T>> {

	// A private class that stores one node in a Binary Search Tree
	private class TreeNode {

		private TreeNode right;
		private T data;
		private TreeNode left;

		public TreeNode(T element) {
			left = null;
			data = element;
			right = null;
		}
	} // end class TreeNode

	private TreeNode root;
	private int n;

	// Create an empty OrderedSet
	public OrderedSet() {
		root = null;
		n = 0;
	}

	/*
	 * Insert an element to this OrderedSet and return true keeping this an
	 * OrderedSet. element is already exists, do not change this OrderedSet, return
	 * false.
	 */
	public boolean insert(T element) {
		if (contains(element)) {
			return false;
		}

		root = insertHelperPrivate(root, element);
		n++;
		return true;
	}

	private TreeNode insertHelperPrivate(TreeNode node, T element) {
		if (node == null) {
			return new TreeNode(element);
		}

		if (element.compareTo(node.data) < 0) {
			node.left = insertHelperPrivate(node.left, element);
		} else {
			node.right = insertHelperPrivate(node.right, element);
		}

		return node;
	}

	/*
	 * Return the number of elements in this OrderedSet, which should be 0 when
	 * first constructed. This may run O(n) or O(1)--your choice.
	 */
	public int size() {
		return n;
	}

	/*-
	 * Return one string that concatenates all elements in this OrderedSet as
	 * they are visited in order. Elements are separated by spaces as in "1 4 9"
	 * for this OrderedSet:
	 *    4
	 *   / \
	 *  1   9
	 */
	public String toStringInorder() {
		StringBuilder newString = new StringBuilder();
		inorderHelperPrivate(root, newString);
		return newString.toString().trim();
	}

	private void inorderHelperPrivate(TreeNode node, StringBuilder newString) {
		if (node == null) {
			return;
		}
		inorderHelperPrivate(node.left, newString);
		newString.append(node.data).append(" ");
		inorderHelperPrivate(node.right, newString);
	}

	/*
	 * Return true is search equals an element in this OrderedSet, false if not.
	 */
	public boolean contains(T search) {
		return containsHelperPrivate(root, search);
	}

	private boolean containsHelperPrivate(TreeNode node, T search) {
		if (node == null) {
			return false;
		}

		int compare = search.compareTo(node.data);
		if (compare == 0) {
			return true;
		} else if (compare < 0) {
			return containsHelperPrivate(node.left, search);
		} else {
			return containsHelperPrivate(node.right, search);
		}
	}

	/*
	 * Return the element in this OrderedSet that is greater than all other
	 * elements. If this OrderedSet is empty, return null. No recursion needed.
	 */
	public T max() {
		TreeNode maximumNode = findMaximumHelper(root);
		return (maximumNode != null) ? maximumNode.data : null;
	}

	private TreeNode findMaximumHelper(TreeNode node) {
		while (node != null && node.right != null) {
			node = node.right;
		}
		return node;
	}

	/*
	 * Return the element in this OrderedSet that is less than all other elements.
	 * If this OrderedSet is empty, return null. No recursion needed.
	 */
	public T min() {
		TreeNode minimumNode = findMinimumHelper(root);
		return (minimumNode != null) ? minimumNode.data : null;
	}

	private TreeNode findMinimumHelper(TreeNode node) {
		while (node != null && node.left != null) {
			node = node.left;
		}
		return node;
	}

	/*
	 * Return the intersection of this OrderedSet and the other OrderedSet as a new
	 * OrderedSet. Do not modify this OrderedSet or the other OrderedSet. The
	 * intersection of two sets is the set of elements that are in both sets. The
	 * intersection of {2, 4, 5, 6} and {2, 5, 6, 9} is {2, 5, 6}
	 */
	public OrderedSet<T> intersection(OrderedSet<T> other) {
		OrderedSet<T> newString = new OrderedSet<>();
		intersectionHelperPrivate(newString, other, this.root);
		return newString;
	}

	private void intersectionHelperPrivate(OrderedSet<T> newString, OrderedSet<T> treeCheck, TreeNode current) {
		if (current != null) {
			intersectionHelperPrivate(newString, treeCheck, current.left);
			if (treeCheck.contains(current.data)) {
				newString.insert(current.data);
			}
			intersectionHelperPrivate(newString, treeCheck, current.right);
		}
	}

	/*
	 * Return the union of this OrderedSet and the other OrderedSet as a new
	 * OrderedSet. Do not modify this OrderedSet or the other OrderedSet. The union
	 * of two sets is the set all distinct elements in the collection.[ The union of
	 * {2, 4, 6} and {2, 5, 9} is {2, 4, 5, 6, 9}
	 */
	public OrderedSet<T> union(OrderedSet<T> other) {
		OrderedSet<T> newString = new OrderedSet<>();
		unionHelperPrivate(root, newString);
		unionHelperPrivate(other.root, newString);
		return newString;
	}

	private void unionHelperPrivate(TreeNode node, OrderedSet<T> newString) {
		if (node != null) {
			unionHelperPrivate(node.left, newString);
			newString.insert(node.data);
			unionHelperPrivate(node.right, newString);
		}
	}

	/*
	 * Return an OrderedSet that contains all elements greater than or equal to the
	 * first parameter (inclusive) and less than the second parameter (exclusive).
	 */
	public OrderedSet<T> subset(T inclusive, T exclusive) {
		OrderedSet<T> newString = new OrderedSet<>();
		subsetHelperPrivate(root, newString, inclusive, exclusive);
		return newString;
	}

	private void subsetHelperPrivate(TreeNode node, OrderedSet<T> newString, T inclusive, T exclusive) {
		if (node != null) {
			if (node.data.compareTo(inclusive) >= 0 && node.data.compareTo(exclusive) < 0) {
				newString.insert(node.data);
			}
			if (node.data.compareTo(inclusive) > 0) {
				subsetHelperPrivate(node.left, newString, inclusive, exclusive);
			}
			if (node.data.compareTo(exclusive) < 0) {
				subsetHelperPrivate(node.right, newString, inclusive, exclusive);
			}
		}
	}

	/*-
	* If element equals an element in this OrderedSet, remove it and return
	* true. Return false whenever element is not found. In all cases, this
	* OrderedSet must remain a true OrderedSet. Here is one recommended algorithm
	
	https://drive.google.com/file/d/1yjnYeIufsY1EgqJvaQ1nOXC627ZWauVa/view?usp=sharing
	
	* This algorithm should be O(log n)
	*/
	public boolean remove(T element) {
		if (!contains(element)) {
			return false;
		}
		root = removeHelperPrivate(root, element);
		n--;
		return true;
	}
	
	private TreeNode removeHelperPrivate(TreeNode node, T element) {
		if (node == null)
			return null;
		int compare = element.compareTo(node.data);
		if (compare < 0) {
			node.left = removeHelperPrivate(node.left, element);
		} else if (compare > 0) {
			node.right = removeHelperPrivate(node.right, element);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}
			node.data = findMinimumHelper(node.right).data;
			node.right = removeHelperPrivate(node.right, node.data);
		}
		return node;
	}
}