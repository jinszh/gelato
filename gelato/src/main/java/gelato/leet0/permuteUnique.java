package gelato.leet0;

import java.util.*;

//47
public class permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        help(0, used, nums, new LinkedList<>(), res);
        return res;
    }

    private void help(int idx, boolean [] used, int [] nums, LinkedList<Integer> cur, List<List<Integer>> res){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < used.length; i++) {
            if (!used[i] && !set.contains(nums[i])) {
                set.add(nums[i]);
                cur.add(nums[i]);
                used[i] = true;
                if (idx == nums.length - 1) {
                    res.add(new ArrayList<>(cur));
                } else {
                    help(idx + 1, used, nums, cur, res);
                }
                used[i] = false;
                cur.removeLast();
            }
        }
    }
}
