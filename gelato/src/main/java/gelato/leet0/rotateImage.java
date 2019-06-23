package gelato.leet0;

//48
public class rotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int n = matrix.length - 1;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - 2 * i - 1; j++) {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = swap;
            }
        }
    }
}
