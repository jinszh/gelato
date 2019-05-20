package gelato.leet5;

import java.util.HashMap;

//525
public class findMaxLength {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int diff =0 , maxLen = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                diff++;
            }else {
                diff++;
            }
            if(map.containsKey(diff)) {
                maxLen = Math.max(maxLen, i - map.get(diff));
            }else {
                map.put(diff, i);
            }
        }
        return maxLen;
    }
}
