package gelato.leet2;

import java.util.Arrays;

public class ReversePairs {
    int count = 0;
    public int reversePairs(int[] nums) {
        mergeWithCount(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeWithCount(int [] nums, int l, int r) {
        if (r <= l) return;
        if (r == l + 1) {
            if ((long)nums[l] > 2 * (long)nums[r]) count++;
            if(nums[l] > nums[r]) {
                int swap = nums[l];
                nums[l] = nums[r];
                nums[r] = swap;
            }
        } else {
            int mid = (l + r) / 2;
            mergeWithCount(nums, l, mid);
            mergeWithCount(nums, mid + 1, r);
            int[] ls = Arrays.copyOfRange(nums, l, mid + 1);
            int[] rs = Arrays.copyOfRange(nums, mid + 1, r + 1);
            int i1 = 0, i2 = 0, i = l;
            int inc = 0;
            while (i1 < ls.length) {
                count += inc;
                while (i2 < rs.length && (long)ls[i1] > 2 * (long)rs[i2]) {
                    inc++;
                    i2++;
                    count++;
                }
                i1++;
            }
            i1 = 0;
            i2 = 0;

            while (i <= r && (i1 < ls.length || i2 < rs.length)) {
                if (i1 < ls.length && (i2 == rs.length || ls[i1] < rs[i2])) {
                    nums[i++] = ls[i1++];
                } else {
                    nums[i++] = rs[i2++];
                }
            }
        }
    }
}
