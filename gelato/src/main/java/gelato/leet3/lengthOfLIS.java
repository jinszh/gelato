package gelato.leet3;

//300
public class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int [] dp = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            int max = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] < nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            res = Math.max(res, max);
        }
        return res;
    }
}
