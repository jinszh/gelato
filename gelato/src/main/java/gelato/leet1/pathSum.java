package gelato.leet1;

import gelato.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//113
public class pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSum(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> res, ArrayList<Integer> par) {
        if (root == null) return;
        //System.out.println(root.val + "," + sum);
        par.add(root.val);
        if (root.right == null && root.left == null){
            if(root.val == sum) res.add(par);
        } else {
            dfs(root.right, sum - root.val, res, (ArrayList<Integer>) par.clone());
            dfs(root.left, sum - root.val, res, par);
        }
    }

    //只用一个list的做法, 每次回退的时候删掉最后一个元素
    public void pathSum(TreeNode root, int sum, List<Integer> currentResult,
                        List<List<Integer>> result) {

        if (root == null)
            return;
        currentResult.add(new Integer(root.val));
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList(currentResult));
            currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
            return;
        } else {
            pathSum(root.left, sum - root.val, currentResult, result);
            pathSum(root.right, sum - root.val, currentResult, result);
        }
        currentResult.remove(currentResult.size() - 1);//
    }
}
