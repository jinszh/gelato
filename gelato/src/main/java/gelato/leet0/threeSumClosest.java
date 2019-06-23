package gelato.leet0;

import java.util.Arrays;

//16
public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = -1;
        for(int i = 0; i < nums.length; i++){
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum > target){
                    r--;
                }else {
                    l++;
                }
                if(Math.abs(sum - target) < min){
                    res = sum;
                    min = Math.abs(sum - target);
                }
            }
        }
        return res;
    }
}
