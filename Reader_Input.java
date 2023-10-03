import java.util.Scanner;

public class Reader_Input {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = "";
        StringBuilder temp = new StringBuilder();

        System.out.println("Input a Line : ");
        line = input.nextLine();
        line += " ";

       for (int i = 0 ; i < line.length() ; i++){
           if (line.charAt(i) != ' '){
               if (((int)line.charAt(i) <= 90 && (int)line.charAt(i) >=65) || ((int)line.charAt(i) <= 121 && (int)line.charAt(i) >=97))
                    temp.append(line.charAt(i));
               else
                   temp.insert(0 , line.charAt(i));
           }
           else {
               System.out.print(temp.reverse() + " ");
               temp = new StringBuilder();
           }
       }


    }
}
