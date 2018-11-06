package gelato.leetCode;

import gelato.util.Util;

public class maxProfit2 {
    public int maxProfit(int k, int[] prices) {
        Util.checkTime();
        int v = 0;
        if (k > 0 && prices.length > 0) {
            int[][][] memo = new int[k][prices.length][prices.length];
            int[][] max = new int[prices.length][prices.length];
            int[] sellPoint = new int[prices.length];
            int highe = prices[0];
            for (int i = 0; i < prices.length - 1; i++) {
                max[i][i] = 0;
                Integer lowe = prices[i];
                if(i > 0 && prices[i] <= prices[i-1]){
                    sellPoint[i] = highe;
                }else{
                    sellPoint[i] = highe = prices[i];
                }
                for (int j = i + 1; j < prices.length; j++) {
                    max[i][j] = 0;
                    if (prices[j] < lowe) {
                        lowe = prices[j];
                    }
                    max[i][j] = Math.max(max[i][j - 1], prices[j] - lowe);
                }
            }
            Util.checkTime();
            long loop = 0;
            for (int n = 0; n < k; n++) {
                for (int i = 0; i < prices.length - 1; i++) {
                    memo[n][i][i] = 0;
                    for (int j = i + 1; j < prices.length; j++) {
                        memo[n][i][j] = Math.max(memo[n][i][j - 1], (n > 0 ? memo[n - 1][i][j] : max[i][j]));
                        if (n > 0 && prices[j] >= sellPoint[j]) {
                            for (int sep = i + 1; sep < j - 1; sep++) {
                                memo[n][i][j] = Math.max(max[i][sep] + memo[n - 1][sep + 1][j], memo[n][i][j]);
                                loop++;
                            }
                        }
                    }
                }
            }
            Util.print("loop is " + loop);
           t Util.checkTime();
            v = memo[k - 1][0][prices.length - 1];
        }
        return v;
    }
}
