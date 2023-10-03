import java.util.Random;

public class VowelFilter {
    public static void main(String[] args) {
        char[] charArray = new char[50];
        Random randomCharacter = new Random();
        // a = 97 ; z = 122 ;
        for (int i = 0; i < 50; i++) {
            charArray[i] = (char) (97 + randomCharacter.nextInt(10));
        }
        System.out.println("Resulted Array is : ");
        System.out.println(filterVowel(charArray));
    }

    public static char[] filterVowel(char[] input) {
        char[] temp = new char[input.length];
        char resultLength = 0;
        for (int i = 0; i < input.length; i++) {
            switch (input[i]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    break;
                default:
                    temp[resultLength] = input[i];
                    resultLength++;
                    break;
            }
        }

        char[] result = new char[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = temp[i];
        }
        return result;
    }
}
