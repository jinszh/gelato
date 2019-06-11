package gelato.leet0;

import java.util.ArrayList;
import java.util.List;

//78
public class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            help(0, nums, res);
        }
        return res;
    }

    private void help(int idx, int[] nums, List<List<Integer>> res) {
        List<List<Integer>> toAdd = new ArrayList<>();
        for (List li : res) {
            List nl = new ArrayList(li);
            nl.add(nums[idx]);
            toAdd.add(nl);
        }
        res.addAll(toAdd);
    }
}
