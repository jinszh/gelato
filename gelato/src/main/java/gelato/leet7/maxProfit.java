package gelato.leet7;

//714
public class maxProfit {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) return 0;
        int[] ph = new int[prices.length];
        int[] ps = new int[prices.length];
        int[] pe = new int[prices.length];
        ph[0] = ps[0] = pe[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            ph[i] = prices[i] - prices[i - 1] + Math.max(ph[i - 1], pe[i - 1]);
            ps[i] = prices[i] - prices[i - 1] + Math.max(pe[i - 1], ph[i - 1]) - fee;
            pe[i] = Math.max(ps[i - 1], pe[i - 1]);
        }
        return Math.max(pe[prices.length - 1], ps[prices.length - 1]);
    }

    //Simpler way below: 没有额外空间, 没有复杂的状态转换
    // But there is another way to DP the state, e.g. this question
    public int maxProfit_sim(int[] prices, int fee) {
        // two states:
        // "hold" state: represent the max profit when we hold a stock at time i - 1.
        // "empty" state: represent the max profit when we do not hold a stock at time i - 1.
        // initialization:
        // for "hold" state, we hold one stock, so the profit is -prices[0]
        // for "empty" state, we do not hold stock, so the profit is 0
        int hold = -prices[0], empty = 0;
        for (int i = 1; i < prices.length; i++) {
            // on current time i
            // the max profit of hold state is either we still hold the stock we hold at the i-1 time(hold)
            // or we buy new stock(empty - prices[i])
            hold = Math.max(hold, empty - prices[i]);
            // the max profit of enpty state is eighter we still keep our hand empty(empty)
            // or we sell the stock we already hold(hold + prices[i] - fee)
            empty = Math.max(empty, hold + prices[i] - fee);
        }
        // return must be empty, because selling is better than holding one stock that has not been sold
        return empty;
    }
}
