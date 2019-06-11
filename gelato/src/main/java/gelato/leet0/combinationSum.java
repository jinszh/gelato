package gelato.leet0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//39
public class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        help(0, candidates, 0, target, new LinkedList<Integer>(), res);
        return res;
    }

    private void help(int idx, int [] can, int sum, int target, LinkedList<Integer> cur, List<List<Integer>> res) {
        for (int i = idx; i < can.length; i++) {
            if (sum + can[i] <= target) {
                cur.add(can[i]);
                if (sum + can[i] == target) {
                    res.add(new ArrayList<>(cur));
                } else {
                    help(i, can, sum + can[i], target, cur, res);
                }
                cur.removeLast();
            } else {
                break;
            }
        }
    }
}
