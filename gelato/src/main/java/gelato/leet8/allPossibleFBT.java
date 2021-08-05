package gelato.leet8;

import gelato.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

//894
public class allPossibleFBT {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if(N == 1) {
            res.add(new TreeNode(0));
        }else {
            for (int i = 1; i < N - 1; i += 2) {
                List<TreeNode> l = allPossibleFBT(i);
                List<TreeNode> r = allPossibleFBT(N - 1 - i);
                for (TreeNode lt : l) {
                    for (TreeNode rt : r) {
                        TreeNode root = new TreeNode(0);
                        root.left = lt;
                        root.right = rt;
                        res.add(root);
                    }
                }
            }
        }
        return res;
    }
}
