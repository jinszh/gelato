package gelato.leet2;

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length > 0 && matrix[0].length > 0) {
            Integer v = biSearch(matrix, 0, matrix[0].length - 1, 0, matrix.length - 1, target);
            return v != null;
        }else {
            return false;
        }
    }

    private Integer biSearch(int[][] matrix, int x1, int x2, int y1, int y2, int target) {
        if (x1 == x2 && y1 == y2) {
            if (matrix[y1][x1] == target) {
                return matrix[y1][x1];
            } else {
                return null;
            }
        } else if (matrix[y1][x1] > target || matrix[y2][x2] < target) {
            return null;
        } else {
            int midx = (x1 + x2) / 2;
            int midy = (y1 + y2) / 2;
            if (matrix[midy][midx] > target) {
                Integer lu = y1 < midy ? biSearch(matrix, midx, x2, y1, midy - 1, target) : null;
                Integer rl = (lu == null && x1 < midx ? biSearch(matrix, x1, midx - 1, midy, y2, target) : lu);
                return rl == null && x1 < midx && y1 < midy ? biSearch(matrix, x1, midx - 1, y1, midy - 1, target) : rl;
            } else if (matrix[midy][midx] < target) {
                Integer lu = midx < x2 ? biSearch(matrix, midx + 1, x2, y1, midy, target) : null;
                Integer rl = (lu == null && midy < y2 ? biSearch(matrix, x1, midx, midy + 1, y2, target) : lu);
                return rl == null && midx < x2 && midy < y2 ? biSearch(matrix, midx + 1, x2, midy + 1, y2, target) : rl;
            } else {
                return matrix[midy][midx];
            }
        }
    }
}
