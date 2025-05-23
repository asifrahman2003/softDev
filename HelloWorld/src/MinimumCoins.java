// Muhammad Asifur Rahman

// The program takes an input value representing change
// (in the range of 0 to 99 cents), and then calculates
// the minimum number of half dollars, quarters, dimes, nickels,
// and pennies required to make up the given change.

import java.util.Scanner;

public class MinimumCoins {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		// Input
		System.out.print("Enter Change [0..99]: ");
		int change = keyboard.nextInt();
		keyboard.close();

		// Process
		int halfDollars = change / 50;
		change = change % 50;

		int quarterDollars = change / 25;
		change = change % 25;

		int dimeDollars = change / 10;
		change = change % 10;

		int nickelDollars = change / 5;
		change = change % 5;

		int pennyDollars = change / 1;
		change = change % 1;

		// Output
		System.out.println(halfDollars + " Half(ves)");
		System.out.println(quarterDollars + " Quarter(s)");
		System.out.println(dimeDollars + " Dime(s)");
		System.out.println(nickelDollars + " Nickel(s)");
		System.out.println(pennyDollars + " Penny(ies)");

	}

}
