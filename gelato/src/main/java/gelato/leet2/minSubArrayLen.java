package gelato.leet2;

import java.util.Arrays;

//209
public class minSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] sum = new int[nums.length + 1];
        int minlen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
            if (sum[i + 1] >= s) {
                int start = Arrays.binarySearch(sum, 0, i + 1, sum[i + 1] - s);
                minlen = Math.min(start < -1 ? i + 1 + start - 2 : i + 1 - start, minlen);
            }
        }
        return minlen < Integer.MAX_VALUE ? minlen : 0;
    }

    //two pointer的方法是O(N)的!!!
    public int minSubArrayLen_ON(int s, int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
