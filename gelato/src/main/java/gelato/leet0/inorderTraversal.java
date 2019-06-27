package gelato.leet0;

import gelato.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//94
public class inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode h = stack.peek();
            if (h.left != null) {
                stack.push(h.left);
            } else if (h.right != null) {
                res.add(h.val);
                stack.push(h.right);
            } else {
                res.add(stack.poll().val);
                while (!stack.isEmpty()
                        && (h == stack.peek().right
                        || (h == stack.peek().left && stack.peek().right == null))) {
                    if(h == stack.peek().left){
                        res.add(stack.peek().val);
                    }
                    h = stack.poll();
                }
                if (!stack.isEmpty() && h == stack.peek().left && stack.peek().right != null) {
                    res.add(stack.peek().val);
                    stack.push(stack.peek().right);
                }
            }
        }
        return res;
    }

    //下面这个while写得更简单 - 也不需要判断是否parent的left或者right
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }
}
