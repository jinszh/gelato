package gelato.leet1;

import gelato.model.ListNode;

public class insertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        ListNode n = p.next;
        p.next = null;
        while (n != null) {
            ListNode m = n != null ? n.next : null;
            ListNode h = p;
            ListNode prev = null;
            while (h != null && n.val > h.val) {
                prev = h;
                h = h.next;
            }
            n.next = h;
            if (prev == null) {
                p = n;
            }else {
                prev.next = n;
            }
            n = m;
        }
        return p;
    }
}
