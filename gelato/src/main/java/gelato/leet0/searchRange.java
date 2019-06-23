package gelato.leet0;

import static gelato.devUtil.DevUtil.*;

//34
public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[2];
        res[0] = binarySearchFirst(nums, target);
        res[1] = binarySearchLast(nums, target);
        return res;
    }


}
