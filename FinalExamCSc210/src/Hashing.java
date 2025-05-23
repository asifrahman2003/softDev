import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Hashing {
	public static void main(String[] args) throws FileNotFoundException {
		HashMap<String, ArrayList<String>> coursesList = new HashMap<>();

		Scanner inputFile = new Scanner(new File("students.txt"));

		while (inputFile.hasNext()) {
			String courseName = inputFile.next();
			String studentName = inputFile.next();
			coursesList.computeIfAbsent(courseName, k -> new ArrayList<>()).add(studentName);
		}
		System.out.println("CSC335: " + coursesList.getOrDefault("CSC335", null));
		System.out.println("Eng101: " + coursesList.getOrDefault("Eng101", null));
		System.out.println("Math141: " + coursesList.getOrDefault("Math141", null));
		System.out.println("CSC210: " + coursesList.getOrDefault("CSC210", null));
	}
}
