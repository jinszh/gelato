package gelato.leet8;

import gelato.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//863
public class distanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        LinkedList<TreeNode> path = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (find(root, path, target)) {
            for (int j = 0; j < path.size() - 1; j++) {
                if (path.size() - j < K) {
                    if (path.get(j + 1) == path.get(j).left) {
                        addKs(path.get(j).right, res, K - (path.size() - j + 1));
                    } else {
                        addKs(path.get(j).left, res, K - (path.size() - j + 1));
                    }
                } else if (path.size() - j == K) {
                    res.add(path.get(j).val);
                }
            }
            addKs(target, res, K);
        }
        return res;
    }

    private boolean find(TreeNode root, LinkedList<TreeNode> path, TreeNode target) {
        if (root == null) return false;
        if (root == target || (find(root.right, path, target) || find(root.left, path, target))) {
            path.addFirst(root);
            return true;
        } else {
            return false;
        }
    }

    private void addKs(TreeNode root, List<Integer> res, int k){
        if(root == null) return;
        if(k == 0) res.add(root.val);
        else {
            addKs(root.left, res, k - 1);
            addKs(root.right, res, k - 1);
        }
    }

    //Faster - 跟上面的思路差不多, 只是直接dfs没有记path, 快一些
    List<Integer> ans;
    TreeNode target;
    int K;
    public List<Integer> distanceK_F(TreeNode root, TreeNode target, int K) {
        ans = new LinkedList();
        this.target = target;
        this.K = K;
        dfs(root);
        return ans;
    }

    // Return vertex distance from node to target if exists, else -1
    // Vertex distance: the number of vertices on the path from node to target
    public int dfs(TreeNode node) {
        if (node == null)
            return -1;
        else if (node == target) {
            subtree_add(node, 0);
            return 1;
        } else {
            int L = dfs(node.left), R = dfs(node.right);
            if (L != -1) {
                if (L == K) ans.add(node.val);
                subtree_add(node.right, L + 1);
                return L + 1;
            } else if (R != -1) {
                if (R == K) ans.add(node.val);
                subtree_add(node.left, R + 1);
                return R + 1;
            } else {
                return -1;
            }
        }
    }

    // Add all nodes 'K - dist' from the node to answer.
    public void subtree_add(TreeNode node, int dist) {
        if (node == null) return;
        if (dist == K)
            ans.add(node.val);
        else {
            subtree_add(node.left, dist + 1);
            subtree_add(node.right, dist + 1);
        }
    }
}
