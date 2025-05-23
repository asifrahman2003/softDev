import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.json.*;

public class ExpenseTrackerApp extends JFrame implements ActionListener {
    private JTextField expenseField;
    private JButton addButton;
    private JTextArea expenseList;

    public ExpenseTrackerApp() {
        setTitle("Expense Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        expenseField = new JTextField(20);
        addButton = new JButton("Add Expense");
        expenseList = new JTextArea(10, 30);

        addButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(expenseField);
        panel.add(addButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(expenseList), BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String expense = expenseField.getText();
            addExpense(expense);
        }
    }

    private void addExpense(String expense) {
        // Add expense logic here (e.g., store in a data structure, update UI)
        expenseList.append(expense + "\n");

        // Example of using ChatGPT API
        String advice = getFinancialAdvice(expense);
        expenseList.append("Financial Advice: " + advice + "\n");
    }

    private String getFinancialAdvice(String expense) {
        try {
            String apiKey = "YOUR_API_KEY";
            String apiUrl = "https://api.openai.com/v1/chat/completions";

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String postData = "{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"system\", \"content\": \"You are a helpful assistant that provides financial advice.\"}, {\"role\": \"user\", \"content\": \"" + expense + "\"}]}";

            OutputStream os = connection.getOutputStream();
            os.write(postData.getBytes());

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();

            JSONObject response = new JSONObject(content.toString());
            JSONArray choices = response.getJSONArray("choices");
            JSONObject message = choices.getJSONObject(0).getJSONObject("message");
            return message.getString("content");

        } catch (Exception e) {
            e.printStackTrace();
            return "Error retrieving advice.";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ExpenseTrackerApp app = new ExpenseTrackerApp();
            app.setVisible(true);
        });
    }
}
