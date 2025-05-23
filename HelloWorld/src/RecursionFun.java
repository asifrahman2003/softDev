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
 * use a loop instead of recursion even though your method works.
 *
 * @author Rick Mercer and Muhammad Asifur Rahman
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
		if (k == 0 || k == n) {
			return 1;
		} else {
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
		}
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
		if (n == 0 || n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
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
		if (str.length() <= 1) {
			return true;
		} else if (str.charAt(0) == str.charAt(str.length() - 1)) {
			return isPalindrome(str.substring(1, str.length() - 1));
		} else {
			return false;
		}
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
		if (str.length() <= 1) {
			return str;
		} else if (str.charAt(0) == str.charAt(1)) {
			return str.charAt(0) + "_" + underScore(str.substring(1));
		} else {
			return str.charAt(0) + underScore(str.substring(1));
		}
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
		if (str.isEmpty()) {
			return 0;
		} else {
			if (str.charAt(0) == ch) {
				return 1 + howMany(ch, str.substring(1));
			} else {
				return howMany(ch, str.substring(1));
			}
		}
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
		if (str.length() < 2) {
			return 0;
		} else {
			if (str.charAt(0) == str.charAt(1)) {
				return 1 + numberOfPairs(str.substring(1));
			} else {
				return numberOfPairs(str.substring(1));
			}
		}
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
		reverseArray(x, 0, x.length - 1);
	}

	private void reverseArray(int[] x, int start, int end) {
		if (start < end) {
			int temporary = x[start];
			x[start] = x[end];
			x[end] = temporary;
			reverseArray(x, start + 1, end - 1);
		}
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
		return arrayRange(a, 0, a[0], a[0]);
	}

	private int arrayRange(int[] a, int i, int max, int min) {
		if (i == a.length) {
			return max - min;
		}
		int temporary = a[i];
		max = Math.max(max, temporary);
		min = Math.min(min, temporary);
		return arrayRange(a, i + 1, max, min);
	}

	///////////////////////////////////////////////////////////////////////////////
	// Return true if nums has all int elements in ascending order.
	// If not sorted, return false. You'll need a private helper method.
	//
	public boolean isSorted(int[] nums) {
		return isSorted(nums, 0, nums.length - 1);
	}

	private boolean isSorted(int[] nums, int start, int end) {
		if (start >= end) {
			return true;
		} else if (nums[start] > nums[start + 1]) {
			return false;
		} else {
			return isSorted(nums, start + 1, end);
		}
	}

	///////////////////////////////////////////////////////////////////////////////
	// Complete method found to return true if search is found in strs.
	// If not found, return false. You will need a private helper method
	public boolean found(String search, String[] strs) {
		return found(search, strs, 0);
	}

	private boolean found(String search, String[] strs, int index) {
		if (index < 0 || index >= strs.length) {
			return false;
		} else {
			return strs[index].equals(search) || found(search, strs, index + 1);
		}
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
		evenOdd(nums, 0, 0);
	}

	private void evenOdd(int[] nums, int left, int right) {
		if (left == nums.length) {
			return;
		}
		if (nums[left] % 2 == 0) {
			int temporary = nums[left];
			nums[left] = nums[right];
			nums[right] = temporary;
			right++;
		}
		evenOdd(nums, left + 1, right);
	}

}