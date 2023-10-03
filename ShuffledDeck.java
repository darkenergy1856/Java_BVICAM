import java.util.Random;

public class ShuffledDeck {
    static int[] shuffledDeck = new int[52];

    static Random random = new Random();

    public static void main(String[] args) {
        /*  Representation in Program for Simplicity’s sake
        Heart = 1;
        Spade = 2;
        Diamond = 3;
        Club =  4;
        */
        boolean heart = false;
        boolean spade = false;
        boolean diamond = false;
        boolean club = false;
        int index;

        for (int i = 0; i < 13; i++) {
            shuffledDeck[i] = 1;
        }
        for (int i = 13; i < 26; i++) {
            shuffledDeck[i] = 2;
        }
        for (int i = 26; i < 39; i++) {
            shuffledDeck[i] = 3;
        }
        for (int i = 39; i < 52; i++) {
            shuffledDeck[i] = 4;
        }
        int sum = 0;
        for (int i = 0; i < 10000000; i++) {
            deckShuffler();
            index = 0;
            while (!heart || !spade || !club || !diamond) {
                switch (shuffledDeck[index]) {
                    case 1:
                        heart = true;
                        break;
                    case 2:
                        spade = true;
                        break;
                    case 3:
                        diamond = true;
                        break;
                    case 4:
                        club = true;
                        break;
                }
                index++;

            }
            heart = spade = diamond = club = false;
            sum = sum + index;
            System.out.println(i);
        }

        System.out.println("Average Value : " + (double)sum/10000000);
    }

    static void deckShuffler() {
        for (int i = 0; i < 52; i++) {
            int randomIndex = random.nextInt(52);
            int temp = shuffledDeck[randomIndex];
            shuffledDeck[randomIndex] = shuffledDeck[i];
            shuffledDeck[i] = temp;
        }
    }
}
