package gelato.leetCode;

import gelato.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        Stack<TreeNode> dfs = new Stack<>();
        if (root != null) {
            dfs.push(root);
            while (!dfs.empty()) {
                TreeNode n = dfs.peek();
                if (n.left == null && n.right == null) {
                    l.add(dfs.pop().val);
                    if (!dfs.empty()) {
                        while (!dfs.empty() &&
                                ((dfs.peek().right == n) || (dfs.peek().left == n && dfs.peek().right == null))) {
                            n = dfs.pop();
                            l.add(n.val);
                        }
                        if (!dfs.empty() && n == dfs.peek().left) {
                            dfs.push(dfs.peek().right);
                        }
                    }
                }
                else if (n.left != null) {
                    dfs.push(n.left);
                } else if (n.right != null) {
                    dfs.push(n.right);
                }
            }
        }
        return l;
    }
}