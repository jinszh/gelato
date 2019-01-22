package gelato.leet2;

import java.util.Arrays;

public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        if(matrix.length > 0) {
            int[][] maxLen = new int[matrix.length][matrix[0].length];
            for (int[] vec : maxLen) {
                Arrays.fill(vec, 0);
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (max < DFS(matrix, i, j, maxLen)) {
                        max = maxLen[i][j];
                    }
                }
            }
        }
        return max;
    }

    private int DFS(int[][] matrix, int i, int j, int [][] maxLen) {
        if (maxLen[i][j] > 0) return maxLen[i][j];
        int up, down, left, right;
        up = (i > 0 && matrix[i - 1][j] > matrix[i][j]) ? DFS(matrix, i - 1, j, maxLen) : 0;
        down = (i < matrix.length - 1 && matrix[i + 1][j] > matrix[i][j]) ? DFS(matrix, i + 1, j, maxLen) : 0;
        left = (j > 0 && matrix[i][j - 1] > matrix[i][j]) ? DFS(matrix, i, j - 1, maxLen) : 0;
        right = (j < matrix[0].length - 1 && matrix[i][j + 1] > matrix[i][j]) ? DFS(matrix, i, j + 1, maxLen) : 0;
        maxLen[i][j] = Math.max(Math.max(left, right), Math.max(up, down)) + 1;
        return maxLen[i][j];
    }
}
