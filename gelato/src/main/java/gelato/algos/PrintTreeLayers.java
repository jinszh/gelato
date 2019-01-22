package gelato.algos;

import gelato.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class PrintTreeLayers {
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> line = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(pRoot!=null){
            q.add(pRoot);
            line.add(pRoot.val);
            result.add(line);
            line = new ArrayList<>();
            int l = 0, h = 1;
            while(!q.isEmpty()) {
                TreeNode head = q.poll();
                l++;
                if(head.left != null){
                    q.add(head.left);
                    line.add(head.left.val);
                }
                if(head.right != null){
                    q.add(head.right);
                    line.add(head.right.val);
                }
                if(l == h){
                    result.add(line);
                    line = new ArrayList<>();
                    h = q.size();
                    l= 0;
                }
            }
        }
        return result;
    }
}
