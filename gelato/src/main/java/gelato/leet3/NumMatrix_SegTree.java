package gelato.leet3;

import gelato.basic.SegmentTree2D;

//308
public class NumMatrix_SegTree {
    SegmentTree2D segmentTree2D;

    public NumMatrix_SegTree(int[][] matrix) {
        if (matrix == null) return;
        segmentTree2D = new SegmentTree2D(matrix);
    }

    public void update(int row, int col, int val) {
        segmentTree2D.update(row, col, val);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return segmentTree2D.sumRegion(row1, col1, row2, col2);
    }
}
