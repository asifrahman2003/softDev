import java.util.Random;
import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		Random generator = new Random();
		int num = generator.nextInt(100) + 1;
		Scanner keyboard = new Scanner(System.in);
		int guess;
		int count = 0;

		do {
			System.out.print("Enter a number from 1 through 100: ");
			guess = keyboard.nextInt();
			count++;

			if (guess < num) {
				System.out.println(guess + " is too small");
			} else if (guess > num) {
				System.out.println(guess + " is too large");
			}
		} while (guess != num);

		System.out.println(guess + " is just right");
		System.out.println("You got it in " + count + " guesses");
		keyboard.close();

	}

}

