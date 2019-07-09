package gelato.leet2;

import gelato.model.TreeNode;

public class countNodes {
    //用二分搜索法 找最下面一层
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode cur = root;
        int level = 0;
        while (cur != null) {
            cur = cur.left;
            level++;
        }
        if(level == 1) return 1;

        int nfull = (int) Math.pow(2, level - 1) - 1;
        int nlast = 0;
        int sl = level;
        while (sl > 0) {
            if (binary(root, sl)) {
                nlast += sl == 1 ? 1 : (int) Math.pow(2, sl - 2); // left and lefmost of the right
                root = root.right;
            } else {
                root = root.left;
            }
            sl--;
        }
        return nfull + nlast;
    }

    private boolean binary(TreeNode root, int level) {
        if (root == null) return level == 0;
        int l = 1;
        root = root.right;
        while (root != null) {
            l++;
            root = root.left;
        }
        return level == l;
    }
}
