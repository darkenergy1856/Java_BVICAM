import java.util.Scanner;

import static java.lang.System.exit;

public class EmployeePayGenerator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int workingHour;
        double basePay;
        System.out.println("Working Hour : ");
        workingHour = input.nextInt();
        if (workingHour > 60){
            System.out.println("Working hour cannot be greater than 60.");
            exit(1);
        }
        System.out.println("Base Pay : ");
        basePay = input.nextDouble();
        if (basePay < 8.00){
            System.out.println("Base pay cannot be less than $8.00");
            exit(1);
        }
        if (workingHour <= 40){
            System.out.println("Pay Generated : " + (basePay*workingHour));
        }
        else {
            System.out.println("Pay Generated : " + ((basePay * 40)+((workingHour - 40)* (basePay * 1.5))));
        }
    }
}
