import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import static java.lang.System.exit;

public class

TextEditor extends Frame implements ActionListener {

    private MenuBar menuBar;
    private Menu fileMenu;
    private MenuItem newMenuItem, openMenuItem, saveMenuItem, exitMenuItem;
    private TextField fileNameTextField;
    private TextArea textArea;

    public TextEditor() {
        super("Text Editor");

        // Create the menu bar
        menuBar = new MenuBar();
        fileMenu = new Menu("File");
        newMenuItem = new MenuItem("New");
        openMenuItem = new MenuItem("Open");
        saveMenuItem = new MenuItem("Save");
        exitMenuItem = new MenuItem("Exit");

        // Add action listeners to the menu items
        newMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);

        // Add the menu items to the menu
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        // Add the menu to the menu bar
        menuBar.add(fileMenu);

        // Set the menu bar for the frame
        setMenuBar(menuBar);

        // Create the text field and text area
        fileNameTextField = new TextField(20);
        textArea = new TextArea();

        // Create a panel to hold the text field and text area
        Panel panel = new Panel(new BorderLayout());
        panel.add(fileNameTextField, BorderLayout.SOUTH);
        panel.add(textArea, BorderLayout.CENTER);

        // Add the panel to the frame
        add(panel);

        // Pack the frame
        pack();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose();
                exit(0);
            }
        });
        // Show the frame
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        MenuItem menuItem = (MenuItem) e.getSource();

        if (menuItem == newMenuItem) {
            // Clear the text field and text area
            fileNameTextField.setText("");
            textArea.setText("");
        } else if (menuItem == openMenuItem) {
            // Open the file and display its contents in the text area
            String fileName = fileNameTextField.getText();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                reader.close();
            } catch (FileNotFoundException exception) {
               JOptionPane.showMessageDialog(this, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException exception) {
                JOptionPane.showMessageDialog(this, "Error reading file", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (menuItem == saveMenuItem) {
            // Save the contents of the text area to the file
            String fileName = fileNameTextField.getText();
            try {
                PrintWriter writer = new PrintWriter(new FileWriter(fileName));
                writer.print(textArea.getText());
                writer.close();
            } catch (IOException exception) {
                JOptionPane.showMessageDialog(this, "Error saving file", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (menuItem == exitMenuItem) {
            // Terminate the application
            exit(0);
        }
    }

    public static void main(String[] args) {
        new TextEditor();
    }
}