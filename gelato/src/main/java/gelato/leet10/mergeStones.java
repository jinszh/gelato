package gelato.leet10;

import java.util.Arrays;

public class mergeStones {
    /***
     * Mine
     */
    Integer [][][] cost; //可以优化: cost其实不需要用三维数组, 见后面
    Integer [][] weight; //优化 - 可以用prefix替代sum
    int K;
    public int mergeStones(int[] stones, int K) {
        this.K = K;
        cost = new Integer[stones.length][stones.length][K + 1];
        weight = new Integer[stones.length][stones.length];
        for(int i = 0; i < stones.length; i++) {
            for (int j = i; j < stones.length; j++) {
                weight[i][j] = (j > i ? weight[i][j - 1] : 0) + stones[j];
            }
        }
        merge(stones, 0, stones.length - 1, 1);
        return cost[0][stones.length - 1][1];
    }

    private int merge(int [] stones, int b, int e, int target) {
        if (cost[b][e][target] != null) return cost[b][e][target];
        int n = e - b + 1;
        if ((n < K && n != target) || (n == K && target != 1)) {
            cost[b][e][target] = -1;
        } else if ((n == K && target == 1) || (target == n)) {
            int sum = 0;
            for (int i = b; i <= e; i++) {
                sum += stones[i];
            }
            if (target == n) {
                cost[b][e][target] = 0;
            } else {
                cost[b][e][target] = sum;
            }
        } else {
            int rem = n;
            while (rem >= K) {
                rem = (rem / K + rem % K) ;
            }
            if (rem != target) {
                cost[b][e][target] = -1;
            } else {
                int sum = Integer.MAX_VALUE;
                if (target == 1) {
                    for (int i = b; i < e; i++) {
                        for (int j = 1; j < K; j++) {
                            int l = merge(stones, b, i, j);
                            int r = merge(stones, i + 1, e, K - j);
                            if (l >= 0 && r >= 0 && sum > l + r + weight[b][e]) {
                                sum = cost[b][e][target] = l + r + weight[b][e];
                            }
                        }
                    }
                } else {
                    for (int i = b; i < e; i++) {
                        int l = merge(stones, b, i, 1);
                        int r = merge(stones, i + 1, e, target - 1);
                        if (l >= 0 && r >= 0 && sum > l + r) {
                            sum = cost[b][e][target] = l + r;
                        }
                    }
                }
                cost[b][e][target] = sum < Integer.MAX_VALUE ? sum : -1;
            }
        }
        return cost[b][e][target];
    }

    /**
     * 优化版 - dp[i][j]表示{i,j}之间merge到不能merge的时候的值
     */
    public int mergeStones_optmized(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) > 0) return -1; //每次少K-1个数, 如果最后剩下的不是1个数,就无解

        int[] prefix = new int[n+1];
        for (int i = 0; i <  n; i++)
            prefix[i + 1] = prefix[i] + stones[i];//prefix weight

        int[][] dp = new int[n][n];
        for (int m = K; m <= n; ++m)
            for (int i = 0; i + m <= n; ++i) {
                int j = i + m - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int mid = i; mid < j; mid += K - 1)
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j]);
                if ((j - i) % (K - 1) == 0) // 正好可以merge成一堆, 所以需要加上weight
                    dp[i][j] += prefix[j + 1] - prefix[i];
            }
        return dp[0][n - 1];
    }
}
