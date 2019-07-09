package gelato.leet5;

import java.util.Arrays;

//542
public class updateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix[0].length - 1;
        int n = matrix.length - 1;

        int[][] res = new int[n][m];
        for (int[] l : res) Arrays.fill(l, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            int distl = Integer.MAX_VALUE, distr = Integer.MAX_VALUE;
            for (int j = 0; j <= m; j++) {
                distl = matrix[i][j] == 0 ? 0 : Math.min(res[i][j], distl < Integer.MAX_VALUE ? distl + 1 : distl);
                res[i][j] = Math.min(distl, res[i][j]);
                distr = matrix[i][m - j] == 0 ? 0 : Math.min(res[i][m - j], distr < Integer.MAX_VALUE ? distr + 1 : distr);
                res[i][m - j] = Math.min(distr, res[i][m - j]);
            }
        }

        for (int j = 0; j <= m; j++) {
            int distd = Integer.MAX_VALUE, distu = Integer.MAX_VALUE;
            for (int i = 0; i <= n; i++) {
                distd = matrix[i][j] == 0 ? 0 : Math.min(res[i][j], distd < Integer.MAX_VALUE ? distd + 1 : distd);
                res[i][j] = Math.min(distd, res[i][j]);
                distu = matrix[n - i][j] == 0 ? 0 : Math.min(res[n - i][j], distu < Integer.MAX_VALUE ? distu + 1 : distu);
                res[n - i][j] = Math.min(distu, res[n - i][j]);
            }
        }
        return res;
    }
}
