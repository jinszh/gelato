package gelato.basic;

public class BinaryIndexTree2D {
    //相对于segment tree实现起来非常简单, 存储空间更小, 效率也高
    public BinaryIndexTree2D(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        this.mat = matrix;
        construct2DBITree(mat);
    }

    public void update(int row, int col, int val) {
        updateBIT(row, col, val - mat[row][col]);
        mat[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) + getSum(row1 - 1, col1 - 1)
                - getSum(row1 - 1, col2) - getSum(row2, col1 - 1);
    }

    public void updateBIT(int x, int y, int diff){
        x++;
        int yindex = y+1;
        for(; x < bit.length;){
            for(y = yindex; y < bit[0].length;){
                bit[x][y] += diff;
                y += (y & -y);
            }
            x += (x & -x);
        }
    }

    public int getSum(int x, int y) {
        int sum = 0, xindex = x + 1, yindex = y + 1;
        for (x = xindex; x > 0; ) {
            for (y = yindex; y > 0; ) {
                sum += bit[x][y];
                y -= (y & -y);
            }
            x -= (x & -x);
        }
        return sum;
    }

    private void construct2DBITree(int [][] mat){
        bit = new int[mat.length + 1][mat[0].length + 1];

        for(int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                updateBIT(i, j, mat[i][j]);
            }
        }
    }
    int [][] bit;
    int [][] mat;
}
