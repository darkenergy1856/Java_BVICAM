import java.util.Scanner;

public class squareTranspose {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] squareMatrix = new int[2][2];
        System.out.println("Provide input for Square Matrix : ");

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("Element [" + i + "]" + "[" + j + "] : ");
                squareMatrix[i][j] = input.nextInt();
            }
        }

        System.out.println("Elements Are : ");
        printMatrix(squareMatrix);

        squareMatrix[0][1] += squareMatrix[1][0];
        squareMatrix[1][0]  = squareMatrix[0][1] - squareMatrix[1][0];
        squareMatrix[0][1] -= squareMatrix[1][0];

        System.out.println("Elements after Transpose : ");
        printMatrix(squareMatrix);


    }

    static void printMatrix(int [][] squareMatrix){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(squareMatrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
