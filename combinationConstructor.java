import java.util.Scanner;

import static java.lang.System.exit;

public class combinationConstructor {
    public static void main(String[] args) {
        int[] number = new int[3];
        Scanner input = new Scanner(System.in);

        for(int i = 0; i < 3 ; i++){
            System.out.println("Input " +(i+1)+ " Digit :");
            number[i]= input.nextInt();
            if (!(number[i] >= 0 && number[i] <= 9)) {
                System.out.println("Invalid Input!!");
                exit(1);
            }
        }

        for(int x = 0 ; x < 3;x++){
            for(int y = 0 ; y < 3;y++){
                for(int z = 0 ; z < 3;z++){
                    if (x !=y && x!=z && y!=z){
                        System.out.println(number[x] + String.valueOf(number[y]) + number[z]);
                    }
                }
            }
        }
    }
}
