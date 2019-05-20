package gelato.leet3;

import java.util.HashMap;

//325
public class maxSubArrayLen {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, maxLen =0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                maxLen = Math.max(i - map.get(sum - k), maxLen);
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
