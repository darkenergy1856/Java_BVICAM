import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Program_23 extends Frame {
    Label name = new Label("Name");
    Label dateOfJoining = new Label("Date Of Joining");
    Label address = new Label("Address");

    Button display = new Button("Display");

    Button cancel = new Button("Cancel");

    Choice date = new Choice();
    Choice month = new Choice();

    Choice year = new Choice();

    Panel p = new Panel();


    TextField nameTextField = new TextField();
    TextArea addressTextArea = new TextArea();

    public Program_23() {
        for (int i = 1; i <= 31; i++) {
            date.add("" + i);
        }

        for (int i = 1900; i <= 3000; i++) {
            year.add("" + i);
        }

        month.add("January");
        month.add("February");
        month.add("March");
        month.add("April");
        month.add("May");
        month.add("June");
        month.add("July");
        month.add("August");
        month.add("September");
        month.add("October");
        month.add("November");
        month.add("December");

        setLayout(new GridLayout(4, 2));
        setSize(500, 200);
        p.setLayout(new FlowLayout());
        p.add(date);
        p.add(month);
        p.add(year);


        add(name, Label.LEFT);
        add(nameTextField);
        add(dateOfJoining);
        add(p);
        add(address);
        add(addressTextArea);
        add(display);
        add(cancel);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addressTextArea.setText("");
                nameTextField.setText("");
            }
        });

        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Label name = new Label("Name : " + nameTextField.getText());
                Label address = new Label("Address : " + addressTextArea.getText());
                Label dateLabel = new Label("Date Of Joining : " + date.getItem(date.getSelectedIndex()) + " " + month.getItem(month.getSelectedIndex()) + " " + year.getItem(year.getSelectedIndex()));
                Frame temp = new Frame();
                temp.setTitle("Display");
                temp.setSize(500, 200);
                temp.setLayout(new GridLayout(3, 1));
                temp.add(name);
                temp.add(address);
                temp.add(dateLabel);
                temp.setVisible(true);
                temp.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosed(e);
                        temp.dispose();
                    }
                });
            }
        });
        setTitle("Program_23");
        setVisible(true);


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose();
            }
        });


    }

    public static void main(String[] args) {
        new Program_23();
    }


}
