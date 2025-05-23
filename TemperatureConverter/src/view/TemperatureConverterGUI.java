/*
 * TemperatureConverterGUI class for the JavaFX GUI.
 * Provides a graphical interface for temperature conversion.
 * @author Rick Mercer and Muhammad Asifur Rahman
 */

package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.TemperatureConverter;

public class TemperatureConverterGUI extends Application {
	private TextField celsiusTextField;
	private TextField fahrenheitTextField;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("CtoF FtoC");

		GridPane gridPane = creatingGridPane();
		Scene applicationPrompt = new Scene(gridPane, 280, 110);

		primaryStage.setScene(applicationPrompt);
		primaryStage.show();
	}

	private GridPane creatingGridPane() {
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(10, 10, 10, 10));

		addTextWithLabel("Celsius", celsiusTextField = createTextField(), gridPane, 0);
		addTextWithLabel("Fahrenheit", fahrenheitTextField = createTextField(), gridPane, 1);

		return gridPane;
	}

	private void addTextWithLabel(String labelText, TextField textField, GridPane gridPane, int row) {
		Label textLabel = new Label(labelText);
		textField.setOnAction(e -> {
			if (!textField.getText().isEmpty()) {
				handleTempConversion(textField, row == 0);
			}
		});

		gridPane.add(textLabel, 0, row);
		gridPane.add(textField, 1, row);
	}

	private TextField createTextField() {
		TextField textField = new TextField();
		textField.setOnAction(e -> handleTempConversion(textField, textField == celsiusTextField));
		return textField;
	}

	private void handleTempConversion(TextField sourceTextField, boolean isCelsius) {
		try {
			double userInput = Double.parseDouble(sourceTextField.getText());
			double finalResult = isCelsius ? TemperatureConverter.CtoF(userInput)
					: TemperatureConverter.FtoC(userInput);

			TextField targetTextField = isCelsius ? fahrenheitTextField : celsiusTextField;
			targetTextField.setText(String.format("%.1f", finalResult));
		} catch (NumberFormatException e) {
			sourceTextField.setText("Invalid Input");
		}
	}
}
