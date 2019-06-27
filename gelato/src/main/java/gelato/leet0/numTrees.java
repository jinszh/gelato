package gelato.leet0;

//96
public class numTrees {
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            int res = 0;
            for (int j = 1; j <= i; j++) {
                res += nums[j - 1] * nums[i - j];
            }
            nums[i] = res;
        }
        return nums[n];
    }
}
