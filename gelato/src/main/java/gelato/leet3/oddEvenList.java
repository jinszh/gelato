package gelato.leet3;

import gelato.model.ListNode;

//328
public class oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode podd = head;
        ListNode peven = head.next;
        ListNode pes = peven;
        while (peven.next != null && podd.next != null) {
            if (peven.next != null) {
                podd.next = peven.next;
                podd = podd.next;
            }
            if (podd.next != null) {
                peven.next = podd.next;
                peven = peven.next;
            }
        }
        podd.next = pes;
        return head;
    }
}
