package gelato.leet6;

import gelato.model.TreeNode;

//623
public class addOneRow {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return null;
        TreeNode res;
        if (d == 1) {
            res = new TreeNode(v);
            res.left = root;
        } else if (d == 2) {
            res = root;
            TreeNode nl = new TreeNode(v);
            nl.left = root.left;
            res.left = nl;
            TreeNode nr = new TreeNode(v);
            nr.right = root.right;
            res.right = nr;
        } else {
            res = root;
            res.left = addOneRow(root.left, v, d - 1);
            res.right = addOneRow(root.right, v, d - 1);
        }
        return res;
    }
}
