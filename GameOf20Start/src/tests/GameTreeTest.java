package tests;

/*
 * A unit test for class GameTree in the Game of 20 questions project.
 *
 * This class contains three methods to get you started and to explain some behavior.
 *
 * @BeforeClass public static void setUp() throws FileNotFoundException
 * 
 * This setUp() method contains code that write a new file at the beginning so that 
 * the file always will start with the same exact questions and answers.
 *
 * @author Rick Mercer and Muhammad Asifur Rahman
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import model.Choice;
import model.GameTree;

public class GameTreeTest {

	@BeforeClass
	public static void restoreFile() {
// 
		/*- Always make sure the input file has the same questions and answers.
		Has feathers?
		Barnyard?
		chicken
		owl
		Is it a mammal?
		tiger
		rattlesnake
		*/
		PrintWriter outFile = null;
		try {
			outFile = new PrintWriter(new FileOutputStream("animals.txt"));

			outFile.println("Has feathers?");
			outFile.println("Barnyard?");
			outFile.println("chicken");
			outFile.println("owl");
			outFile.println("Is it a mammal?");
			outFile.println("tiger");
			outFile.println("rattlesnake");
			outFile.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("--- ERROR: file restoration failed! ---");
		}
	}

	@Test
	public void testGameWith7() {
		GameTree aGame = new GameTree("animals.txt");
		// Go to the left
		System.out.println(aGame.toString());
		assertEquals("Has feathers?", aGame.getCurrent());
		assertFalse(aGame.foundAnswer());
		aGame.playerSelected(Choice.YES);
		assertEquals("Barnyard?", aGame.getCurrent());
		assertFalse(aGame.foundAnswer());
		aGame.playerSelected(Choice.YES);
		assertEquals("chicken", aGame.getCurrent());
		assertTrue(aGame.foundAnswer());

		aGame.reStart();
		// Go to the right
		assertEquals("Has feathers?", aGame.getCurrent());
		assertFalse(aGame.foundAnswer());
		aGame.playerSelected(Choice.NO);
		assertEquals("Is it a mammal?", aGame.getCurrent());
		aGame.playerSelected(Choice.NO);
		assertEquals("rattlesnake", aGame.getCurrent());
		assertTrue(aGame.foundAnswer());
	}

	// TODO" Add more @Tests
	@Test
	public void testAddingNewQuestion() {
		GameTree aGame = new GameTree("animals.txt");

		// Go to the left
		assertEquals("Has feathers?", aGame.getCurrent());
		assertFalse(aGame.foundAnswer());
		aGame.playerSelected(Choice.YES);
		assertEquals("Barnyard?", aGame.getCurrent());
		assertFalse(aGame.foundAnswer());
		aGame.playerSelected(Choice.YES);
		assertEquals("chicken", aGame.getCurrent());
		assertTrue(aGame.foundAnswer());

		aGame.reStart();

		// Go to the right
		assertEquals("Has feathers?", aGame.getCurrent());
		assertFalse(aGame.foundAnswer());
		aGame.playerSelected(Choice.NO);
		assertEquals("Is it a mammal?", aGame.getCurrent());
		aGame.playerSelected(Choice.NO);
		assertEquals("rattlesnake", aGame.getCurrent());
		assertTrue(aGame.foundAnswer());

		// Add new question and answer
		aGame.add("Does it swim?", "duck");

		// Reset and go to the left again
		aGame.reStart();
		assertEquals("Has feathers?", aGame.getCurrent());
		assertFalse(aGame.foundAnswer());
		aGame.playerSelected(Choice.YES);
		assertEquals("Barnyard?", aGame.getCurrent());
		assertFalse(aGame.foundAnswer());
		aGame.playerSelected(Choice.YES);
		assertEquals("chicken", aGame.getCurrent());
		assertTrue(aGame.foundAnswer());
	}
}