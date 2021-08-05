package gelato.leet1;

import gelato.model.TreeNode;

//106
public class buildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) return null;
        return process(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode process(int[] inorder, int[] postorder, int ril, int rir, int rpl, int rpr) {
        TreeNode p = new TreeNode(postorder[rpr]);

        for (int j = rir; j >= ril; j--) {
            if (inorder[j] == postorder[rpr]) {
                if (j > ril) {
                    p.left = process(inorder, postorder, ril, j - 1, rpl, rpl + j - 1 - ril);
                }
                if (j < rir) {
                    p.right = process(inorder, postorder, j + 1, rir, rpr - 1 - (rir - j - 1), rpr - 1);
                }
                break;
            }
        }
        return p;
    }
}
