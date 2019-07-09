package gelato.leet1;

import gelato.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//103
public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> q1 = new LinkedList<>();
        LinkedList<TreeNode> q2 = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();
        q1.add(root);
        boolean odd = true;
        while (!q1.isEmpty()) {
            TreeNode h = q1.poll();
            //System.out.println(h.val);
            if (odd) {
                level.add(h.val);
            } else {
                level.addFirst(h.val);
            }
            if (h.left != null) {
                q2.add(h.left);
            }
            if (h.right != null) {
                q2.add(h.right);
            }
            if (q1.isEmpty()) {
                res.add(level);
                level = new LinkedList<>();
                q1 = q2;
                q2 = new LinkedList<>();
                odd = !odd;
            }
        }
        return res;
    }
}
