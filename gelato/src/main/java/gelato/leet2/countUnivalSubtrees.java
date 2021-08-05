package gelato.leet2;

import gelato.model.TreeNode;

//250
public class countUnivalSubtrees {
    int sum = 0;

    public int countUnivalSubtrees(TreeNode root) {
        isUni(root);
        return sum;
    }

    private boolean isUni(TreeNode root) {
        if (root == null) return false;
        boolean isUni = isUni(root.left);
        isUni &= isUni(root.right);
        if (isUni && ((root.left == null && root.right == null)
                || (root.left == null && root.right.val == root.val)
                || (root.right == null && root.left.val == root.val)
                || (root.right.val == root.val && root.left.val == root.val))) {
            sum++;
            return true;
        } else {
            return false;
        }
    }
}
