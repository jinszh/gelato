package gelato.leet1;

import java.util.ArrayList;
import java.util.List;

//163
public class findMissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0){
            res.add(lower != upper ? Integer.toString(lower) + "->" + Integer.toString(upper) :Integer.toString(upper));
            return res;
        }
        int i = 0;
        int next = lower - 1;
        while (nums[i] < lower && i < nums.length) i++;
        for( ; i <nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1])continue;
            next++;
            if (nums[i] > next) {
                if (nums[i] - 1 > next) {
                    res.add(Integer.toString(next) + "->" + Integer.toString(nums[i] - 1));
                } else {
                    res.add(Integer.toString(next));
                }
            }
            next = nums[i];
        }
        if(next < upper){
            res.add(upper > next + 1 ? Integer.toString(next + 1) + "->" + Integer.toString(upper) : Integer.toString(upper));
        }
        return res;
    }
}
