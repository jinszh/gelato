package gelato.leet9;

import gelato.model.TreeNode;

public class insertIntoMaxTree {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode resRoot = root;
        TreeNode oldRoot = null;
        TreeNode newNode = new TreeNode(val);
        while (val < root.val && root.right != null) {
            oldRoot = root;
            root = root.right;
        }
        if (val < root.val) {
            root.right = newNode;
        }
        if (val > root.val) {
            newNode.left = root;
            if (oldRoot != null) {
                oldRoot.right = newNode;
            } else {
                resRoot = newNode;
            }
        }
        return resRoot;
    }
}
