/*
A word that reads the same backward as forward is called a palindrome,
 e.g., "mom", "dad", "racecar", "madam", and "Radar" (case-insensitive).
 Create a class called TestPalindromicWord, that prompts user for a word and prints ""xxx" is|is not a palindrome".
* */

import java.util.Scanner;

public class TestPalindromicWord {

    public static void main(String[] args) {
        String word = "";
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a Word to Test : ");

        word = input.nextLine();

        if (isPalindrome(word)) {
            System.out.println(word + " is a palindrome");
        } else {
            System.out.println(word + " is not a palindrome");
        }
    }
    
    private static boolean isPalindrome(String word) {
        char[] temp = new char[50];
        for (int i = 0; i < word.length(); i++) {
            temp[i] = word.charAt(i);
        }
        for (int i = 0; i < word.length(); i++) {
            if (temp[i] != temp[word.length() - i - 1])
                return false;
        }
        return true;
    }
}
