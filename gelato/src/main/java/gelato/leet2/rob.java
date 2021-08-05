package gelato.leet2;

//213
public class rob {
    int [][][] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length][2][2];
        int [] f1 = rob(nums, 0, nums.length - 2);
        int [] f2 = rob(nums, 1, nums.length - 1);
        return Math.max(f1[0], Math.max(f2[0], f2[1]));
    }

    public int[] rob(int[] nums, int i, int max) {
        if (memo[i][nums.length - 1 - max] != null) return memo[i][nums.length - 1 - max];
        if (i > max || i == nums.length) return new int[]{0, 0};
        memo[i][nums.length - 1 - max] = new int[]{nums[i] + rob(nums, i + 1, max)[1]
                , Math.max(rob(nums, i + 1, max)[0], rob(nums, i + 1, max)[1])};
        return memo[i][nums.length - 1 - max];
    }


    //优化: 并不需要递归或者dp, 也不需要额外空间 ... 因为含当前节点与不含只需要简单比较即可
    public int rob2(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob2(nums, 0, nums.length - 2), rob2(nums, 1, nums.length - 1));
    }

    private int rob2(int[] num, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + num[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }
}
