package gelato.leetCode;

import gelato.model.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class maxPathSum {
    HashMap<TreeNode, Integer> cacheWithRoot = new HashMap<>(); // No need to store the cache
    HashMap<TreeNode, Integer> cacheWoRoot = new HashMap<>();

    public int maxPathSum(TreeNode root) {
        return getMax(root);
    }

    private int getMax(TreeNode n) {
        Integer l = null, lo = null, r = null, ro = null;
        if (n.left != null) {
            if (!cacheWithRoot.containsKey(n.left)) {
                getMax(n.left);
            }
            l = cacheWithRoot.get(n.left);
            lo = cacheWoRoot.get(n.left);
        }
        if (n.right != null) {
            if (!cacheWoRoot.containsKey(n.right)) {
                getMax(n.right);
            }
            r = cacheWithRoot.get(n.right);
            ro = cacheWoRoot.get(n.right);
        }
        int maxWithRoot = Collections.max(Arrays.asList(n.val + (l != null ? l : 0)
                , n.val + (r != null ? r : 0)
                , n.val));
        int maxWoRoot = Collections.max(Arrays.asList(l != null ? l : Integer.MIN_VALUE
                , r != null ? r : Integer.MIN_VALUE
                , lo != null ? lo : Integer.MIN_VALUE
                , ro != null ? ro : Integer.MIN_VALUE
                ,  (l != null ? l : 0) + n.val + (r != null ? r : 0)));
        cacheWithRoot.put(n, maxWithRoot);
        cacheWoRoot.put(n, maxWoRoot);
        return Math.max(maxWithRoot, maxWoRoot);
    }
}
