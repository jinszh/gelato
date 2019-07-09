package gelato.leet7;

import gelato.util.Util;

import java.util.Arrays;

//740
public class deleteAndEarn {
    int[] memo;

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return computeSum(nums, nums.length - 1);
    }

    private int computeSum(int[] nums, int i) {
        if (i < 0) return 0;
        if (memo[i] >= 0) return memo[i];
        int sum = 0;

        int j = i - 1;
        while (j >= 0 && nums[j] == nums[i]) j--;
        if (j >= 0 && nums[j] + 1 == nums[i]) {
            int k = j;
            while (j >= 0 && nums[j] + 1 == nums[i]) j--;
            sum = Math.max(nums[i] * (i - k) + computeSum(nums, j), computeSum(nums, k));
        } else {
            sum += nums[i] * (i - j) + computeSum(nums, j);
        }

        memo[i] = sum;
        return sum;
    }

    //不用sort, 通过到bucket可以优化到O(n) - 当前一个元素的take相当于前面一个元素的skip, 当前元素的skip相当于前面的skip和take中的大的
    public int deleteAndEarn2(int[] nums) {
        int n = 10001;
        int[] values = new int[n];
        for (int num : nums)
            values[num] += num; //计算duplicate的sum

        int take = 0, skip = 0;
        for (int i = 0; i < n; i++) {
            int takei = skip + values[i];
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }
        return Math.max(take, skip);
    }
}
