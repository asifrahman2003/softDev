//Muhammad Asifur Rahman

// The purpose of the program is to calculate and display the time
// difference between two train departure times. The program reads
// two train departure times (in the format HHMM, where HH represents
// hours and MM represents minutes) from the user, calculates the
// difference in hours and minutes between these times, and then
// outputs the calculated difference.

import java.util.Scanner;

public class TrainDepartures {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// Input
		System.out.print("Train A departs at: ");
		int trainA = keyboard.nextInt();
		System.out.print("Train B departs at: ");
		int trainB = keyboard.nextInt();
		keyboard.close();

		// Process
		int hourA = trainA / 100;
		int minuteA = trainA % 100;
		int hourB = trainB / 100;
		int minuteB = trainB % 100;

		int hourDifference = Math.abs(hourA - hourB);
		int minuteDifference = Math.abs(minuteA - minuteB);

		if (minuteA < minuteB) {
			hourDifference--;
			minuteDifference = 60 - minuteDifference;
		}

		// Output
		System.out.println("\nDifference: " + hourDifference + " hours and " + minuteDifference + " minutes");

	}

}
