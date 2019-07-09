package gelato.leet0;

import gelato.model.ListNode;

//24
public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head.next == null) return head;
        ListNode res = head.next;

        ListNode prev = null;
        ListNode cur1 = head;
        ListNode cur2 = head.next;
        while (cur1 != null && cur2 != null) {
            cur1.next = cur2.next;
            cur2.next = cur1;
            if (prev != null) {
                prev.next = cur2;
            }
            prev = cur1;
            cur1 = cur1.next;
            cur2 = cur1 != null ? cur1.next : null;
        }
        return res;
    }
}
