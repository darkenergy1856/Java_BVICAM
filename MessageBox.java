import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.lang.System.exit;

class MessageBox extends JDialog {

    private boolean okPressed;

    public MessageBox(String message) {
        super((JFrame) null, "Message Box", true);

        JFrame frame = new JFrame();

        JDialog dialog = new JDialog(frame , message , true);
        dialog.setLayout(new FlowLayout());

        JButton ok = new JButton("OK");
        JButton cancel = new JButton("CANCEL");

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                okPressed = true;
                dispose();
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                okPressed = false;
                dispose();
            }
        });

        dialog.add(new JLabel(message));
        dialog.add(ok);
        dialog.add(cancel);
        dialog.setSize(200,100);
        dialog.setVisible(true);
    }
    public boolean isOkPressed() {
        return okPressed;
    }
}

class Runner{
    public static void main(String[] args) {
        MessageBox messageBox = new MessageBox("Hello , This is Aryan Chandra");
        if (messageBox.isOkPressed()){
            System.out.println("OK was Pressed");
            exit(0);
        }
        else {
            System.out.println("CANCEL was Pressed");
            exit(0);
        }
    }
}
