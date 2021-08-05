package gelato.leet0;

import gelato.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

//95
public class generateTrees {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        return generate(1, n);
    }

    private List<TreeNode> generate(int s, int e){
        List<TreeNode> res = new ArrayList<>();
        for(int i = s; i <= e; i++) {
            List<TreeNode> left = generate(s, i - 1);
            List<TreeNode> right = generate(i + 1, e);
            if(left.size() == 0)left.add(null);
            if(right.size() == 0) right.add(null);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
