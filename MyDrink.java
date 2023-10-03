/*
 * A large number of college students are attending a party. Each guest is drinking a can of cold drink (or soda if they are under 21).
 * An emergency causes the lights to go out and the fire alarm to go off.
 * The guests calmly put down their cold drink and exit the building.
 * When the alarm goes off, they re-enter and try to retrieve their cold drink.
 * However, the lights are still off, so each student randomly grabs a bottle of cold drink.
 * What are the chances that at least one student gets his or her original cold drink?
 * Write a program MyDrink.java that takes an argument n and runs 1,00 simulations this event, assuming
 * there are n guests.
 * Print the fraction of times that at least one guest gets their original beer.
 * As n gets large, does this fraction approach 0 or 1 or something in between?*/

import java.util.Random;
import java.util.Scanner;

public class MyDrink {
    static int[] drinkHolder = new int[100000];

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int guest;
        boolean drinkFound = false;
        boolean outOfBound = false;
        int drinkMatchedCount = 0;

        System.out.println("Provide no. of Guest attending the party : ");
        guest = input.nextInt();


        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < guest; j++) {
                drinkHolder[j] = j;
            }
            drinkShuffler(guest);
            int currentIndex = 0;
            do {
                if (currentIndex > guest) {
                    System.out.println("No Drinks Matched!!");
                    outOfBound= true;
                }
                if (drinkHolder[currentIndex] == currentIndex) {
                    System.out.println("Drink Matched At : " + (currentIndex + 1));
                    drinkMatchedCount++;
                    drinkFound = true;
                }
                currentIndex++;

            } while (!drinkFound && !outOfBound);
            drinkFound = outOfBound = false;
        }
        System.out.println("Resultant Fraction : " + ((float) drinkMatchedCount/guest));
    }

    static void drinkShuffler(int guest) {
        Random random = new Random();
        for (int i = 0; i < guest; i++) {
            int randomIndex = random.nextInt(guest);
            int temp = drinkHolder[randomIndex];
            drinkHolder[randomIndex] = drinkHolder[i];
            drinkHolder[i] = temp;
        }
    }

}
