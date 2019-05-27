package gelato.leet3;

//307
//Typical usage of segment tree

import gelato.basic.SegmentTree1D;

public class NumArray_SegmentTree {
    SegmentTree1D segmentTree1D;
    public NumArray_SegmentTree(int[] nums) {
        segmentTree1D = new SegmentTree1D(nums);
    }

    public void update(int i, int val) {
        segmentTree1D.update(i, val);
    }

    public int sumRange(int i, int j) {
        return segmentTree1D.sumRange(i, j);
    }
}
