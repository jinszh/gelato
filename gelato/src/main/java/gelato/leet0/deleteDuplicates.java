package gelato.leet0;

import gelato.model.ListNode;

//82
public class deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode h = null;
        ListNode p = head;
        ListNode nxt = head.next;
        ListNode prev = null;
        while (nxt != null){
            while (nxt.val == p.val && nxt.next != null) nxt = nxt.next;
            if(nxt != p.next){
                if(prev != null){
                    prev.next = nxt;
                }
            }else {
                if(h == null) h = p;
                prev = p;
            }
            p = nxt;
        }
        return h;
    }
}
