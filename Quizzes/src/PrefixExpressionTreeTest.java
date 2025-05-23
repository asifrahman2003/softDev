package codeDemoDone;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

class PrefixExpressionTree {

  private class TreeNode {
    
    private String data;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(String theData) {
      data = theData;
      left = null;
      right = null;
    }

    public TreeNode(String elementReference, TreeNode leftLink, TreeNode rightLink) {
      data = elementReference;
      left = leftLink;
      right = rightLink;
    }
  }

  private TreeNode root;
  private Scanner scanner; // Available in build

   // Return the longest path from the root to the bottom most leaf
    public int height() {
      // TODO Complete this method for ICA 8)
      return Integer.MIN_VALUE;
    }
   
    // Return the number of leaves (operands) in this tree
    public int leaves() {
      // TODO Complete this method for ICA 8)
      return Integer.MIN_VALUE;
    }
    
    // Return how many nodes are at the given level. If level > the height 
    // of the tree, return 0. An empty tree has a height of -1 (page 252).
    //
    // ____ 4 _ There is 1 node on level 0
    // ___ / \
    // __ 3 __ 9 _ There are 2 nodes on level 1
    // _ / \ __ \
    // 1 __ 5 __ 11 _ There are 3 nodes in level 2 and 0 nodes on levels >= 3)
    // 
    public int nodesAtLevel(int level) {
      // TODO Complete this method for ICA 8)
      return Integer.MIN_VALUE;
    }


  // Example: "+ 5 4"
  public PrefixExpressionTree(String infix) {
    infix = infix.trim();
    if (infix.length() == 0)
      root = null;
    else {
      scanner = new Scanner(infix);
      root = build();
    }
  }

  private TreeNode build() {
    // Base case
    if (!scanner.hasNext())
      return null;

    // Get the next operand or operator
    String token = scanner.next();

    if (isOperand(token))
      return new TreeNode(token);
    else {
      TreeNode leftSubtree = build();
      TreeNode rightSubtree = build();
      return new TreeNode(token, leftSubtree, rightSubtree);
    }
  }

  private boolean isOperand(String token) {
    // TODO: add 3 operators
    return "+ - * / %".indexOf(token) == -1;
  }

  public int valueOf() {
    return valueOf(root);
  }

  private int valueOf(TreeNode t) {
    if (t == null)
      return 0;
    else if (t.left == null && t.right == null) // must be an operand
      return Integer.parseInt(t.data);
    else if (t.data.equals("+"))
      return valueOf(t.left) + valueOf(t.right);
    else if (t.data.equals("-"))
      return valueOf(t.left) - valueOf(t.right);
    else if (t.data.equals("*"))
      return valueOf(t.left) * valueOf(t.right);
    else if (t.data.equals("/"))
      return valueOf(t.left) / valueOf(t.right);
    else if (t.data.equals("%"))
      return valueOf(t.left) % valueOf(t.right);
    //
    // TODO: Add functionality for * / %
    //
    return Integer.MIN_VALUE;
  }

  public String inOrder() {
    return inOrder(root);
  }

  private String inOrder(TreeNode t) {
    if (t == null)
      return "";
    else
      return inOrder(t.left) + t.data + " " + inOrder(t.right);
  }

  public String preOrder() {
    return preOrder(root);
  }

  private String preOrder(TreeNode t) {
    if (t == null)
      return "";
    else
      return t.data + " " + preOrder(t.left) + preOrder(t.right);
  }

  // A different start. We'll use a separate
  // instance variable to accumulate
  public String sideways() {
    int depth = 0;
    accumulate = "\n";
    return addUp(root, depth);
  }

  String accumulate;

  private String addUp(TreeNode t, int depth) {
    if (t != null) {
      addUp(t.right, depth + 1);
      for (int num = 1; num <= depth; num++) {
        accumulate += "   ";
      }
      accumulate += t.data + "\n";
      addUp(t.left, depth + 1);
    }
    return accumulate;
  }
 
  
} // End class PrefixExpressionTree;

public class PrefixExpressionTreeTest {

  @Test
  public void showSideways1() {
    PrefixExpressionTree et = new PrefixExpressionTree("+ - 7 3 * 4 5");
    assertEquals("7 - 3 + 4 * 5", et.inOrder().trim());
    assertEquals(24, et.valueOf());
    System.out.println(et.sideways());
  }

  @Test
  public void showSideways2() {
    PrefixExpressionTree et = new PrefixExpressionTree("+ 5 - 3 8");
    assertEquals(0, et.valueOf());
    assertEquals("5 + 3 - 8", et.inOrder().trim());
    System.out.println(et.sideways());
  }

  @Test
  public void testEmptyTree() {
    PrefixExpressionTree et = new PrefixExpressionTree("");
    assertEquals(0, et.valueOf());
  }

  @Test
  public void testTreeWithOneValue() {
    PrefixExpressionTree et = new PrefixExpressionTree("987654");
    assertEquals(987654, et.valueOf());
  }

  @Test
  public void testTreeWithPlusEasy1() {
    // Let the constructor parse the argument to build a valid expression tree
    PrefixExpressionTree et = new PrefixExpressionTree("+ 3 2");
    assertEquals(5, et.valueOf());
  }

  @Test
  public void testTreeWithPlusEasy() {
    PrefixExpressionTree et = new PrefixExpressionTree("+ + 1 2 3");
    assertEquals(6, et.valueOf());
  }

  @Test
  public void testTreeWithMinusEasy1() {
    PrefixExpressionTree et = new PrefixExpressionTree("- 8 6");
    assertEquals(2, et.valueOf());
  }

  @Test
  public void testTreeWithMinusEasy2() {
    PrefixExpressionTree et = new PrefixExpressionTree("- 6 8");
    assertEquals(-2, et.valueOf());
  }

  @Test
  public void testLongerExpression1() {
    PrefixExpressionTree et = new PrefixExpressionTree("+ - + 7 3 8 9");
    assertEquals(11, et.valueOf());
  }

  @Test
  public void testLongerExpression2() {
    PrefixExpressionTree et = new PrefixExpressionTree("+ - + - 1 2 3 4 5");
    assertEquals(3, et.valueOf());
  }

  @Test
  public void testTravesals() {
    PrefixExpressionTree et = new PrefixExpressionTree("+ - + 7 3 8 9");
    assertEquals("7 + 3 - 8 + 9", et.inOrder().trim());
  }

  @Test
  public void testTravesals3() {
    PrefixExpressionTree et = new PrefixExpressionTree("+ - + 7 3 8 9");
    assertEquals("7 + 3 - 8 + 9", et.inOrder().trim());
  }

  @Test
  public void testTravesals4() {
    PrefixExpressionTree et = new PrefixExpressionTree("+ - + 7 3 8 9");
    assertEquals("+ - + 7 3 8 9", et.preOrder().trim());
  }

  ///////////// Now with * /and %

  @Test
  public void testValue6() {
    PrefixExpressionTree et = new PrefixExpressionTree("* 7 2");
    assertEquals(14, et.valueOf());
  }

  @Test
  public void testValue7() {
    PrefixExpressionTree et = new PrefixExpressionTree("/ 7 2");
    assertEquals(3, et.valueOf());
  }

  @Test
  public void testValue8() {
    PrefixExpressionTree et = new PrefixExpressionTree("% 123 50");
    assertEquals(23, et.valueOf());
  }

  @Test
  public void testValue9() {
    PrefixExpressionTree et = new PrefixExpressionTree("* / % 12 7 2 99");
    assertEquals(198, et.valueOf());
  }

  @Test
  public void valueOf7() {
    PrefixExpressionTree et = new PrefixExpressionTree("/ * % 7 3 8 9");
    assertEquals("/ * % 7 3 8 9", et.preOrder().trim());
  }

  @Test
  public void valueOf8() {
    PrefixExpressionTree et = new PrefixExpressionTree("+ - + 7 3 8 9");
    assertEquals("7 + 3 - 8 + 9", et.inOrder().trim());
    assertEquals(11, et.valueOf());
  }

}