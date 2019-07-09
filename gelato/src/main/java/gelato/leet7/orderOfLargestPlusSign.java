package gelato.leet7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//764
public class orderOfLargestPlusSign {
    public int orderOfLargestPlusSign_normal(int N, int[][] mines) {
        Set<Integer> banned = new HashSet();
        int[][] dp = new int[N][N];

        for (int[] mine : mines)
            banned.add(mine[0] * N + mine[1]);
        int ans = 0, count;

        for (int r = 0; r < N; ++r) {
            count = 0;
            //left
            for (int c = 0; c < N; ++c) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = count;
            }

            //right
            count = 0;
            for (int c = N - 1; c >= 0; --c) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }

        for (int c = 0; c < N; ++c) {
            //down
            count = 0;
            for (int r = 0; r < N; ++r) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
            //up
            count = 0;
            for (int r = N - 1; r >= 0; --r) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                ans = Math.max(ans, dp[r][c]);
            }
        }

        return ans;
    }

    //优化版 - 省了banned的hashmap
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], N);
        }

        for (int[] m : mines) {
            grid[m[0]][m[1]] = 0;
        }

        //因为对任意的i,j, 第一轮相当于走到它的时候判断其left的长度, 第二轮相当于right, 同理up. left
        for (int i = 0; i < N; i++) {
            for (int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) {
                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));  // left direction
                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));  // right direction
                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));  // up direction
                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));  // down direction
            }
        }

        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }

        return res;
    }
}
