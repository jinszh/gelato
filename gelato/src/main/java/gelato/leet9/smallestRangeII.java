package gelato.leet9;

import java.util.Arrays;

//910
public class smallestRangeII {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int r = A.length - 1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            int low = Math.min(A[i] - K, A[0] + K);
            int high = Math.max(A[i - 1] + K, A[r] - K);
            if (high - low < min) {
                min = high - low;
            }
        }
        return Math.min(min, A[r] - A[0]);
    }
}
