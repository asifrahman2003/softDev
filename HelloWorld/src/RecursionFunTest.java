import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RecursionFunTest {

  @Test
  public void testCombinations() {
    RecursionFun rf = new RecursionFun();
    assertEquals(5, rf.combinations(5, 1));
    assertEquals(1, rf.combinations(5, 5));
    assertEquals(2598960, rf.combinations(52, 5));
  }

  @Test
  public void testFactorial() {
    RecursionFun rf = new RecursionFun();
    assertEquals(1, rf.factorial(0));
    assertEquals(1, rf.factorial(1));
    assertEquals(2, rf.factorial(2));
    assertEquals(120, rf.factorial(5));
  }

  @Test
  public void testIsPalindrome() {
    RecursionFun rf = new RecursionFun();
    assertTrue(rf.isPalindrome(""));
    assertTrue(rf.isPalindrome("X"));
    assertTrue(rf.isPalindrome("racecar"));
    assertTrue(rf.isPalindrome("abba"));
    assertFalse(rf.isPalindrome("aBba"));
  }

  @Test
  public void testUnderScore() {
    RecursionFun rf = new RecursionFun();
    assertEquals("x_xy_y", rf.underScore("xxyy"));
    assertEquals("abc", rf.underScore("abc"));
    assertEquals("hel_lo", rf.underScore("hello"));
    assertEquals("a_a_a_a", rf.underScore("aaaa"));
  }

  @Test
  public void testHowMany() {
    RecursionFun rf = new RecursionFun();
    assertEquals(0, rf.howMany('X', "abcde"));
    assertEquals(1, rf.howMany('a', "abcde"));
    assertEquals(3, rf.howMany('a', "abacdea"));
    assertEquals(3, rf.howMany('C', "CCC"));
  }

  @Test
  public void testNumberOfPairs() {
    RecursionFun rf = new RecursionFun();
    assertEquals(0, rf.numberOfPairs(""));
    assertEquals(0, rf.numberOfPairs("a"));
    assertEquals(2, rf.numberOfPairs("aaa"));
    assertEquals(0, rf.numberOfPairs("ababa"));
    assertEquals(4, rf.numberOfPairs("aabbbaa"));
  }

  @Test
  public void testReverseArray() {
    RecursionFun rf = new RecursionFun();
    int[] a = {2, 4, 6};
    rf.reverseArray(a);
    assertArrayEquals(new int[]{6, 4, 2}, a);
  }

  @Test
  public void testArrayRange() {
    RecursionFun rf = new RecursionFun();
    assertEquals(2, rf.arrayRange(new int[]{1, 2, 3}));
    assertEquals(2, rf.arrayRange(new int[]{3, 2, 1}));
    assertEquals(0, rf.arrayRange(new int[]{3}));
    assertEquals(3, rf.arrayRange(new int[]{-3, -2, -5, -4}));
  }
  
  @Test
  public void testIsSorted() {
    RecursionFun rf = new RecursionFun();
    int[] sorted = {1, 2, 3, 4, 5};
    int[] unsorted = {1, 3, 2, 5, 4};
    int[] empty = {};
    
    assertTrue(rf.isSorted(sorted));
    assertFalse(rf.isSorted(unsorted));
    assertTrue(rf.isSorted(empty));
  }

  @Test
  public void testFound() {
    RecursionFun rf = new RecursionFun();
    String[] strs = {"apple", "banana", "cherry", "date"};
    String search1 = "banana";
    String search2 = "grape";

    assertTrue(rf.found(search1, strs));
    assertFalse(rf.found(search2, strs));
  }

  @Test
  public void testEvenOdd() {
    RecursionFun rf = new RecursionFun();
    int[] nums1 = {1, 0, 1, 0, 1};
    int[] nums2 = {3, 3, 2};
    int[] nums3 = {2, 2, 2};

    rf.evenOdd(nums1);
    rf.evenOdd(nums2);
    rf.evenOdd(nums3);

    assertArrayEquals(new int[]{0, 0, 1, 1, 1}, nums1);
    assertArrayEquals(new int[]{2, 3, 3}, nums2);
    assertArrayEquals(new int[]{2, 2, 2}, nums3);
  }
}
