package gelato.leet3;

import java.util.Arrays;

public class maxProfit {
    //intuitive version
    public int maxProfit_dp(int[] prices) {
        int [] dp = new int[prices.length + 2];
        for(int i = prices.length - 2; i >= 0; i--){
            for(int j = i + 1; j < prices.length; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], prices[j] - prices[i] + dp[j + 2]));
            }
        }
        return dp[0];
    }

    //Use state machine(B: bought or hold, S: sold, R:rest), can change it to time O(N) & space O(1)
    public int maxProfit(int[] prices) {
        int buy = 0, prevBuy = 0, sell = 0, prevSell = 0, rest = 0;
        for (int i = 1; i < prices.length; i++) {
            prevBuy = buy;
            prevSell = sell;
            buy = Math.max(prevBuy + (prices[i] - prices[i - 1]), rest);
            sell = prevBuy + (prices[i] - prices[i - 1]);
            rest = Math.max(prevSell, rest);
        }
        return Math.max(sell, rest);
    }
}
