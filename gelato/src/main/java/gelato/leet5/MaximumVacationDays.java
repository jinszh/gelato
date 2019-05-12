package gelato.leet5;

import java.util.Arrays;

public class MaximumVacationDays {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int k = days[0].length;
        int n = flights.length;
        int[][] dp = new int[k][n];

        for (int[] arr : dp) Arrays.fill(arr, -1);
        dp[0][0] = days[0][0];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && dp[i - 1][j] >= 0) {//stay
                    dp[i][j] = Math.max(dp[i - 1][j] + days[j][i], dp[i][j]);
                }
                for (int f = 0; f < flights.length; f++) {
                    if (flights[j][f] > 0 && dp[i][j] >= 0) {
                        dp[i][f] = Math.max(dp[i][f], (i > 0 ? dp[i - 1][j] : 0) + days[f][i]);
                    }
                }
            }
        }
        return Arrays.stream(dp[k - 1]).max().getAsInt();
    }
}
