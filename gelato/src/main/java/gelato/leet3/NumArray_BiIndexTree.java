package gelato.leet3;

import gelato.basic.BinaryIndexTree;

//307
public class NumArray_BiIndexTree {
    int [] nums;
    public NumArray_BiIndexTree(int[] nums) {
        this.nums = nums;
        tree = new BinaryIndexTree(nums);
    }

    public void update(int i, int val) {
        tree.updateBITree(i, val - nums[i]);
    }

    public int sumRange(int i, int j) {
        return tree.getRangeSum(i - 1, j);
    }

    private BinaryIndexTree tree;
}
