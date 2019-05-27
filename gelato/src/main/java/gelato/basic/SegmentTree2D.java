package gelato.basic;

public class SegmentTree2D {
    //Segment tree implementation -------------
    public SegmentTree2D(int [][] mat) {
        if (mat.length > 0 && mat[0].length > 0) {
            int maxr = (int) Math.pow(2, Math.ceil(Math.log(mat.length) / Math.log(2)));
            int maxc = (int) Math.pow(2, Math.ceil(Math.log(mat[0].length) / Math.log(2)));
            st = new int[2 * maxr - 1][2 * maxc - 1];
            this.mat = mat;
            constructTree(0, mat.length - 1, 0, mat[0].length - 1, 0, 0);
        }
    }

    private int constructTree(int si, int ei, int sj, int ej, int sti, int stj) {
        if (si == ei && sj == ej) {
            st[sti][stj] += mat[si][sj];
        } else if (si < ei) { //construct rows
            int midi = getMid(si, ei);
            constructTree(si, midi, sj, ej, 2 * sti + 1, stj);
            constructTree(midi + 1, ei, sj, ej, 2 * sti + 2, stj);
            for (int j = 0; j < st[0].length; j++) { // fill columns for each row
                st[sti][j] += (st[2 * sti + 1][j] + st[2 * sti + 2][j]);
            }
        } else { // si == ei (1) construct columns
            int midj = getMid(sj, ej);
            st[sti][stj] += constructTree(si, ei, sj, midj, sti, 2 * stj + 1)
                    + constructTree(si, ei, midj + 1, ej, sti, 2 * stj + 2);
        }
        return st[sti][stj];
    }

    public void update(int row, int col, int val) {
        updateTree(0, mat.length - 1, 0, mat[0].length - 1, 0, 0, row, col, val - mat[row][col]);
        mat[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getRangeSum(row1, row2, col1, col2, 0, mat.length - 1, 0, mat[0].length - 1, 0, 0);
    }

    private void updateTree(int si, int ei, int sj, int ej, int sti, int stj, int i, int j, int diff) {
        if (i < si || i > ei || j < sj || j > ej) {
            return;
        }
        st[sti][stj] += diff;
        if (si < ei && stj == 0) { // choose row -> stj == 0 表明是选row
            int midi = getMid(si, ei);
            updateTree(si, midi, sj, ej, 2 * sti + 1, stj, i, j, diff);
            updateTree(midi + 1, ei, sj, ej, 2 * sti + 2, stj, i, j, diff);
        }
        if(sj < ej) {
            //update each column
            int midj = getMid(sj, ej);
            updateTree(si, ei, sj, midj, sti, 2 * stj + 1, i, j, diff);
            updateTree(si, ei, midj + 1, ej, sti, 2 * stj + 2, i, j, diff);
        }
    }

    public int getRangeSum(int qsi, int qei, int qsj, int qej, int si, int ei, int sj, int ej, int sti, int stj) {
        if (qei < si || qsi > ei || qej < sj || qsj > ej) {
            return 0;
        }
        if (si >= qsi && ei <= qei && sj >= qsj && ej <= qej) {
            return st[sti][stj];
        } else if (si < qsi || ei > qei) {
            int midi = getMid(si, ei);
            return getRangeSum(qsi, qei, qsj, qej, si, midi, sj, ej, 2 * sti + 1, stj)
                    + getRangeSum(qsi, qei, qsj, qej, midi + 1, ei, sj, ej, 2 * sti + 2, stj);
        } else {
            int midj = getMid(sj, ej);
            return getRangeSum(qsi, qei, qsj, qej, si, ei, sj, midj, sti, 2 * stj + 1)
                    + getRangeSum(qsi, qei, qsj, qej, si, ei,midj + 1, ej, sti, 2 * stj + 2);
        }
    }

    private int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    int [][] st;
    int [][] mat;
}
