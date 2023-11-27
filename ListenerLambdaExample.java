import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public
class

ListenerLambdaExample extends JFrame {
    private JButton button = new JButton("Click Me!");

    public ListenerLambdaExample() {
        super("Listener Lambda Example");
        getContentPane().add(button, BorderLayout.CENTER);

        // Anonymous class listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Handled by anonymous class listener");
            }
        });

        // Lambda listener
        button.addActionListener(e -> System.out.println("Handled by lambda listener"));
    }

    public static void main(String[] args) {
        ListenerLambdaExample frame = new ListenerLambdaExample();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}