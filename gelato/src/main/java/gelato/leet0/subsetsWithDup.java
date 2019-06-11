package gelato.leet0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90
public class subsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> toAdd = new ArrayList<>();
            for (List<Integer> li : res) {
                List nl = new ArrayList(li);
                for (int j = i; j < nums.length && nums[j] == nums[i]; j++) {
                    nl.add(nums[i]);
                    toAdd.add(new ArrayList<>(nl));
                }
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
            res.addAll(toAdd);
        }
        return res;
    }
}
