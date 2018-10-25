package gelato.leetCode;

import gelato.model.ListNode;

public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode prev = null;
        ListNode h = null;
        while (true) {
            if (l1 == null && l2 == null && carry == 0) {
                break;
            }
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            if (prev == null) {
                prev = new ListNode(sum % 10);
                h = prev;
            } else {
                prev.next = new ListNode(sum);
                prev = prev.next;
            }
        }
        return h;
    }
}