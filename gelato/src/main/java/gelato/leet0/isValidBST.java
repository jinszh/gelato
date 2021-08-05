package gelato.leet0;

import gelato.model.TreeNode;

//98
public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    private boolean valid(TreeNode p, Integer high, Integer low){
        if(p != null ){
            return (high != null ? p.val < high : true) && (low != null ? low < p.val : true)
                    && valid(p.left, p.val, low) && valid(p.right, high, p.val);
        }else {
            return true;
        }
    }
}
