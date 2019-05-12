package gelato.leet9;

import gelato.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class verticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        List<List<Integer>> levels = new LinkedList<>();
        res.add(new ArrayList<>());
        levels.add(new LinkedList<>());
        traverse(root, (LinkedList)res, (LinkedList)levels, 0, 0);
        return res;
    }

    private int traverse(TreeNode node, LinkedList<List<Integer>> lists, LinkedList<List<Integer>> levels, int idx, int level){
        if(lists.get(idx).size() > 0){
            int end = lists.get(idx).size() - 1;
            while (end >= 0 && (levels.get(idx).get(end) > level || (levels.get(idx).get(end) == level && lists.get(idx).get(end) > node.val))) {
                end--;
            }
            lists.get(idx).add(end + 1, node.val);
            levels.get(idx).add(end + 1, level);
        }else{
            lists.get(idx).add(node.val);
            levels.get(idx).add(level);
        }

        if(node.left != null) {
            int leftId = idx == 0 ? 0 : idx - 1;
            if (idx == 0) {
                lists.push(new LinkedList<>());
                levels.push(new LinkedList<>());
            }
            idx = traverse(node.left, lists, levels, leftId, level + 1) + 1;
        }
        if(node.right != null){
            int rightId = idx + 1;
            if(idx == lists.size() - 1){
                lists.add(new ArrayList<>());
                levels.add(new LinkedList<>());
            }
            idx = traverse(node.right, lists, levels, rightId, level + 1) - 1;
        }
        return idx;
    }
}
