package gelato.leet9;

import gelato.model.TreeNode;

public class distributeCoins {
    int nmove = 0;
    public int distributeCoins(TreeNode root) {
        move(root);
        return nmove;
    }

    private int move(TreeNode node){
        int delta = node.val - 1;
        if(node.left != null) {
            delta += move(node.left);
        }
        if(node.right != null) {
            delta += move(node.right);
        }
        nmove += Math.abs(delta);
        return delta;
    }
}
