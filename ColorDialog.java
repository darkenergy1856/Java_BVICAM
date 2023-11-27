import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.lang.System.exit;

public class ColorDialog extends JDialog implements ActionListener {

    private JTextField rField, gField, bField;
    private JButton testButton, okButton, cancelButton;
    private JLabel testLabel;
    private Color color;

    public ColorDialog(Frame parent, String title, boolean modal) {
        super(parent, title, modal);

        setSize(300, 200);
        setLayout(new GridLayout(5, 2, 10, 10));

        rField = new JTextField();
        gField = new JTextField();
        bField = new JTextField();
        testButton = new JButton("Test");
        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");
        testLabel = new JLabel("Test Color");
        testLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(new JLabel("R:"));
        add(rField);
        add(new JLabel("G:"));
        add(gField);
        add(new JLabel("B:"));
        add(bField);
        add(testButton);
        add(okButton);
        add(cancelButton);
        add(testLabel);
        testButton.addActionListener(this);
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        color = Color.WHITE;
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == testButton) {
            try {
                int r = Integer.parseInt(rField.getText());
                int g = Integer.parseInt(gField.getText());
                int b = Integer.parseInt(bField.getText());
                if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
                    throw new NumberFormatException();
                }
                Color newColor = new Color(r, g, b);
                testLabel.setBackground(newColor);
                testLabel.setForeground(new Color(255 - r, 255 - g, 255 - b));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid RGB values. Please enter numbers in the range 0-255.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (source == okButton) {
            color = testLabel.getBackground();
            dispose();
            exit(0);
        }
        else if (source == cancelButton) {
            dispose();
            exit(0);
        }
    }

    public Color getColor() {
        return color;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        new ColorDialog(frame , "Color Chooser" , true);
    }
}
