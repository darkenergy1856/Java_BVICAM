import java.util.Scanner;

import static java.lang.System.exit;

public class DecipherCaesarCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputString = "";
        System.out.println("Your input should have both Uppercase and Lowercase.");
        System.out.println("Input Cipher Text : ");
        inputString = input.nextLine();
        char[] tempChar = inputString.toCharArray();
        boolean lowerCase = false;
        boolean upperCase = false;


        for (char c : tempChar) {
           if (!lowerCase)
                lowerCase = Character.isLowerCase(c);
           if (!upperCase)
                upperCase = Character.isUpperCase(c);
        }

        if (!lowerCase || !upperCase) {
            System.out.println("Cipher Text dose not match the required criteria");
            exit(0);
        }

        System.out.println("Upper Case String : ");
        System.out.println(inputString.toUpperCase());
    }
}
