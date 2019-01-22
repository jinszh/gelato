package gelato.leetCode;

public class maxProfit {
    public int maxProfit(int[] prices) {
        int[] maxes = new int[prices.length];
        int[] rmaxes = new int[prices.length];
        int l1, m1, l2, m2;
        l1 = m1 =l2 = m2 = prices.length > 0 ? prices[0] : 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < l1 && prices[i] < l2) {
                l2 = prices[i];
            }
            if (prices[i] > m1) {
                m1 = prices[i];
            }
            if (prices[i] - l2 > m1 - l1) {
                m1 = prices[i];
                l1 = l2;
                l2 = Integer.MAX_VALUE;
            }
            maxes[i] = m1 - l1;
        }
        l1 = m1 = m2 = prices.length > 0 ? prices[prices.length - 1] : 0;
        for (int j = prices.length - 1; j > 0; j--) {
            if (prices[j] > m1 && prices[j] > m2) {
                m2 = prices[j];
            }
            if (prices[j] < l1) {
                l1 = prices[j];
            }
            if (m2 - prices[j] > m1 - l1) {
                l1 = prices[j];
                m1 = m2;
                m2 = 0;
            }
            rmaxes[j] = m1 - l1;
        }
        int maxv = 0;
        for (int i = 1; i < prices.length; i++) {
            int cur = maxes[i] + (i < prices.length - 1 ? rmaxes[i + 1] : 0);
            if (cur > maxv) {
                maxv = cur;
            }
        }
        return maxv;
    }
}
