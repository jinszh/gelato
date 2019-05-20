package gelato.leet3;

public class getMoneyAmount {
    public int getMoneyAmount(int n) {
        int [][] dp = new int[n + 1][n + 1];
        return minCost(dp, 1, n);
    }

    private int minCost(int [][] dp, int b, int e) {
        if (b >= e) {
            return 0;
        }
        if (dp[b][e] != 0) {
            return dp[b][e];
        } else {
            int minCost = Integer.MAX_VALUE;
            for (int i = b; i <= e; i++) {//哪怕是冒号的if else也浪费时间,能拿掉就拿掉
                int cost = i + Math.max(minCost(dp, i + 1, e), minCost(dp, b, i - 1));
                minCost = Math.min(cost, minCost);
            }
            dp[b][e] = minCost;
            return minCost;
        }
    }

    //faster version - buttom up - no recursion
    public int getMoneyAmount_buttomup(int n) {
        int[][] table = new int[n + 1][n + 1];
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i > 0; i--) {
                int globalMin = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int localMax = k + Math.max(table[i][k - 1], table[k + 1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                table[i][j] = i + 1 == j ? i : globalMin;
            }
        }
        return table[1][n];
    }
}
