package gelato.leet2;

public class SplitArrayLargestSum {
    Integer [][] memo;
    public int splitArray(int [] nums, int m){
        memo = new Integer[nums.length][m + 1];
        int [] sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        return findMin(sums, nums.length - 1, m);
    }

    private int findMin(int [] sums, int end, int m) {
        int min = end == 0 || m == 1 ? sums[end] : Integer.MAX_VALUE;
        for (int i = end - 1; m > 1 && i >= m - 2; i--) {
            int right = sums[end] - sums[i];
            int left = memo[i][m - 1] != null ? memo[i][m - 1] : findMin(sums, i, m - 1);
            min = Math.min(min, Math.max(right, left));
        }
        memo[end][m] = min;
        return min;
    }
}
