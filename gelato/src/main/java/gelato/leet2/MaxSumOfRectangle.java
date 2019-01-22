package gelato.leet2;

import java.util.TreeSet;

public class MaxSumOfRectangle {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length, ans = Integer.MIN_VALUE;
        for (int left = 0; left < col; left++) {
            int[] sum = new int[row];
            for (int right = left; right < col; right++) {
                for (int r = 0; r < row; r++) {
                    sum[r] += matrix[r][right];
                }
                TreeSet<Integer> curSums = new TreeSet<Integer>();
                curSums.add(0);
                int curMax = Integer.MIN_VALUE, cum = 0;
                for (int s : sum) {
                    cum += s;
                    Integer val = curSums.ceiling(cum - k);
                    if (val != null) curMax = Math.max(curMax, cum - val);
                    curSums.add(cum);
                }
                ans = Math.max(ans, curMax);
            }
        }
        return ans;
    }
}
