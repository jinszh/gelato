package gelato.leet1;

import gelato.model.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//199
public class rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)return  res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int l1 = 1, l2 = 0;
        while (!queue.isEmpty()) {
            TreeNode h = queue.pollFirst();
            l1--;
            if (h.left != null) {
                queue.add(h.left);
                l2++;
            }
            if (h.right != null) {
                queue.add(h.right);
                l2++;
            }
            if (l1 == 0) {
                res.add(h.val);
                l1 = l2;
                l2 = 0;
            }
        }
        return res;
    }
}
