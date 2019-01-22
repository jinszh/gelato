package gelato.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class sumSubseqWidths {
    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        int l = 0, r = A.length - 1;
        int lsum = 0, rsum = 0;
        long d = 1, ans = 0, mod = 1000000007;
        while (l < A.length) {
            lsum += A[l++];
            rsum += A[r--];
            ans += (rsum - lsum) * d;
            ans %= mod;
            d = d * 2 % mod;
        }
        return (int)ans;
    }

}
