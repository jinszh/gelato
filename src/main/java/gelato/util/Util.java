package gelato.util;

import gelato.model.ListNode;
import gelato.model.TreeNode;

import java.awt.*;
import java.util.ArrayList;

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

    public static Point[] toPointList(String vals){
        Point [] re = null;
        ArrayList<Point> pointList = new ArrayList<Point>();
        String [] ps = vals.split("],\\[");
        re = new Point[ps.length];
        for (String s: ps
             ) {
            String si = s.replace("[", "");
            si = si.replace("]", "");
            String [] vs = si.split(",");
            pointList.add(new Point(Integer.parseInt(vs[0]), Integer.parseInt(vs[1])));
        }
        return pointList.toArray(re);
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
