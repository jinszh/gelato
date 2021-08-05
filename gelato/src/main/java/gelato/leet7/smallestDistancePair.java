package gelato.leet7;

import gelato.devUtil.DevUtil;

import java.util.Arrays;
import java.util.PriorityQueue;

//719
public class smallestDistancePair {
    //题目的转换, 相当于把通过k找x, 变换成通过x找k
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, h = nums[nums.length - 1] - nums[0];
        while (l < h) {
            int mid = (h + l) / 2;
            int nmid = 0;
            for (int i = 0; i < nums.length; i++) {
                int to = DevUtil.binarySearchLast(nums, nums[i] + mid);//不能用Arrays.binarySearch因为结果可能随机,不一定第一个也不一定最后一个
                if (to < 0) {
                    to = -to - 2;
                }
                nmid += (to - i);

            }
            if (nmid < k) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }
}
