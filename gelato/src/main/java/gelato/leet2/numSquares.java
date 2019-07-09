package gelato.leet2;

import java.util.Arrays;

//279
public class numSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= Math.sqrt(n) + 1; i++) {
            dp[i * i] = 1;
            for (int j = i * i + 1; j <= n; j++) {
                dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
            }
        }
        return dp[n];
    }
}
