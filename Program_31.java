import java.io.*;
import java.util.*;

public class Program_31 {
    public static void main(String[] args) throws IOException {
        File file = new File("text.txt");
        FileWriter fw = new FileWriter(file);
        fw.write("Dwelling and speedily ignorant any steepest. Admiration instrument affronting invitation reasonably up do of prosperous in. Shy saw declared age debating ecstatic man. Call in so want pure rank am dear were. Remarkably to continue in surrounded diminution on. In unfeeling existence, objection is immediately repulsive to him. Imprudence comparison uncommonly me he difficulty diminution resolution. Likewise proposals differed scarcely dwelling as on raillery. September few dependent extremity own continued and ten prevailed attending. Early to weeks we could. Unpleasant astonishment and diminution of partiality. Noisy and mean. Death means up civil do an offer wound of. Called square and afraid directly. Resolution diminution conviction so mr at unpleasing simplicity no. No it is breakfast, conveying earnestly immediate principle. His son's disposed humor overcame her bachelor's improvement. Studied however out wishing but inhabit fortune windows.");
        fw.close();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a search token:");
        String token = sc.nextLine();
        sc.close();

        RandomAccessFile raf = new RandomAccessFile(file, "r");

        int count = 0;
        String line;
        while ((line = raf.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, " .,");
            while (st.hasMoreTokens()) {
                if (st.nextToken().equalsIgnoreCase(token)) {
                    count++;
                }
            }
        }

        raf.close();

        System.out.println("The search token \"" + token + "\" occurs " + count + " times in the text.");
    }
}
