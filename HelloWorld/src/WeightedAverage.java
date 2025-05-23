// Muhammad Asifur Rahman

// The program takes input for each component's grade, calculates
// the weighted average according to the provided weights, rounds
// the final grade to one decimal place, and then outputs the final
// grade percentage.

import java.util.Scanner;

public class WeightedAverage {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		// Input
		System.out.print("Assignments: ");
		double assignments = keyboard.nextDouble();
		System.out.print("Panopto: ");
		double panopto = keyboard.nextDouble();
		System.out.print("Test 1: ");
		double test1 = keyboard.nextDouble();
		System.out.print("Test 2: ");
		double test2 = keyboard.nextDouble();
		System.out.print("Final: ");
		double finalExam = keyboard.nextDouble();
		keyboard.close();

		// Process
		double courseGrade = (0.45 * assignments) + (0.15 * test1) + (0.15 * test2) + (0.10 * finalExam)
				+ (0.15 * panopto);

		// Rounding to one decimal place
		// double finalGrade= round(courseGrade);

		// Output
		System.out.println("Final Grade Percentage: " + Math.round(courseGrade * 10.0) / 10.0);

	}

}
