package gelato.leet7;

public class numSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod = 1;
        int nans = 0;

        int i = 0, j = 0;
        for (; i < nums.length; i++) {
            prod *= nums[i];
            while (j <= i && prod >= k) {
                prod /= nums[j];
                j++;
            }
            nans += (i - j + 1);
        }
        return nans;
    }
}
