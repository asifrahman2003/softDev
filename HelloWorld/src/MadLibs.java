// Muhammad Asifur Rahman
// This program follows the Mad Libs game structure, where it prompts users for various inputs and then constructs a
// story using those inputs. The program effectively utilizes the Scanner class to obtain user input for a year, 
// spaceship name, galaxy name, adjective, and skill. It then combines these inputs to generate a unique story about
// astronauts exploring space. 

import java.util.Scanner;

public class MadLibs {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// Input
		System.out.print("A year: ");
		String year = keyboard.nextLine();

		System.out.print("A Spaceship name: ");
		String spaceShip = keyboard.nextLine();

		System.out.print("A Galaxy name: ");
		String galaxy = keyboard.nextLine();

		System.out.print("An adjective: ");
		String adjective = keyboard.nextLine();

		System.out.print("A skill: ");
		String skill = keyboard.nextLine();
		keyboard.close();

		// Process
		String story = "In the year " + year + ", aboard the spaceship " + spaceShip
				+ ", a crew of astronauts embarks on a mission to explore the far reaches of space. As they travel through "
				+ galaxy + ", they encounter a " + adjective + " alien species and must use their " + skill
				+ " skills to establish peaceful communication.";

		// Output
		System.out.println(story);

	}

}
