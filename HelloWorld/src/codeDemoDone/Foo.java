package codeDemoDone;

public class Foo {
	public boolean foo(int[] arr, int target) {
	    Boolean[] memo = new Boolean[arr.length];
	    return fooRecursive(arr, target, 0, memo);
	}

	public boolean fooRecursive(int[] arr, int target, int index, Boolean[] memo) {
	    if (target == 0) {
	        return true;
	    }

	    if (index >= arr.length) {
	        return false;
	    }

	    if (memo[index] != null) {
	        return memo[index];
	    }

	    boolean include = fooRecursive(arr, target - arr[index], index + 1, memo);
	    boolean exclude = fooRecursive(arr, target, index + 1, memo);

	    memo[index] = include || exclude;
	    return memo[index];
	}
}
