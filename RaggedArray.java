import java.util.Scanner;

public class RaggedArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Provide a Number : ");
        int raggedArrayLength = input.nextInt();
        for(int i = 0 ; i <= raggedArrayLength ; i++){
            for (int j = 1 ; j <= i ; j++)
                System.out.print(j);
            System.out.println();
        }
    }
}
