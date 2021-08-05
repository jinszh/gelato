package gelato.leet11;

import gelato.model.TreeNode;

import java.util.*;

//1110
public class delNodes {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        if(root == null) return res;

        HashSet<Integer> delset = new HashSet<>();
        for (int i : to_delete) delset.add(i);
        dfs(root, delset, res, null, true);
        return res;
    }

    private void dfs(TreeNode root, Set<Integer> todel, List<TreeNode> res, TreeNode par, boolean asroot) {
        if (root == null) return;
        boolean nxtasroot = false;

        if (todel.contains(root.val)) {
            nxtasroot = true;
            if(par != null) {
                if(par.left == root) par.left = null;
                else par.right = null;
            }
        }else if(asroot){
            res.add(root);
        }

        dfs(root.left, todel, res, root, nxtasroot);
        dfs(root.right, todel, res, root, nxtasroot);
    }
}
