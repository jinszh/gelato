package gelato.leet2;

public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] prodf = new int[nums.length + 1];
        int[] prodr = new int[nums.length + 1];
        prodf[0] = prodr[nums.length] = 1;
        for (int i = 0; i < nums.length; i++) {
            prodf[i + 1] = prodf[i] * nums[i];
            prodr[nums.length - i - 1] = prodr[nums.length - i] * nums[nums.length - i - 1];
        }
        int[] r = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            r[i] = prodf[i] * prodr[i + 1];
        }
        return r;
    }

    public int[] productExceptSelf_fast(int[] nums) { // 只需要正向的累乘, 反向的直接乘即可
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
