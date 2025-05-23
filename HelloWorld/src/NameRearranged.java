// Muhammad Asifur Rahman
// This program takes input in the format "First I Last" and rearranges it to "Last, First I."
// It achieves this by utilizing the Scanner class to obtain user input and then
// processing the input string to extract the first name, middle initial, and last name.

import java.util.Scanner;

public class NameRearranged {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// Input
		System.out.print("Enter a name in the form of 'First I Last': ");
		String name = keyboard.nextLine();
		keyboard.close();

		// Process
		int firstSpace = name.indexOf(" ");
		int lastSpace = name.lastIndexOf(" ");

		String firstName = name.substring(0, firstSpace);
		String middleName = name.substring(firstSpace + 1, lastSpace);
		String lastName = name.substring(lastSpace + 1);

		String nameFinal = lastName + ", " + firstName + " " + middleName + ".";

		// Output
		System.out.println(nameFinal);

	}

}
