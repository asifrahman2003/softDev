/**
 * Complete these methods using recursion, no loops. The array processing
 * algorithms require private helper method(s).
 * 
 * The comment specifications sometimes us rf as an instance of this class with
 * the recursive method assuming your JUnit test has this instance variable.
 * 
 * RecursionFun rf = new RecursionFun();
 * 
 * An important negative and easy way to lose points: -6 out of 7 points If you
 *  use a loop instead of recursion even though your method works.
 *
 * @author Rick Mercer and YOUR NAME
 */
public class RecursionFun {

  ///////////////////////////////////////////////////////////////////////////////
  // Complete recursive method combinations that returns from n choose k.
  // See presentation 16_SimpleRecursion.pdf for an explanation and definition.
  //
  // rf.combinations(5, 1) returns 5
  // rf.combinations(5, 5) returns 1
  // rf.combinations(52, 5) returns 2598960
  //
  // Precondition n >= 1 and k >= 1
  //
  public int combinations(int n, int k) {
    // TODO: Complete this method with a recursive algorithm
    return -999;
  }

  ///////////////////////////////////////////////////////////////////////////////
  // Return n! Use recursion, do not use a loop.
  //
  // rf.factorial(0) returns 1
  // rf.factorial(1) returns 1
  // rf.factorial(2) returns 2
  // rf.factorial(5) returns 5*4*3*2*1
  //
  public int factorial(int n) {
    // TODO: Complete this method with a recursive algorithm
    return -999;
  }

  ///////////////////////////////////////////////////////////////////////////////
  // Return true if str is a palindrome, a string that reads the same in reverse
  // order in a case sensitive fashion. Use recursion, do not use a loop.
  //
  // rf.isPalindrome("") returns true
  // rf.isPalindrome("X") returns true
  // rf.isPalindrome("racecar") returns true
  // rf.isPalindrome("abba") returns true
  // rf.isPalindrome("aBba") returns false
  //
  public boolean isPalindrome(String str) {
    // TODO: Complete this method with a recursive algorithm
    return !true;
  }

  ///////////////////////////////////////////////////////////////////////////////
  // Place an underscore between any two characters that are == and next to each
  // other. Use recursion, do not use a loop.
  //
  // rf.underScore("xxyy")) returns x_xy_y
  // rf.underScore("abc")) returns abc
  // rf.underScore("hello")) returns "hel_lo"
  // rf.underScore("aaaa") returns "a_a_a_a"
  //
  public String underScore(String str) {
    // TODO: Complete this method with a recursive algorithm
    return "Under construction";
  }

  ///////////////////////////////////////////////////////////////////////////////
  // Return the number of times the character ch exists in the given string.
  // Use recursion, do not use a loop.
  //
  // assertEquals(0, rf.howMany('X', "abcde"));
  // assertEquals(1, rf.howMany('a', "abcde"));
  // assertEquals(3, rf.howMany('a', "abacdea"));
  // assertEquals(3, rf.howMany('C', "CCC"));
  //
  public int howMany(char ch, String str) {
    // TODO: Complete this method with a recursive algorithm.
    return -1;
  }

  ///////////////////////////////////////////////////////////////////////////////
  // Return the number of times a pair occurs in a string
  // A pair is any two character values that are equal in consecutive
  //
  // rf.numberOfPairs("") returns 0
  // rf.numberOfPairs("a") returns 0
  // rf.numberOfPairs("aaa") returns 2
  // rf.numberOfPairs("ababa") returns 0
  // rf.numberOfPairs("aabbbaa") returns 4
  //
  //
  public int numberOfPairs(String str) {
    // TODO: Complete this method with a recursive algorithm.
    return -1;
  }

  ///////////////////////////////////////////////////////////////////////////
  /////// array processing where private helper methods are required ////////
  ///////////////////////////////////////////////////////////////////////////

  ///////////////////////////////////////////////////////////////////////////////
  // Complete recursive method reverseArray that reverses the array elements
  // in a filled array of ints. Use recursion, do not use a loop.
  //
  // int[] a = { 2, 4, 6 };
  // rf.reverseArray(a);
  // assertEquals(6, a[0]);
  // assertEquals(4, a[1]);
  // assertEquals(2, a[2]);
  //
  // You'll need a private helper method.
  //
  // Precondition: x.length > 0
  //
  public void reverseArray(int[] x) {
    // TODO: Complete this method by calling a private helper method
    // that is needed because we are not given the index of where to begin.
  }

  ///////////////////////////////////////////////////////////////////////////////
  // Write recursive method arrayRange that returns the maximum integer minus
  // the minimum integer in the filled array of ints. Use recursion; do not
  // use a loop. The following assertions must pass (note the shortcut way to
  // pass a reference to a new array--it saves your writing a bit of code:
  //
  // assertEquals(2, rf.arrayRange(new int[] { 1, 2, 3 }));
  // assertEquals(2, rf.arrayRange(new int[] { 3, 2, 1 }));
  // assertEquals(0, rf.arrayRange(new int[] { 3 }));
  // assertEquals(3, rf.arrayRange(new int[] { -3, -2, -5, -4 }));
  //
  // You'll need two private helper methods
  //
  // Precondition: a.length > 0
  //
  public int arrayRange(int[] a) {
    // TODO: Complete this method by calling a private helper method
    // that is needed because we are not given the index of where to begin.
    return -999;
  }

  ///////////////////////////////////////////////////////////////////////////////
  // Return true if nums has all int elements in ascending order.
  // If not sorted, return false. You'll need a private helper method.
  //
  public boolean isSorted(int[] nums) {
    // TODO: Complete this method by calling a private helper method
    // that is needed because we are not given the index of where to begin.
    return !true;
  }

  ///////////////////////////////////////////////////////////////////////////////
  // Complete method found to return true if search is found in strs.
  // If not found, return false. You will need a private helper method
  public boolean found(String search, String[] strs) {
    // TODO: Complete this method by calling a private helper method
    // that is needed because we are not given the index of where to begin.
    return !false;
  }

  ///////////////////////////////////////////////////////////////////////////////
  // Modify an array that contains the exact same numbers as the given array
  // but rearranged so that all the even numbers come before all the odd numbers.
  // Other than that, the numbers can be in any order.
  //
  // evenOdd({1, 0, 1, 0, 1}) modifies the argument to nums to {0, 0, 1, 1, 1}
  // evenOdd({3, 3, 2}) modifies modifies the argument to nums to {2, 3, 3}
  // evenOdd({2, 2, 2}) modifies modifies the argument to nums to {2, 2, 2}
  //
  public void evenOdd(int[] nums) {
    // TODO: Complete this method by calling a private helper method
    // that is needed because we are not given the index of where to begin.
  }

}