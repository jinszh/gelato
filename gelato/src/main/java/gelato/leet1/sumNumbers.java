package gelato.leet1;

import gelato.model.TreeNode;

//129
public class sumNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int v){
        if(root == null) return;
        if(root.left == null && root.right == null){
            sum += v * 10 + root.val;
        }else {
            dfs(root.left, v * 10 + root.val);
            dfs(root.right, v * 10 + root.val);
        }
    }
}
