import conc.CollectionTests;
import conc.ThreadTests;

import java.util.Scanner;

public class app {
    public static void main(String[] args){
//        ThreadTests f = new ThreadTests();
//        f.iter();

        CollectionTests t = new CollectionTests();
        t.t1();

    }//end

    public static void v1(){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int a = 0,b= 0,n=0;
        for(int i=0;i<t;i++){
            a = in.nextInt();
            n = in.nextInt();
            int tempAnswer = a;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                tempAnswer = tempAnswer + (b * j);
                System.out.print(Integer.toString(sum + tempAnswer) + (j < n -1 ? " " : ""));
            }
            System.out.println();
        }
        in.close();
        in.close();
    }
}
