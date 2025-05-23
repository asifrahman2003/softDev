import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.control.Label;

import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

/*

* This is minimal GUI with no events.

*

* @author Rick Mercer

*/

public class FirstFX extends Application {

	public static void main(String[] args) {

		launch(args);

	}

	private Button theButton = new Button("0");

	private Label aLabel = new Label("Click me");

	@Override

	public void start(Stage stage) {

		// The main entry point into this program:

		stage.setTitle("Clicks");

		BorderPane window = new BorderPane();

		Scene scene = new Scene(window, 140, 70);

		window.setTop(aLabel);

		window.setCenter(theButton);

		stage.setScene(scene);

		// Don't forget to show the running app

		stage.show();

	}
}