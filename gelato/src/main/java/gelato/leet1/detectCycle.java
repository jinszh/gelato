package gelato.leet1;

import gelato.model.ListNode;

//142 Detect the first node of a cycle
public class detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode l1 = head, l2 = head, cnode = null;
        int l = 0, lc = 1, nstep = 0;
        while (l2.next != null && l2.next.next != null){
            l1 = l1.next;
            l2 = l2.next.next;
            l++;
            if(l1 == l2){
                cnode = l1;
                break;
            }
        }
        if(cnode == null)return null;
        while (l1.next != cnode){
            lc++;
            l1 = l1.next;
        }
        l2 = head;
        while (nstep < l - lc){
            l2 = l2.next;
            nstep++;
        }
        l1 = cnode;
        while (l1 != l2){
            l1 = l1.next;
            l2 = l2.next;
        }
        return l2;
    }

    // 因为第一次相遇的时候假设慢的走了L, 则快的走了2L, 其中多出来的L是在cycle里面转了n圈,
    // 所以可以知道L是cycle len的整数倍, 所以第二次并不需要算长度, 直接从头部开始走就行了, 第一次相遇的点一定是起始点
    public ListNode detectCycle_simpler(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head, start = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != start) {
                    slow = slow.next;
                    start = start.next;
                }
                return start;
            }
        }
        return null;
    }
}
