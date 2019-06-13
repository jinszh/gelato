package gelato.leet9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

//962
public class maxWidthRamp {
    public int maxWidthRamp(int[] A) {
        int [][] ap = new int[A.length][];
        for(int i = 0 ; i < A.length; i++){
            ap[i] = new int[]{A[i], i};
        }
        Arrays.sort(ap, (a, b) -> Integer.compare(a[0], b[0]));
        int min = A.length - 1;
        int res = 0;
        for(int i = 0; i < A.length; i++){
            min = Math.min(min, ap[i][1]);
            res = Math.max(res, ap[i][1] - min);
        }
        return res;
    }

    //用一个stack 就O(N)了,stack里保持递减的关系
    public int maxWidthRamp_(int[] A) {
        LinkedList<Integer> s = new LinkedList<>();
        int res = 0, n = A.length;
        for (int i = 0; i < n; ++i)
            if (s.isEmpty() || A[s.peekLast()] > A[i])
                s.add(i);
        for (int i = n - 1; i > res; --i)
            while (!s.isEmpty() && A[s.peekLast()] <= A[i])
                res = Math.max(res, i - s.pollLast());
        return res;
    }
}
