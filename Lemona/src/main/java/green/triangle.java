package green;

import java.io.*;
import java.util.*;

public class triangle{
    public static void main(String[] args)
    {
        final StringBuffer sb = new StringBuffer("Hello");

        // Even though reference varibale sb is final
        // We can perform any changes
        sb.append("GFG");

        System.out.println(sb);

        // Here we will get Compile time error
        // Because reassignment is not possible for final variable

        List<Integer> arr = new ArrayList<Integer>();

        arr.stream().toArray();

        System.out.println(sb);
    }
}