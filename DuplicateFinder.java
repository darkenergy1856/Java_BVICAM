public class DuplicateFinder {
    static int[] number = {10, 25, 3, 2, 14, 4665, 1321, 561, 32, 165, 156, 132, 165, 65, 1, 681, 32, 1231, 5, 1, 2, 3, 203, 2023, 10, 121, 10, 1, 2, 2, 80, 42};

    public static void main(String[] args) {
        int[] duplicateArray = new int[50];
        int duplicateArrayEntry = 0;
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i] + " , ");
        }
        System.out.println();
        for (int i = 0; i < number.length; i++) {
            int currentFrequency = frequencyFinder(number[i], null);

            if (currentFrequency != 1) {
                if (frequencyFinder(number[i], duplicateArray) == 0) {
                    duplicateArray[duplicateArrayEntry] = number[i];
                    duplicateArrayEntry++;
                    System.out.println("Duplicate Element Found : ");
                    System.out.println(number[i] + " : " + currentFrequency);
                }
            }
        }
    }

    static int frequencyFinder(int numberFrequency, int[] array) {
        if (array == null) {
            array = number;
        }
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numberFrequency) {
                temp++;
            }
        }
        return temp;
    }
}

