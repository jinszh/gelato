package gelato.leet0;

import java.util.Arrays;

//64
public class minPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int n = grid[0].length;
        int[] cnt = new int[n];
        int[] cnt2 = new int[n];
        Arrays.fill(cnt, Integer.MAX_VALUE);
        cnt[n - 1] = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            cnt2[n - 1] = cnt[n - 1] + grid[i][n - 1];
            for (int j = n - 2; j >= 0; j--) {
                cnt2[j] = Math.min(cnt[j], cnt2[j + 1]) + grid[i][j];
            }
            cnt = cnt2;
        }
        return cnt[0];
    }
}
