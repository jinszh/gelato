package gelato.leet10;

import gelato.model.TreeNode;

import java.util.LinkedList;

public class bstFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (stack.peekLast() != null) {
                TreeNode prev = stack.peekLast();
                if (prev.val > node.val) {
                    prev.left = node;
                    stack.add(node);
                } else {
                    while (stack.peekLast() != null && stack.peekLast().val < node.val) {
                        prev = stack.pollLast();
                    }
                    prev.right = node;
                    stack.add(node);
                }
            }
        }
        return root;
    }
}
