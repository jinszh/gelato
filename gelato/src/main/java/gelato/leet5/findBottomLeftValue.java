package gelato.leet5;

import gelato.model.TreeNode;

//513
public class findBottomLeftValue {
    int maxLevel = -1;
    int maxValue = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(0, root);
        return maxValue;
    }
    private void dfs(int level, TreeNode root){
        if(root == null) return;
        if(level > maxLevel ){
            maxLevel = level;
            maxValue = root.val;
        }
        dfs(level + 1, root.left);
        dfs(level + 1, root.right);
    }

}
