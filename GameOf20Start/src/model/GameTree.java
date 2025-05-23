package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// A model for the game of 20 questions. This type can be used to
// build a console based game of 20 questions or a GUI based game.
//
// @author Rick Mercer and Muhammad Asifur Rahman
//
public class GameTree {

	// BinaryTreeNode inner class used to create new nodes in the GameTree.
	private class TreeNode {

		// Instance variables
		private String data;
		private TreeNode left;
		private TreeNode right;

		TreeNode(String theData) {
			data = theData;
			left = null;
			right = null;
		}

		// This 2nd constructor is needed in a few methods, like private build()
		TreeNode(String theData, TreeNode leftLink, TreeNode rightLink) {
			data = theData;
			left = leftLink;
			right = rightLink;
		}
	}

	// Instance variables
	private TreeNode root;
	private TreeNode currentNode;
	private Scanner scanner;

	private String fileName;

	// Constructor needed to create the game. It should open the input
	// file and call the recursive method build(). The String parameter
	// name is the name of the file from which we need to read the game
	// questions and answers from.
	//
	public GameTree(String name) {
		fileName = name;
		try {
			scanner = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File not found: '" + fileName + "'");
		}
		root = build();
		currentNode = root;
		scanner.close();
	}

	// Build a GameTree in preorder fashion and return the root of the tree
	private TreeNode build() {
		if (scanner.hasNextLine()) {
			String nextLine = scanner.nextLine().trim();
			TreeNode createdNode;
			if (nextLine.endsWith("?")) {
				TreeNode left = build();
				TreeNode right = build();
				createdNode = new TreeNode(nextLine, left, right);
			} else {
				createdNode = new TreeNode(nextLine);
			}
			return createdNode;
		}
		return null;
	}

	// Method used to print out a text version of the game file
	// in a level order fashion
	@Override
	public String toString() {
		return toString(root, 0);
	}

	private String toString(TreeNode node, int nodeLevel) {
		if (node == null)
			return "";
		StringBuilder newString = new StringBuilder();
		for (int i = 0; i < nodeLevel; i++) {
			newString.append("- ");
		}
		newString.append(node.data).append("\n");
		newString.append(toString(node.left, nodeLevel + 1));
		newString.append(toString(node.right, nodeLevel + 1));
		return newString.toString();
	}

	// Add a new question and answer to the currentNode. If the currentNode
	// is referencing the answer "parrot", theGame.add("Does it swim?", "duck");
	// should change the GameTree on the left to the GameTree omn the right:
	//
	// Feathers? Feathers?
	// / \ / \
	// parrot horse Does it swim? horse
	// / \
	// duck parrot
	//
	// @param newQuestion: The question to add where the old answer was.
	// @param newAnswer: The new yes answer to the new question.
	//
	// Precondition: newQuestion.endsWith("?")
	//
	public void add(String newQuestion, String newAnswer) {
		if (foundAnswer()) {
			String temporaryData = currentNode.data;
			TreeNode left = new TreeNode(newAnswer);
			TreeNode right = new TreeNode(temporaryData);
			currentNode.data = newQuestion;
			currentNode.left = left;
			currentNode.right = right;
		}
	}

	// Return true if getCurrent() is an answer rather than a question. Return false
	// if the current node is an internal node rather than a leaf that is an answer.
	public boolean foundAnswer() {
		return currentNode != null && currentNode.left == null && currentNode.right == null;
	}

	// Return the data for the current node,
	// which could be a question or an answer.
	public String getCurrent() {
		return currentNode.data;
	}

	// Ask the game to update the current node in the tree by
	// going left for Choice.yes or right for Choice.no
	// Example code:
	// theGame.playerSelected(Choice.Yes);
	//
	public void playerSelected(Choice yesOrNo) {
		if (yesOrNo == Choice.YES) {
			currentNode = currentNode.left;
		} else {
			currentNode = currentNode.right;
		}
	}

	// Begin a game at the root of the tree. getCurrent should return the question
	// at the root of this GameTree.
	public void reStart() {
		currentNode = root;
	}

	// Overwrite the old file for this gameTree with the current state that
	// may have new questions added since the game started. Get all other
	// method workings. Complete this method last.
	public void saveGame() {
		try (PrintWriter printWrite = new PrintWriter(new FileWriter(fileName))) {
			save(root, printWrite);
			printWrite.close();
		} catch (IOException exception) {
			exception.getMessage();
		}
	}

	private void save(TreeNode node, PrintWriter fileWriter) {
		if (node != null) {
			fileWriter.println(node.data);
			save(node.left, fileWriter);
			save(node.right, fileWriter);
		}
	}
}