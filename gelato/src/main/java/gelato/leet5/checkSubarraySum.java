package gelato.leet5;

import java.util.*;

public class checkSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        boolean res = false;
        if (k == 0) {
            for (int i = 1; i < nums.length; i++) {
                res = nums[i - 1] == 0 && nums[i] == 0;
            }
        } else {
            // if(k < 0 && k * 2 > k){k = k * 2;}
            HashMap<Integer, Integer> s = new HashMap<>();
            int sum = 0;
            int cnt = 0;
            for (int n : nums) {
                sum = (sum + n) % k;
                if ((sum == 0 && cnt > 0) || s.containsKey(sum)) {
                    res = s.get(sum) < cnt - 1;
                    if (res) break;
                } else {
                    s.put(sum % k, cnt);
                }
                cnt++;
            }
        }
        return res;
    }

    //Others
    public boolean checkSubarraySum_os(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};//0,-1就解决了需要判断k为0的问题.
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k; //存sum的时候, 可以直接%k, 因为(a -b) % k = (a%k - b%k)%k
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true;
            }
            else map.put(runningSum, i);
        }
        return false;
    }
}
