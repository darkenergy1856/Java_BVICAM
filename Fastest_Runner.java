public class Fastest_Runner {
    public static void main(String[] args) {
        String[][] data = {{"Elena", "341"}, {"Thomas", "273"}, {"Hamilton", "278"}, {"Suzie", "329"}, {"Phil", "445"}, {"Matt", "402"}, {"Alex", "388"}, {"Emma", "275"}, {"John", "243"}, {"James", "334"}, {"Jane", "412"}};
        int fastestRunner = Integer.parseInt(data[0][1]);
        int index = 0;
        int secondIndex = 0;
        for (int i = 0 ; i < data.length ; i++){
            if (Integer.parseInt(data[i][1]) < fastestRunner){
                fastestRunner = Integer.parseInt(data[i][1]);
                secondIndex = index;
                index = i;
            }
        }

        System.out.println("Fastest Runner is  : " + data[index][0] + "\n" + "Time Taken : " + data[index][1] + " minutes");
        System.out.println("Second Fastest Runner is : " + data[secondIndex][0] + "\n" + "Time Taken : " + data[secondIndex][1] + " minutes");
    }
}
