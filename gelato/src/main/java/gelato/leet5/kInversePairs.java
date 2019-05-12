package gelato.leet5;

public class kInversePairs {
    public int kInversePairs(int n, int k) {
        //f(n,k) = f(n-1,k) + f(n-1, k-1) + ... + f(n - 1, max(k - n + 1, 0))

        //let dp[n][k] = dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]+dp[n-1][k-n+1]
        //dp[n][k+1] = dp[n-1][k+1]+dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]
        // ==> dp[n][k+1] = dp[n][k]+dp[n-1][k+1]-dp[n-1][k+1-n]

        long [][] dp = new long[n + 1][k + 1];

        if (k > n*(n-1)/2 || k < 0) return 0;
        if (k == 0 || k == n*(n-1)/2) return 1;

        dp[2][0] = dp[2][1] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k && j <= i * (i - 1) / 2; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - (j >= i ? dp[i - 1][j - i] : 0);
                dp[i][j] = (dp[i][j] + 1000000007) % 1000000007;
            }
        }

        return (int) (dp[n][k]);
    }
}
