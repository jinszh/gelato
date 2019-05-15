package rt1;

import java.util.Scanner;

public class ReadToEnd {
    static {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while (scan.hasNext()) { // Ctrl + D from keyboard to be EOF
            i++;
            System.out.println(i + " " + scan.nextLine());
        }
    }
}
