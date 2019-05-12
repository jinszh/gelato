package gelato.leet6;

import gelato.model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return con(nums, 0, nums.length - 1);
    }

    private TreeNode con(int [] nums, int b, int e){
        if(b == e) {
            return new TreeNode(nums[b]);
        }
        int max = Integer.MIN_VALUE, maxId = -1;
        for(int i = b; i <= e; i++){
            if(nums[i] > max){
                maxId = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        if(b <= maxId - 1) {
            root.left = con(nums, b, maxId - 1);
        }
        if(maxId + 1 <= e) {
            root.right = con(nums, maxId + 1, e);
        }
        return root;
    }

    //使用栈的O(N)版本 - 用一个栈维持一个递减序列
    public TreeNode constructMaximumBinaryTree_ON(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if(!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }

        return stack.isEmpty() ? null : stack.removeLast();
    }
}
