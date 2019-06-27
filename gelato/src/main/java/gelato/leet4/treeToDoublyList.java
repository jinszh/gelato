package gelato.leet4;

import gelato.model.TreeNode;

import java.util.LinkedList;

//426
public class treeToDoublyList {
    public TreeNode treeToDoublyList(TreeNode root) {
        TreeNode cur = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode res = new TreeNode();
        TreeNode prev = res;
        while (cur != null || !stack.isEmpty()){
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            prev.right = cur;
            cur.left = prev;
            prev = cur;
            cur = cur.right;
        }
        prev.right = res.right;
        res.right.left = prev;
        return res;
    }
}
