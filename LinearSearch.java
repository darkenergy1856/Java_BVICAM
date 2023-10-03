import java.util.Scanner;

import static java.lang.System.exit;

public class LinearSearch {
    public static void main(String[] args) {
        int[] number = new int[50];
        int inputLength = 0;
        int numberToBeSearched;

        Scanner input = new Scanner(System.in);

        System.out.println("Length of Array : ");
        inputLength = input.nextInt();
        System.out.println("Provide Input for The array : ");
        for (int i = 0 ; i < inputLength ; i++){
            number[i] = input.nextInt();
        }

        System.out.println("Enter integer to Search : ");
        numberToBeSearched = input.nextInt();

        for (int i = 0 ; i < inputLength ; i++){
            if (numberToBeSearched == number[i]){
                System.out.println("Integer Found at Index : " + (i+1));
                exit(0);
            }
        }

        System.out.println("Integer not Found !!.");

    }
}
