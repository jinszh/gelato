package gelato.leet6;

import java.util.HashMap;

//666
public class pathSum {
    public int pathSum(int[] nums) {
        if (nums.length == 0) return 0;
        int[] sum = new int[nums.length];
        boolean[] notleaf = new boolean[nums.length];
        int pathsum = sum[0] = nums[0] % 10;
        int j = 0, i = 1;
        for (; i < nums.length; i++) {
            int par = (nums[i] - 100) / 100 * 10 + (((nums[i] % 100) + 10) / 20);
            while (par > (nums[j] / 10)) j++;
            sum[i] = sum[j] + nums[i] % 10;
            pathsum += sum[i];
            if (!notleaf[j]) {
                notleaf[j] = true;
                pathsum -= sum[j];
            }
        }
        return pathsum;
    }
}
