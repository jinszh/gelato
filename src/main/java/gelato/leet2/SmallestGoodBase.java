package gelato.leet2;

import java.math.BigInteger;

public class SmallestGoodBase {
    //if n base k are all 1 =>
    // (1) n = k^m + k^(m-1) + ... + 1
    //     => n - 1 = k * ( k ^ m-1 + k ^ m-2 + ... + 1)
    // (2) n - k^m = k ^ m-1 + k ^ m-2 + ... + 1
    // (1) + (2) => n - 1 = k * ( n - k ^ m) => n = (k^ (m + 1) - 1)/(k-1)
    // (3) n > k^m , n = k^m + k^m-1+...+1 < (k+1)^m => k^m < n < (k+1)^m
    //     => for any k, only need to test  ⌊m-th root of n⌋ rounded down value of mth square root of n
    // (4) k min is 2 --> m max is log_2(n). k max is (m-1), when m min is 1.
    // Solution: starting from the upper limit of m, check if we can find a k so that the equation f(k, m) = n is held true
    // .If so, return the corresponding k as the solution.
    // Otherwise decrease the value of m by 1 and repeat the process until either a solution is found or all values of m have been exhausted.

    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);
        BigInteger bn = BigInteger.valueOf(num);
        int max_m = (int) (Math.log(num) / Math.log(2));
        for (int m = max_m; m >= 1; m--) {
            BigInteger k = BigInteger.valueOf((long) Math.floor(Math.pow(num, 1.0 / m)));
            BigInteger left = k.pow(m + 1).subtract(BigInteger.ONE);
            BigInteger right = bn.multiply(k.subtract(BigInteger.ONE));
            if (left.equals(right)) {
                return String.valueOf(k);
            }
        }
        return String.valueOf(num - 1);
    }

    //Optimization:  when m is fixed, do binary search for k
    // 1. k^m < n => k < n^(1/m), this is upper bound
    // 2. n = (k^(m+1) - 1) / (k - 1) <= k^(m+1) - 1 => k^(m+1) - 1 >= n
    //      => k >= (n + 1)^(1/(m+1)), this is lower bound

    public String smallestGoodBase_optimized(String n) {
        long num = Long.valueOf(n);

        for (int m = (int)(Math.log(num + 1) / Math.log(2)); m > 2; m--) {
            long l = (long)(Math.pow(num + 1, 1.0 / m));
            long r = (long)(Math.pow(num, 1.0 / (m - 1)));

            while (l <= r) {
                long k = l + ((r - l) >> 1);
                long f = 0L;
                for (int i = 0; i < m; i++, f = f * k + 1);

                if (num == f) {
                    return String.valueOf(k);
                } else if (num < f) {
                    r = k - 1;
                } else {
                    l = k + 1;
                }
            }
        }

        return String.valueOf(num - 1);
    }
}
