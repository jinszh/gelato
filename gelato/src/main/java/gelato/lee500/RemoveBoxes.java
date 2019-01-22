package gelato.lee500;

public class RemoveBoxes {
    //如果不是自包含的可以划分成子问题的, 就改变定义, 使其变得自包含!!
    //If the problem is not self-contained
    // modify the definition of the problem to absorb the external information so that the new one is self-contained.
    //https://leetcode.com/problems/remove-boxes/discuss/101310/Java-top-down-and-bottom-up-DP-solutions
    //这里的拆分就是拆成 前面有多少个相同颜色盒子的情况, 然后就可以子问题相加了
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];

        for (int j = 0; j < n; j++) {
            for (int k = 0; k <= j; k++) {
                dp[j][j][k] = (k + 1) * (k + 1);
            }
        }

        for (int l = 1; l < n; l++) {
            for (int j = l; j < n; j++) {
                int i = j - l;

                for (int k = 0; k <= i; k++) {
                    int res = (k + 1) * (k + 1) + dp[i + 1][j][0];

                    for (int m = i + 1; m <= j; m++) {
                        if (boxes[m] == boxes[i]) {
                            res = Math.max(res, dp[i + 1][m - 1][0] + dp[m][j][k + 1]);
                        }
                    }

                    dp[i][j][k] = res;
                }
            }
        }

        return (n == 0 ? 0 : dp[0][n - 1][0]);
    }
}
