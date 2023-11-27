import java.io.*;
import java.util.*;

public class Program_30a {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(inputFile));
        bw.write("Hi this is java\n");
        bw.write("I like studying it\n");
        bw.close();

        File outputFile = new File("output.txt");
        bw = new BufferedWriter(new FileWriter(outputFile));

        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line;
        while ((line = br.readLine()) != null) {
            int vowels = 0, consonants = 0, spaces = 0;
            for (char c : line.toCharArray()) {
                c = Character.toLowerCase(c);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else if (c >= 'a' && c <= 'z') {
                    consonants++;
                } else if (c == ' ') {
                    spaces++;
                }
            }

            bw.write(line + "(vowels-" + vowels + ", consonants-" + consonants + ", spaces- " + spaces + ")\n");
        }

        br.close();
        bw.close();
    }
}
