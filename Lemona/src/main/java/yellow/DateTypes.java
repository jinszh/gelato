package yellow;

import java.util.Scanner;

public class DateTypes {
    /***
     * A byte is an 8-bit signed integer.
     * A short is a 16-bit signed integer.
     * An int is a 32-bit signed integer.
     * A long is a 64-bit signed integer.
     */
    public void checkType() {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        System.out.println(x + " can be fitted in:");
        if (x >= -128 && x <= 127) System.out.println("* byte");
        //Complete the code
        if (x >= -Math.pow(2, 15) && x <= Math.pow(2, 15) - 1)
            System.out.println("* short");
        if (x >= -Math.pow(2, 31) && x <= Math.pow(2, 31) - 1)
            System.out.println("* int");
        if (x >= -Math.pow(2, 63) && x <= Math.pow(2, 63) - 1)
            System.out.println("* long");
    }
}