package gelato.leet9;

import gelato.model.TreeNode;

//951
public class flipEquiv {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null || root1.val != root2.val) return false;
        if(root1.left == null && root1.right == null && root2.left == null || root2.right == null) return true;

        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
                || flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right);
    }
}
