package gelato.leet3;

//304
public class NumMatrix_304 {
    int [][] sum;
    public NumMatrix_304(int[][] matrix) {
        if(matrix == null)return;
        sum = new int[matrix.length][matrix[0].length];
        int cur = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                cur += matrix[i][j];
                sum[i][j] = cur - (i > 0 ? (sum[i - 1][matrix[0].length - 1] - sum[i - 1][j]) : 0);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2][col2] + (row1 > 0 && col1 > 0 ? sum[row1 - 1][col1 - 1] : 0)
                - (row1 > 0 ? sum[row1 - 1][col2] : 0) - (col1 > 0 ? sum[row2][col1 - 1] : 0);
    }
}
