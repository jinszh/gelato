package gelato.leet9;

import gelato.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//971
public class flipMatchVoyage {
    List<Integer> res = new ArrayList<>();
    int i = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] v) {
        return dfs(root, v) ? res : Arrays.asList(-1);
    }

    public Boolean dfs(TreeNode node, int[] v) {
        if (node == null) return true;
        if (node.val != v[i++]) return false;
        if (node.left != null && node.left.val != v[i]) {
            res.add(node.val);
            return dfs(node.right, v) && dfs(node.left, v);
        }
        return dfs(node.left, v) && dfs(node.right, v);
    }
}
