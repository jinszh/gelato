package gelato.leet3;

import gelato.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

//366
public class findLeaves {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        travel(root, res);
        return res;
    }

    private int travel(TreeNode root, List<List<Integer>> res) {
        if (root == null) return -1;
        int level;
        if (root.left == null && root.right == null) {
            level = 0;
        } else {
            level = Math.max(travel(root.left, res), travel(root.right, res)) + 1;
        }
        while (res.size() < level + 1) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        return level;
    }
}
