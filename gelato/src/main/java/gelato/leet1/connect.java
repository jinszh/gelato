package gelato.leet1;
import java.util.LinkedList;

//116
public class connect {
    public Node connect(Node root) {
        if(root == null) return null;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        Node left = null;
        int l1 = 1, l2 = 0;
        while (!queue.isEmpty()) {
            Node h = queue.pollFirst();
            if(left != null){
                System.out.println(left.val + ": " + h.val);
                left.next = h;
            }
            l1--;
            if (h.left != null) {
                queue.add(h.left);
                l2++;
            }
            if (h.right != null) {
                queue.add(h.right);
                l2++;
            }
            if (l1 == 0) {
                left = null;
                l1 = l2;
                l2 = 0;
            }else {
                left = h;
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
