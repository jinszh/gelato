package gelato.leet0;

import gelato.model.ListNode;

//61
public class rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode s = head;
        ListNode p = head;
        int len = 1;
        while (s.next != null) {
            s = s.next;
            len++;
        }
        k = k % len;
        for (int i = 0; i < len - 1 - k; i++) p = p.next;
        s.next = head;
        ListNode res = p.next;
        p.next = null;
        return res;
    }
}
