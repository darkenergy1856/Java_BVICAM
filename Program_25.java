//Write a Java program to open a file and display the contents in the console window.

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import java.util.Scanner;

public class Program_25  extends Frame {


    Button openFile = new Button("Open File");
    Label emptyLabel = new Label();

    Label fileLocation = new Label("File Location : ");


    public Program_25(String title){
        super(title);
        setResizable(true);
        emptyLabel.setPreferredSize(new Dimension(30000,1));
        FileDialog dialog = new FileDialog (this, "Choose File", FileDialog.LOAD);
        setLayout(new FlowLayout());
        setSize(400 , 200);
        setVisible(true);
        openFile.addActionListener(e -> {
            dialog.setVisible (true);
            fileLocation.setText("File Location : " + dialog.getDirectory() + dialog.getFile());
            try {
                File file = new File(dialog.getDirectory() + dialog.getFile());
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()){
                    System.out.println(fileScanner.nextLine());
                }
            }catch (Exception f){
                System.out.println("Unable to access file location");
            }
        });
        add(fileLocation , FlowLayout.LEFT);
        add(emptyLabel);
        add(openFile);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new Program_25("Program_25");
    }
}
