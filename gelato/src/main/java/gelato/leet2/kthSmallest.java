package gelato.leet2;

import gelato.model.TreeNode;

//230
public class kthSmallest {
    int n = 0, k, res;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        help(root);
        return res;
    }

    private void help(TreeNode p) {
        if (p.left != null) {
            help(p.left);
        }
        n++;
        if (n == k){
            res = p.val;
            return;
        }
        if(p.right != null) {
            help(p.right);
        }
    }
}
