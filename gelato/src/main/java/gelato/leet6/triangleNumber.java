package gelato.leet6;

import gelato.devUtil.DevUtil;

import java.util.Arrays;

//611
public class triangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                int sum = nums[i] + nums[j];
                int pos = DevUtil.binarySearchLast(nums, sum - 1);
                if (pos < 0) {
                    pos = -pos - 2;
                }
                res += pos - i;
            }
        }
        return res;
    }

    //O(n^2)的解法
    public static int triangleNumber_3(int[] A) {
        Arrays.sort(A);
        int count = 0, n = A.length;
        for (int i=n-1;i>=2;i--) {
            int l = 0, r = i-1;
            while (l < r) {
                if (A[l] + A[r] > A[i]) {//不需要search, 直接判断即可
                    count += r-l;
                    r--;
                }
                else l++;
            }
        }
        return count;
    }
}
