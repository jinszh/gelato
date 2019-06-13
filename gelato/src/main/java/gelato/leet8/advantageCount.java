package gelato.leet8;

import java.util.Arrays;

//870
public class advantageCount {
    public int[] advantageCount(int[] A, int[] B) {
        int[] res = new int[B.length];
        boolean[] used = new boolean[B.length];
        Arrays.sort(A);
        for (int i = 0; i < B.length; i++) {
            int idx = Arrays.binarySearch(A, B[i]);
            if (idx < 0) {
                idx = -idx - 1;
            } else {
                idx = idx + 1;
            }
            while (idx < (B.length - 1) && A[idx] == B[i] && used[idx]) idx++;
            if (idx >= B.length) {
                idx = 0;
                while (used[idx]) idx++;
            }
            res[i] = A[idx];
            used[idx] = true;
        }
        return res;
    }
}
