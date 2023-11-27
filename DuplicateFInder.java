public class DuplicateFinder {
    static int[] number = {10, 25, 3, 2, 14, 4665, 1321, 561, 32, 165, 156, 132, 165, 65, 1, 681, 32, 1231, 5, 1, 2, 3, 203, 2023, 10, 121, 10, 1, 2, 2, 80, 42};

    public static void main(String[] args) {
        int[] duplicateArray = new int[50];
        int duplicateArrayEntry = 0;
        for (int k : number) {
            System.out.print(k + " , ");
        }
        System.out.println();
        for (int j : number) {
            int currentFrequency = frequencyFinder(j, null);

            if (currentFrequency != 1) {
                if (frequencyFinder(j, duplicateArray) == 0) {
                    duplicateArray[duplicateArrayEntry] = j;
                    duplicateArrayEntry++;
                    System.out.println("Duplicate Element Found : ");
                    System.out.println(j + " : " + currentFrequency);
                }
            }
        }
    }

    static int frequencyFinder(int numberFrequency, int[] array) {
        if (array == null) {
            array = number;
        }
        int temp = 0;
        for (int j : array) {
            if (j == numberFrequency) {
                temp++;
            }
        }
        return temp;
    }
}

