package gelato.leet1;

import gelato.model.TreeNode;

//114
public class flatten {
    //注意题目传进来的参数是root, 所以把root new成其他对象对返回对象没影响, 只能操作原对象
    //wrong versoin
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null)return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
