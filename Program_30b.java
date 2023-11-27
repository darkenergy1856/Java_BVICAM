import java.io.*;

public class Program_30b {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        FileWriter fw = new FileWriter(inputFile);
        fw.write("Hi this is java\n");
        fw.write("I like studying it\n");
        fw.close();

        File outputFile = new File("output.txt");
        fw = new FileWriter(outputFile);

        FileReader fr = new FileReader(inputFile);
        int c;
        StringBuilder sb = new StringBuilder();
        while ((c = fr.read()) != -1) {
            sb.append((char) c);

            if (c == '\n') {
                String line = sb.toString();

                int vowels = 0, consonants = 0, spaces = 0;
                for (char ch : line.toCharArray()) {
                    ch = Character.toLowerCase(ch);
                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                        vowels++;
                    } else if (ch >= 'a' && ch <= 'z') {
                        consonants++;
                    } else if (ch == ' ') {
                        spaces++;
                    }
                }

                fw.write(line + "(vowels-" + vowels + ", consonants-" + consonants + ", spaces- " + spaces + ")\n");

                sb.setLength(0);
            }
        }

        fr.close();
        fw.close();
    }
}
