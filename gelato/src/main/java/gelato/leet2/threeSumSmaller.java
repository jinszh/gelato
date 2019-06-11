package gelato.leet2;

import java.util.Arrays;

//259
public class threeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);//重点: 有没有sort triples的数量是相同的!!! sort过后状态就不同了
        int len = nums.length;

        for(int i=0; i<len-2; i++) {
            int left = i+1, right = len-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < target) {//有些小优化不用考虑, 关键是逻辑要清楚
                    count += right-left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}
