// Muhammad Asifur Rahman
// This program is designed to build a random number guessing game.
// At the start of the game, the computer generates a random number. 
// Which everytime the user has to input a guess number wihtin 1 to 100.
// At the end the program will let the user know about the correct number and
// will output the number of guesses that was needed.

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {
		// Random number generation
		Random numberGenerator = new Random();
		int randomNumber = numberGenerator.nextInt(100) + 1;
		int countOfTries = 1;
		// Input
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a number from 1 through 100: ");
		int guessedNumber = keyboard.nextInt();
		// Process
		while (randomNumber != guessedNumber) {
			if (guessedNumber > randomNumber)
				System.out.println(guessedNumber + " is too large");
			else if (guessedNumber < randomNumber)
				System.out.println(guessedNumber + " is too small");
			System.out.print("Enter a number from 1 through 100: ");
			guessedNumber = keyboard.nextInt();
			countOfTries += 1;
		}
		// Output
		System.out.println(guessedNumber + " is just right");
		// Printing the new line after the rightly guessed number.
		System.out.println("\n");
		System.out.println("You got it in " + countOfTries + " guesses");
		keyboard.close();
	}

}
