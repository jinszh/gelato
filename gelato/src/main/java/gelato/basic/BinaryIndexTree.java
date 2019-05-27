package gelato.basic;

public class BinaryIndexTree {
    public BinaryIndexTree(int [] arr){
        constructBITree(arr);
    }

    //BITree implementation -----------------------------------------
    //虽然叫binary index tree, 但不一定是binary tree, 有些节点可能>2子节点
    private void constructBITree(int [] arr) {
        this.len = arr.length;
        bitree = new int[len + 1];
        this.nums = new int[len];
        for (int i = 0; i < arr.length; i++) {
            updateBITree(i, arr[i]);
        }
    }

    public void updateBITree(int i, int diff){
        int index = i + 1;
        while (index <= len){
            bitree[index] += diff;
            index += index & (-index);
        }
        nums[i] += diff;
    }

    public int getRangeSum(int s, int e){
        return getSum(e) - getSum(s);
    }

    private int getSum(int i) {
        int sum = 0;
        int index = i + 1;
        while (index > 0) {
            sum += bitree[index];
            index -= index & (-index);
        }
        return sum;
    }

    private int [] nums;
    private int [] bitree;
    private int len;
}
