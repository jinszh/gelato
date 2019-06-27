package gelato.leet1;

import gelato.model.TreeNode;

//156
public class upsideDownBinaryTree {
    TreeNode res;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        help(root);
        return res;
    }

    private TreeNode help(TreeNode p){
        if(p.left != null){
            TreeNode par = help(p.left);
            par.left = p.right;
            par.right = p;
            return par.right;
        }else {
            res = p;
            return p;
        }
    }
}
