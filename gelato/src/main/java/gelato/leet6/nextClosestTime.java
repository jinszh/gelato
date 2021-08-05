package gelato.leet6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class nextClosestTime {
    public String nextClosestTime(String time) {
        int[] nums = new int[]{time.charAt(0) - '0'
                , time.charAt(1) - '0', time.charAt(3) - '0', time.charAt(4) - '0'};
        int[] res = Arrays.copyOfRange(nums, 0, nums.length);
        int[] max = new int[]{2, 9, 6, 9};
        int[] max2 = new int[]{2, 4, 6, 0};
        Arrays.sort(nums);
        for (int i = 3; i >= 0; i--) {
            int h = i > 0 && res[i - 1] == max[i - 1] ? max2[i] : max[i];
            int j = 0;
            for (; j < nums.length; j++) {
                if (nums[j] <= h && nums[j] > res[i]) {
                    res[i] = nums[j];
                    break;
                }
            }
            if (j == nums.length) {
                for (int k = 0; k < nums.length; k++) {
                    if (nums[k] <= h) {
                        res[i] = nums[k];
                        break;
                    }
                }
            }else {
                break;
            }
        }
        return String.format("%d%d:%d%d", res[0], res[1], res[2], res[3]);
    }
}
