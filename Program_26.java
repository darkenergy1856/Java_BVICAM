import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.StringTokenizer;

public class Program_26 extends Frame {
    Panel p = new Panel();
    Label word = new Label("Word : 0");

    Label character = new Label("Character : 0");
    Button countWords = new Button("Count Words");
    TextArea textInput = new TextArea();

    public static void main(String[] args) {
        new Program_26();
    }
    public Program_26() {
        setTitle("Program 26");
        setSize(500 , 300);
        setLayout(new FlowLayout());
        p.setLayout(new FlowLayout());
        p.add(word);
        p.add(character);

        countWords.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character.setText("Character : " + getCharacter());

                word.setText("Word : " + getWord());
            }
        });
        add(p);
        add(textInput);
        add(countWords);


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose();
            }
        });
        setVisible(true);
    }

    private int getCharacter(){
        return textInput.getText().toCharArray().length;
    }

    private int getWord(){
        return new StringTokenizer(textInput.getText()).countTokens();
    }
}
