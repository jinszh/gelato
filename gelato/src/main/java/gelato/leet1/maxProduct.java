package gelato.leet1;

public class maxProduct {
    public int maxProduct(int[] nums) {
        Integer pos = null, neg = null, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (nums[i] > 0) {
                    pos = (pos == null ? nums[i] : pos * nums[i]);
                    neg = (neg == null ? null : neg * nums[i]);
                } else {
                    int swap = (pos == null ? nums[i] : pos * nums[i]);
                    pos = neg == null ? null : neg * nums[i];
                    neg = swap;
                }
                max = Math.max(pos != null ? pos : max, Math.max(max, neg != null ? neg : max));
            } else {
                pos = neg = null;
                max = Math.max(0, max);
            }
        }
        return max;
    }

    public int maxProduct_simple(int[] nums) {
        int r = nums[0];
        for (int i = 1, imax = r, imin = r; i < nums.length; i++) {
            if (nums[i] < 0) {
                int swap = imax;
                imax = imin;
                imin = swap;
            }
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);
            r = Math.max(r, imax);
        }
        return r;
    }
}
