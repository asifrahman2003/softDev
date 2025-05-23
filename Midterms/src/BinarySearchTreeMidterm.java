import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeMidterm {
	class BinarySearchTree<T extends Comparable<T>> {

		private class TreeNode {

			private TreeNode left;
			private T data;
			private TreeNode right;

			public TreeNode(T theData) {
				left = null;
				data = theData;
				right = null;
			}
		}

		private TreeNode root = null;

		// Precondition, element is not already in this Binary Search Tree
		public void add(T element) {
			root = add(root, element);
		}

		private TreeNode add(TreeNode t, T el) {
			if (t == null)
				t = new TreeNode(el);
			else if (el.compareTo(t.data) < 0)
				t.left = add(t.left, el);
			else if (el.compareTo(t.data) > 0)
				t.right = add(t.right, el);
			return t;
		}

		// TODO: Complete this method
		public int leaves() {
			return leavesAssistant(root);
		}

		private int leavesAssistant(TreeNode treeNode) {
			if (treeNode == null) {
				return 0;
			}

			if (treeNode.left == null && treeNode.right == null) {
				return 1;
			}

			int left = leavesAssistant(treeNode.left);
			int right = leavesAssistant(treeNode.right);

			return right + left;
		}
	}

	@Test
	void testLeaves() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();

		// Test case 1: Empty tree
		assertEquals(0, tree.leaves());

		// Test case 2: Tree with one node
		tree.add(5);
		assertEquals(1, tree.leaves());

		// Test case 3: Tree with multiple nodes
		tree.add(3);
		tree.add(7);
		tree.add(2);
		tree.add(4);
		tree.add(6);
		tree.add(8);
		assertEquals(4, tree.leaves());
	}
}