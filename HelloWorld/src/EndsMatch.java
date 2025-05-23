// Muhammad Asifur Rahman
// This Java program named "EndsMatch" takes a string input and determines whether the first two
// characters of the string are the same as the last two characters. If the string's length is less
// than 2, it outputs false. 

import java.util.Scanner;

public class EndsMatch {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// Input
		System.out.print("Enter a string: ");
		String string = keyboard.nextLine();
		keyboard.close();

		// Process
		boolean output = string.length() >= 2 && string.substring(0, 2).equals(string.substring(string.length() - 2));

		// Output
		System.out.println(output);
		System.out.println((Math.sin(2 * 25) * 90 * 90 / 9.8 * 10) / 10.0);

	}

}
