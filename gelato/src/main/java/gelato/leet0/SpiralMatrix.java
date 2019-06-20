package gelato.leet0;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0)return res;
        fill(0, matrix.length, matrix[0].length, res, matrix);
        return res;
    }

    private void fill(int s, int m, int n, List<Integer> res, int[][] matrix) {
        if(m == 1){
            for (int i = s; i < s + n; i++) {
                res.add(matrix[s][i]);
            }
        }else if(n == 1){
            for (int i = s; i < s + m; i++) {
                res.add(matrix[i][s]);
            }
        }else {
            for (int i = s; i < s + n; i++) {
                res.add(matrix[s][i]);
            }
            for (int i = s + 1; i < s + m; i++) {
                res.add(matrix[i][s + n - 1]);
            }
            for (int i = s + n - 2; i >= s; i--) {
                res.add(matrix[s + m - 1][i]);
            }
            for (int i = s + m - 2; i > s; i--) {
                res.add(matrix[i][s]);
            }
            if (n > 2 && m > 2) {
                fill(s + 1, m - 2, n - 2, res, matrix);
            }
        }
    }
}
