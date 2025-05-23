import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CashRegisterGUI extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	private TextField textFieldForQuantity = new TextField();
	private TextField textFieldForPrice = new TextField();
	private GridPane gridPane = new GridPane();
	private Label labelForSubTotal = new Label("0.00");
	private double subTotalLabel = 0;

	@Override
	public void start(Stage stage) {
		createGridPane();

		Scene prompt = new Scene(gridPane, 280, 110);
		stage.setScene(prompt);
		stage.show();
	}

	private void createGridPane() {
		gridPane.setHgap(20);
		gridPane.setVgap(10);

		Label quantityText = new Label("Quantity");
		Label priceText = new Label("Price");
		Label subTotalText = new Label("Sub Total");

		gridPane.add(quantityText, 1, 1);
		gridPane.add(priceText, 1, 2);
		gridPane.add(subTotalText, 1, 3);
		gridPane.add(textFieldForQuantity, 2, 1);
		gridPane.add(textFieldForPrice, 2, 2);
		gridPane.add(labelForSubTotal, 2, 3);

		textFieldForPrice.setOnAction(e -> calculateAndOutput());
	}

	private void calculateAndOutput() {
		try {
			double quantityText = Double.parseDouble(textFieldForQuantity.getText());
			double priceText = Double.parseDouble(textFieldForPrice.getText());
			subTotalLabel += quantityText * priceText;
			labelForSubTotal.setText("" + subTotalLabel);
		} catch (NumberFormatException e) {
			System.out.println("Please enter valid numeric values for Quantity and Price.");
		}
	}
}