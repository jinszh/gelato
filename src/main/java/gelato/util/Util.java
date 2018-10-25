package gelato.util;

import gelato.model.ListNode;
import gelato.model.TreeNode;

public class Util {
    public static ListNode getTestListNode(int [] data){
        ListNode head = null;
        ListNode prev = null;
        for(int i = 0 ; i< data.length; i++) {
            if(prev == null) {
                prev = new ListNode(data[i]);
                head = prev;
            }else{
                prev.next = new ListNode(data[i]);
                prev = prev.next;
            }
        }
        return head;
    }

    public static TreeNode getTestTree(Integer [] data){
        TreeNode root = null;
        TreeNode [] nodes;
        if(data != null && data.length > 0 && data[0] != null) {
            root = new TreeNode(data[0]);
            nodes = new TreeNode[data.length];
            nodes[0] = root;
            for(int i = 0; i < data.length; i ++){
                TreeNode curNode = nodes[i];
                if(i * 2 + 1 < data.length && data[i * 2 + 1] != null){
                    curNode.left = new TreeNode(data[i * 2 + 1]);
                    nodes[i * 2 + 1] = curNode.left;
                }
                if(i * 2 + 2 < data.length && data[i * 2 + 2] != null){
                    curNode.right = new TreeNode(data[i * 2 + 2]);
                    nodes[i * 2 + 2] = curNode.right;
                }
            }
        }
        return root;
    }

    public static void printListNode( ListNode n){
        while (n != null) {
            System.out.print(n.val + ",");
            n = n.next;
        }
        System.out.println();
    }
}
