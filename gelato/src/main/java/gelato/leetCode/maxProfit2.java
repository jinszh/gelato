package gelato.leetCode;
import gelato.util.Util;

import java.util.ArrayList;
import java.util.List;

public class maxProfit2 {
    public int maxProfit(int k, int[] prices) {
        int v = 0;
        if (k > 0 && prices.length > 0) {
            List<Integer> buy = new ArrayList<>();
            List<Integer> sell = new ArrayList<>();
            List<Integer> diff = new ArrayList<>();
            int rl = -1;
            for (int i = 0; i < prices.length; i++) {
                if (i < prices.length - 1 && prices[i] == prices[i + 1]) {
                    continue;
                }
                if (rl >= 0 && prices[i] > prices[rl] && ((i < prices.length - 1 && prices[i] > prices[i + 1]) || i == prices.length - 1)) {
                    sell.add(i);
                }
                if ((rl < 0 || (i > 0 && prices[i] < prices[rl])) && i < prices.length - 1 && prices[i] < prices[i + 1]) {
                    buy.add(i);
                }
                rl = i;
            }
            for (int i = 0; i < buy.size(); i++) {
                diff.add(prices[sell.get(i)] - prices[buy.get(i)]);
            }
            if (buy.size() > 0 && sell.size() > 0) {
                if (k >= buy.size()) {
                    v = diff.stream().mapToInt(i -> i).sum();
                } else {
                    int[][] max = new int[buy.size()][sell.size()];
                    for (int i = 0; i < buy.size(); i++) {
                        int maxpro = max[i][i] = diff.get(i);
                        int low = prices[buy.get(i)];
                        for (int j = i + 1; j < sell.size(); j++) {
                            if (prices[buy.get(j)] < low) {
                                low = prices[buy.get(j)];
                            }
                            maxpro = max[i][j] = Math.max(prices[sell.get(j)] - low, maxpro);
                        }
                    }
                    int[] memo = new int[buy.size()];
                    int[] memo2 = null;;

                    for (int n = 0; n < k; n++) {
                        for (int i = 0; i < buy.size(); i++) {
                            memo[i] = Math.max(i > 0 ? memo[i - 1] : max[0][i], n > 0 ? memo2[i] : max[0][i]);
                            if (n > 0) {
                                for (int s = 0; s < i; s++) {
                                    memo[i] = Math.max(memo2[s] + max[s+1][i], memo[i]);
                                }
                            }
                        }
                        memo2 = memo;
                        memo = new int[buy.size()];
                    }
                    v = memo2[sell.size() - 1];
                }
            }
        }
        return v;
    }
}
