// This file contains an almost completed prefix ExpressionTree AND a JUNit test at the bottom
import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

// We can have multiple classes in a file, however only one can be public, which is 
// public class PrefixExpressionTreeTest. This file can be run as a JUnit test (one file).
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
  private Scanner scanner;

  // "+ 5 4"
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
    // One base case
    if (!scanner.hasNext())
      return null;

    String token = scanner.next();

    // Another base case
    if (isOperand(token))
      return new TreeNode(token);
    else {
      // Recursive case.  As with trees, we almost always go left and right.
      TreeNode leftSubtree = build();
      TreeNode rightSubtree = build();
      return new TreeNode(token, leftSubtree, rightSubtree);
    }
  }

  private boolean isOperand(String token) {
    // TODO: Allow 3 additional tokens be recognized by operators
    return "+ -".indexOf(token) == -1;
  }

  public int valueOf() {
    return valueOf(root);
  }

  private int valueOf(TreeNode t) {
    // Base case
    if (t == null)
      return 0;
    else if (t.left == null && t.right == null) // Leaf detected, must be operand, another base case
      return Integer.parseInt(t.data);
    else if (t.data.equals("+"))
      return valueOf(t.left) + valueOf(t.right);
    else if (t.data.equals("-"))
      return valueOf(t.left) - valueOf(t.right);

    //
    // TODO: Add functionality for * / %.. When done run this file as 
    //
    
    return Integer.MIN_VALUE;
  }

  
  public String preOrder() {
    // TODO: Implement preOrder, which is similar toinOrder below
    return null;
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
 
}  // End class PrefixExpressionTree;



public class PrefixExpressionTreeTest {
  
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
    PrefixExpressionTree et =
      new PrefixExpressionTree("+ 3 2");
    assertEquals(5, et.valueOf());
  }
  
  @Test
  public void testTreeWithPlusEasy() {
    PrefixExpressionTree et = 
       new PrefixExpressionTree("+ + 1 2 3");
    assertEquals(6, et.valueOf());
  }

  @Test
  public void testTreeWithMinusEasy1() {
    PrefixExpressionTree et = 
       new PrefixExpressionTree("- 8 6");
    assertEquals(2, et.valueOf());
  }
  
  @Test
  public void testTreeWithMinusEasy2() {
    PrefixExpressionTree et = 
       new PrefixExpressionTree("- 6 8");
    assertEquals(-2, et.valueOf());
  }

  @Test
  public void testLongerExpression1() {
    PrefixExpressionTree et = 
       new PrefixExpressionTree("+ - + 7 3 8 9");
    assertEquals(11, et.valueOf());
  }
  
  @Test
  public void testLongerExpression2() {
    PrefixExpressionTree et = 
       new PrefixExpressionTree("+ - + - 1 2 3 4 5");
    assertEquals(3, et.valueOf());
  }
  
  @Test
  public void testTravesals() {
    PrefixExpressionTree et = new PrefixExpressionTree("+ - + 7 3 8 9");
    assertEquals("7 + 3 - 8 + 9", et.inOrder().trim());
  } 
  
  @Test
  public void testTravesals2() {
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