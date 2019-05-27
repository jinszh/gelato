package gelato.basic;

//https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
public class SegmentTree1D {
    //segmenttree是一颗full tree但不是一颗complete tree
    public SegmentTree1D(int [] arr) {
        len = arr.length;
        int maxtlen = (int) Math.pow(2, Math.ceil(Math.log(arr.length) / Math.log(2)));
        if (len > 0) {
            st = new int[2 * maxtlen - 1];
            this.nums = arr;
            constructTree(0, arr.length - 1, 0);
        }
    }

    public void update(int i, int val) {
        updateTree(0, len - 1, 0, i, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return getRangeSum(i, j,0, len - 1, 0);
    }

    private int constructTree(int s, int e, int sti) {
        if (s == e) {
            st[sti] = nums[s];
        } else {
            int mid = getMid(s, e);
            st[sti] = constructTree(s, mid, 2 * sti + 1)
                    + constructTree(mid + 1, e, 2 * sti + 2);
        }
        return st[sti];
    }

    private void updateTree(int s, int e, int sti, int i, int diff) {
        if (i < s || i > e) {
            return;
        }
        st[sti] += diff;
        if(s < e) {
            int mid = getMid(s, e);
            updateTree(s, mid, 2 * sti + 1, i, diff);
            updateTree(mid + 1, e, 2 * sti + 2, i, diff);
        }
    }

    private int getRangeSum(int qs, int qe, int s, int e, int sti){
        if(qe < s || qs > e){
            return 0;
        }
        if(s >= qs && e <= qe){
            return st[sti];
        }else {
            int mid = getMid(s, e);
            return getRangeSum(qs, qe, s, mid, sti * 2 + 1)
                    + getRangeSum(qs, qe, mid + 1, e, sti * 2 + 2);
        }
    }

    private int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    int [] st;
    int [] nums;
    int len;
}
