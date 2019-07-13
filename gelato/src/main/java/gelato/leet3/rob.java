package gelato.leet3;

import gelato.model.TreeNode;

//337
public class rob {
    public int rob(TreeNode root) {
        int [] max = cnt(root);
        return Math.max(max[0], max[1]);
    }

    public int [] cnt(TreeNode root){
        if(root == null) return new int[]{0,0};
        int [] l = cnt(root.left);
        int [] r = cnt(root.right);
        return new int[]{root.val + l[1], r[1], Math.max(l[1],l[0]) + Math.max(r[1], r[0])};
    }
}
