package gelato.leet0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//18
public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int l1 = 0, r1 = nums.length - 1;
        while (l1 < r1 - 2) {
            while (l1 < r1 - 2) {
                int l = l1 + 1, r = r1 - 1;
                int t = target - nums[l1] - nums[r1];
                while (l < r) {
                    if (nums[l] + nums[r] < t) {
                        l++;
                    } else if (nums[l] + nums[r] > t) {
                        r--;
                    } else {
                        List<Integer> list = Arrays.asList(nums[l1], nums[l], nums[r], nums[r1]);
                        res.add(list);
                        while (l < r && nums[l + 1] == nums[l]) l++;
                        l++;
                        r--;
                    }
                }
                while (l1 < r1 && nums[l1 + 1] == nums[l1]) l1++;
                l1++;
            }
            while (2 < r1 && nums[r1 - 1] == nums[r1]) r1--;
            r1--;
            l1 = 0;
        }
        return res;
    }
}