package gelato.leet0;

import gelato.model.ListNode;

//19
public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode n1 = head;
        ListNode n2 = head;
        for (int i = 0; i < n; i++) {
            n1 = n1.next;
        }
        ListNode prev = n2;
        while (n1 != null) {
            n1 = n1.next;
            prev = n2;
            n2 = n2.next;
        }
        prev.next = n2.next;
        return n2 == head ? n2.next : head;
    }
}
