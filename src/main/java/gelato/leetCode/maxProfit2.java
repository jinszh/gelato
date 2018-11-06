package gelato.leetCode;

import gelato.util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maxProfit2 {
    public int maxProfit(int k, int[] prices) {
        int v = 0;
        if (k > 0 && prices.length > 0) {
            List<Integer> buy = new ArrayList<>();
            List<Integer> sell = new ArrayList<>();
            int rl = 0, rd = 0;
            for (int i = 0; i < prices.length; i++) {
                if (i < prices.length - 1 && prices[i] == prices[i + 1]) {
                    continue;
                }
                if (i > 0 && prices[i] > prices[rl] && ((i < prices.length - 1 && prices[i] > prices[i + 1]) || i == prices.length - 1)) {
                    sell.add(i);
                }
                if ((i == 0 || (i > 0 && prices[i] < prices[rl])) && i < prices.length - 1 && prices[i] < prices[i + 1]) {
                    buy.add(i);
                }
                rl = i;
            }
            if (buy.size() > 0 && sell.size() > 0) {
                int[][] max = new int[buy.size()][sell.size()];
                for (int i = 0; i < buy.size(); i++) {
                    max[i][i] = prices[sell.get(i)] - prices[buy.get(i)];
                    int high = prices[sell.get(i)];
                    for (int j = i + 1; j < sell.size(); j++) {
                        if (prices[sell.get(j)] > high) {
                            high = prices[sell.get(j)];
                        }
                        max[i][j] = high - prices[buy.get(i)];
                    }
                }

                int[][][] memo = new int[k][buy.size()][sell.size()];
                for (int n = 0; n < k; n++) {
                    for (int i = 0; i < buy.size(); i++) {
                        memo[n][i][i] = max[i][i];
                        for (int j = i + 1; j < sell.size(); j++) {
                            memo[n][i][j] = Math.max(memo[n][i][j - 1], (n > 0 ? memo[n - 1][i][j] : max[i][j]));
                            if (n > 0) {
                                for (int sep = i; sep < buy.size() - 1 &&  sep < j; sep++) {
                                    memo[n][i][j] = Math.max(max[i][sep] + memo[n - 1][sep + 1][j], memo[n][i][j]);
                                }
                            }
                        }
                    }
                }
                v = memo[k - 1][0][sell.size() - 1];
            }
        }
        return v;
    }
}
