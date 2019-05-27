package gelato.leet4;

import java.util.LinkedList;

//430
public class flatten {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };

    public Node flatten(Node head) {
        Node now = head;
        LinkedList<Node> prevStack = new LinkedList<>();
        while (now != null) {
            if (now.child != null) {
                if (now.next != null) {//next为空下面就不能设next.prev
                    prevStack.addFirst(now.next);
                }
                now.next = now.child;
                now.child = null;
                now = now.next;
            } else {//child 可能直接有child所以需要else
                if (now.next == null && !prevStack.isEmpty()) {
                    now.next = prevStack.pollFirst();
                    now.next.prev = now;
                }
                now = now.next;
            }
        }
        return head;
    }
}
