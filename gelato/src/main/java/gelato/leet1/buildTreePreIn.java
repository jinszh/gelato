package gelato.leet1;

import gelato.model.TreeNode;

public class buildTreePreIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        return process(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode process(int[] preorder, int[] inorder, int pl, int il, int ir){
        TreeNode root = new TreeNode(preorder[pl]);
        for(int i = il; i <= ir; i++){
            if(inorder[i] == preorder[pl]){
                if(i > il){
                    root.left = process(preorder, inorder, pl + 1, il, i - 1);
                }
                if(i < ir){
                    root.right = process(preorder, inorder, pl + (i - il) + 1, i + 1, ir);
                }
            }
        }
        return root;
    }
}
