// Calculator.java
import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    private TextField tfDisplay;
    private Button btnClear, btnEqual, btnAdd, btnSub, btnMul, btnDiv ;
    private Button[] btnDigits;
    private Panel panel;


    private double operand1, operand2;
    private char operator;


    public Calculator() {

        super("Calculator");

        setLayout(new BorderLayout());

        tfDisplay = new TextField("0", 20);
        tfDisplay.setEditable(false);

        add(tfDisplay, BorderLayout.NORTH);

        panel = new Panel(new GridLayout(4, 4));

        btnDigits = new Button[10];
        for (int i = 0; i < 10; i++) {
            btnDigits[i] = new Button(String.valueOf(i));
            panel.add(btnDigits[i]);

            btnDigits[i].addActionListener(this);
        }
        btnClear = new Button("C");
        btnEqual = new Button("=");
        btnAdd = new Button("+");
        btnSub = new Button("-");
        btnMul = new Button("*");
        btnDiv = new Button("/");
        panel.add(btnClear);
        panel.add(btnEqual);
        panel.add(btnAdd);
        panel.add(btnSub);
        panel.add(btnMul);
        panel.add(btnDiv);
        btnClear.addActionListener(this);
        btnEqual.addActionListener(this);
        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        operand1 = 0.0;
        operand2 = 0.0;
        operator = ' ';
        setSize(300, 300);
        setVisible(true);
    }

    // Implement the actionPerformed method of the ActionListener interface
    public void actionPerformed(ActionEvent e) {
        // Get the source of the action event
        Object source = e.getSource();
        // Declare a variable to store the display text
        String displayText = tfDisplay.getText();
        // Check if the source is a digit button
        if (source instanceof Button) {
            // Cast the source to a button
            Button btn = (Button) source;
            // Get the label of the button
            String label = btn.getLabel();
            // Try to parse the label as an integer
            try {
                int digit = Integer.parseInt(label);
                // If the display text is zero, replace it with the digit
                if (displayText.equals("0")) {
                    displayText = label;
                } else {
                    // Otherwise, append the digit to the display text
                    displayText += label;
                }
                // Set the text of the text field to the display text
                tfDisplay.setText(displayText);
            } catch (NumberFormatException ex) {
                // If the label is not a digit, check which operation button it is
                switch (label) {
                    // Case C: Clear the display text and the operands
                    case "C":
                        displayText = "0";
                        operand1 = 0.0;
                        operand2 = 0.0;
                        operator = ' ';
                        break;
                    // Case =: Perform the calculation based on the operator and the operands
                    case "=":
                        // Parse the display text as the second operand
                        operand2 = Double.parseDouble(displayText);
                        // Declare a variable to store the result
                        double result = 0.0;
                        // Check which operator is selected
                        switch (operator) {
                            // Case +: Add the operands
                            case '+':
                                result = operand1 + operand2;
                                break;
                            // Case -: Subtract the operands
                            case '-':
                                result = operand1 - operand2;
                                break;
                            // Case *: Multiply the operands
                            case '*':
                                result = operand1 * operand2;
                                break;
                            // Case /: Divide the operands
                            case '/':
                                // Check if the second operand is zero
                                if (operand2 == 0.0) {
                                    // If yes, display an error message
                                    displayText = "Error: Division by zero";
                                    // Set the text of the text field to the display text
                                    tfDisplay.setText(displayText);
                                    // Return from the method
                                    return;
                                } else {
                                    // If no, perform the division
                                    result = operand1 / operand2;
                                }
                                break;
                            // Default: No operator selected
                            default:
                                // Display an error message
                                displayText = "Error: Invalid operator";
                                // Set the text of the text field to the display text
                                tfDisplay.setText(displayText);
                                // Return from the method
                                return;
                        }
                        // Format the result as a string with two decimal places
                        displayText = String.format("%.2f", result);
                        // Set the text of the text field to the display text
                        tfDisplay.setText(displayText);
                        // Reset the operands and the operator
                        operand1 = 0.0;
                        operand2 = 0.0;
                        operator = ' ';
                        break;
                    // Case +, -, *, /: Set the operator and the first operand
                    default:
                        // Parse the display text as the first operand
                        operand1 = Double.parseDouble(displayText);
                        // Set the operator to the label
                        operator = label.charAt(0);
                        // Reset the display text to zero
                        displayText = "0";
                        // Set the text of the text field to the display text
                        tfDisplay.setText(displayText);
                        break;
                }
            }
        }
    }

    // Define the main method
    public static void main(String[] args) {
        // Create a new instance of Calculator
        Calculator calc = new Calculator();
        // Add a window listener to the frame to handle the window closing event
        calc.addWindowListener(new WindowAdapter() {
            // Override the windowClosing method to exit the program
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
