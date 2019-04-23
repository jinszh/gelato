package gelato.leet10;

import java.util.ArrayList;
import java.util.LinkedList;

public class longestOnes {
    public int longestOnes(int[] A, int K) {
        int connd = 0, maxConnd = 0, used0 = 0, last = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] == 0){
                used0++;
                while (used0 > K){
                    if(A[last] == 0){
                        used0--;
                    }
                    connd--;
                    last++;
                }
            }
            connd++;
            maxConnd = Math.max(connd, maxConnd);
        }
        return maxConnd;
    }
}
