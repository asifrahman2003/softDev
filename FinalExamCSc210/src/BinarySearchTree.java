import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {

	private class TreeNode {
		private T data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(T theData) {
			data = theData;
			left = null;
			right = null;
		}
	}

	private TreeNode root = null;
	private int n = 0;

	public void insert(T element) {
		root = insert(root, element);
		n++;
	}

	public int size() {
		return n;
	}

	private TreeNode insert(TreeNode t, T el) {
		if (t == null)
			t = new TreeNode(el);
		else if (el.compareTo(t.data) < 0)
			t.left = insert(t.left, el);
		else if (el.compareTo(t.data) > 0)
			t.right = insert(t.right, el);
		return t;
	}

	////////////////////////////////////////////////////////////
	// Add method nthLargest here
	public T get(int location) {
		return nthLargest(root, location);
	}

	private T nthLargest(TreeNode treeNode, int location) {
		if (treeNode == null)
			return null;
		if (location < 0 || location >= n)
			return null;
		if (location == n)
			return inOrder().get(n - 1);
		else if (location == 0)
			return inOrder().get(0);
		else
			return inOrder().get(location);
	}

	private ArrayList<T> inOrder() {
		ArrayList<T> newList = new ArrayList<>();
		return inOrderHelper(root, newList);
	}

	private ArrayList<T> inOrderHelper(TreeNode treeNode, ArrayList<T> list) {
		if (treeNode == null)
			return null;
		inOrderHelper(treeNode.left, list);
		list.add(treeNode.data);
		inOrderHelper(treeNode.right, list);
		return list;
	}
}
