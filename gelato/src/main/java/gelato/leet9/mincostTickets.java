package gelato.leet9;

public class mincostTickets {
    private static final int YEARDAY  = 365;
    public int mincostTickets(int[] days, int[] costs) {
        //-1,7,30 day pass
        int[] dp = new int[YEARDAY + 1];
        boolean[] go = new boolean[YEARDAY + 1];
        for (int i = 0; i < days.length; i++) {
            go[days[i]] = true;
        }
        for (int i = YEARDAY; i >= 0; i--) {
            int cost = i < YEARDAY ? dp[i + 1] : 0;
            if (go[i]) {
                cost = costs[2] + (i + 30 <= YEARDAY ? dp[i + 30] : 0);
                cost = Math.min(cost, costs[1] + (i + 7 <= YEARDAY ? dp[i + 7] : 0));
                cost = Math.min(cost, costs[0] + (i + 1 <= YEARDAY ? dp[i + 1] : 0));
            }
            dp[i] = cost;
        }
        return dp[0];
    }
}
