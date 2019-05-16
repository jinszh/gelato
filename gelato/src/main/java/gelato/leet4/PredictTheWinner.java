package gelato.leet4;

public class PredictTheWinner {
    Integer [][] dp;
    int [] prefix;
    public boolean PredictTheWinner(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        dp = new Integer[nums.length][nums.length];
        return calc(nums, 0, nums.length - 1) * 2 >= prefix[nums.length];
    }

    private int calc(int [] nums, int b, int e){
        if(dp[b][e] !=  null) return dp[b][e];
        int res;
        if (b == e) {
            res = nums[b];
        }else {
            int lres = nums[b] + (prefix[e + 1] - prefix[b + 1]) - calc(nums, b + 1, e);
            int rres = nums[e] + (prefix[e] - prefix[b]) - calc(nums, b, e - 1);
            res = Math.max(lres, rres);
        }
        dp[b][e] = res;
        return res;
    }
}
