import java.util.Scanner;

public class MidTerm1 {

	// Question 1
	public boolean equallyDifferent(int a, int b, int c) {
		if (a > b) {
			int temporary = b;
			b = a;
			a = temporary;
		}
		if (b > c) {
			int temporary = c;
			c = b;
			b = temporary;
		}
		if (a > b) {
			int temporary = b;
			b = a;
			a = temporary;
		}
		return (b - a) == (c - b);
	}

	// Question 2
	public int totalEes(Scanner scanner) {
		int count = 0;
		while (scanner.hasNextLine()) {
			String str = scanner.nextLine();
			int characterIndex = 0;
			while (characterIndex < str.length()) {
				char character = str.charAt(characterIndex);
				if (Character.toLowerCase(character) == 'e') {
					count++;
				}
				characterIndex++;
			}
		}
		return count;
	}

	// Question 4
	public int runs(char[] array) {
		int count = 0;
		for (int index = 0; index < array.length - 1; index++) {
			if (array[index] == array[index + 1]) {
				count++;
				while (index < array.length - 1 && array[index] == array[index + 1]) {
					index++;
				}
			}
		}
		return count;
	}

	// Question 3
	public String outside_in(String str) {
		String reversedString = "";
		int reversedIndex = str.length() - 1;
		while (reversedIndex >= 0) {
			reversedString += str.charAt(reversedIndex);
			reversedIndex--;
		}

		int maximumPrefixLength = 0;
		String longestCommonPrefix = "";
		int index = 0;
		while (index < str.length()) {
			for (int j = index; j <= str.length(); j++) {
				String prefixA = str.substring(0, j);
				String prefixB = reversedString.substring(0, j);

				if (prefixA.equals(prefixB) && j > maximumPrefixLength) {
					maximumPrefixLength = j;
					longestCommonPrefix = prefixA;
				}
			}
			index++;
		}

		return longestCommonPrefix;
	}
}
