package gelato.leet7;



//708
public class InsertCyclicList {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node res = new Node(insertVal, null);
            res.next = res;
            return res;
        }
        if (head.next == head) {
            Node toInsert = new Node(insertVal, head);
            head.next = toInsert;
        } else {
            Node prev = head;
            Node cur = head.next;
            while (cur != head) {
                if ((cur.val >= insertVal && (prev.val > cur.val || prev.val <= insertVal))
                        || (prev.val > cur.val && insertVal >= prev.val)) {
                    prev.next = new Node(insertVal, cur);
                    break;
                } else if (cur.next == head) {
                    cur.next = new Node(insertVal, head);
                    break;
                }
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    };
}
