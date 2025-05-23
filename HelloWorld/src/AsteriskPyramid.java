/*-
 *  Author Name: Muhammad Asifur Rahman
 *  Course: CSc 210 (Quiz 2)
 *  Program purpose: With the help of two for loops this program
 *  		prints out a pyramid of asterisks on the console that
 * 			is consisted of 8 rows.
 */

public class AsteriskPyramid {

	public static void main(String[] args) {
		int rows = 8;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= 2 * i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}