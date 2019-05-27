package gelato.leet3;

import gelato.basic.BinaryIndexTree2D;

//Typical usage of binary index tree
public class NumMatrix_BITree {
    BinaryIndexTree2D binaryIndexTree2D;
    public NumMatrix_BITree(int[][] matrix) {
        binaryIndexTree2D = new BinaryIndexTree2D(matrix);
    }

    public void update(int row, int col, int val) {
        binaryIndexTree2D.update(row, col, val);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
       return binaryIndexTree2D.sumRegion(row1, col1, row2, col2);
    }
}
