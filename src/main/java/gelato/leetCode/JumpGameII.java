package gelato.leetCode;

import java.util.Arrays;

public class JumpGameII {
    public int jump(int[] nums) {
        int[] steps = new int[nums.length];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = Math.min(nums.length - 1, i + nums[i]); j > i ; j--) {
                if (steps[j] < Integer.MAX_VALUE && 1 + steps[j] < steps[i]) {
                    steps[i] = 1 + steps[j];
                }
            }
        }
        return steps[0];
    }

    public int jump_simpleGreedy(int[] nums) { // This simple greedy is better
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
