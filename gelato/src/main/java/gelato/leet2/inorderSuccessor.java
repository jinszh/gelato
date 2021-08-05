package gelato.leet2;

import gelato.model.TreeNode;

import java.util.LinkedList;

//285
public class inorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode res = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode h = stack.peek();
            if(h == p){
                return h.right;
            }else if(h.left == p) {
                if (h.left.right != null) {
                    res = h.left.right;
                    while (res.left != null) res = res.left;
                } else {
                    res = h;
                }
                break;
            }
            if (h.right != null && h.right == p) {
                if (h.right.right != null) {
                    res = h.right.right;
                    while (res.left != null) res = res.left;
                }else {
                    stack.poll();
                    while (!stack.isEmpty()) {
                        if (h == stack.peek().left) {
                            res = stack.peek();
                            break;
                        } else {
                            h = stack.poll();
                        }
                    }
                }
                break;
            }
            if (h.left != null) {
                stack.push(h.left);
            } else if (h.right != null) {
                stack.push(h.right);
            } else {
                stack.poll();
                while (!stack.isEmpty()
                        && (h == stack.peek().right
                        || (h == stack.peek().left && stack.peek().right == null))) {
                    h = stack.poll();
                }
                if (!stack.isEmpty() && h == stack.peek().left && stack.peek().right != null) {
                    stack.push(stack.peek().right);
                }
            }
        }
        return res;
    }
    //改进: 递归远快于自己维护栈, 而且说了是个bst, 条件没用上
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        while (root != null && root.val <= p.val)
            root = root.right;
        if (root == null)
            return null;
        TreeNode left = inorderSuccessor(root.left, p);
        return (left != null && left.val > p.val) ? left : root;
    }
}
