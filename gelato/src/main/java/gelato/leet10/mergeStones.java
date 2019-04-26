package gelato.leet10;

public class mergeStones {
    int [][] dp;
    public int mergeStones(int[] stones, int K) {
        dp = new int[stones.length][K + 1];
        merge(stones, 0, stones.length - 1, K);
        return dp[stones.length - 1][K];
    }

    private int merge(int [] stones, int b, int e, int K) {
        if (dp[e][K] > 0) return dp[e][K];
        if (e + 1 >= K) {
            int prod = 1;
            for (int i = e - K + 1; i <= e; i++) {
                prod *= stones[i];
            }
            return Math.min(merge(stones, b, e - K, K) * prod, merge(stones, b, e - 1, K))
        } else {

        }
    }
}
