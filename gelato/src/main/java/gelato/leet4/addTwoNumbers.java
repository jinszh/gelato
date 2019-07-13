package gelato.leet4;

import gelato.model.ListNode;

import java.util.LinkedList;

//445
public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1, h2 = l2;
        int len1= 0, len2 = 0;
        while (h1 != null){
            len1++; h1 = h1.next;
        }
        while (h2 != null){
            len2++; h2 = h2.next;
        }
        int [] res = new int[Math.max(len1, len2) + 1];
        while (l1 != null){
            res[--len1] += l1.val;
            l1 = l1.next;
        }
        while (l2 != null){
            res[--len2] += l2.val;
            l2 = l2.next;
        }
        for(int i = 0; i < res.length; i++) {
            if (res[i] > 10) {
                res[i + 1] += res[i] / 10;
                res[i] = res[i] % 10;
            }
        }
        int i = res.length - 1;
        while (i >= 0 && res[i] == 0) i--;
        ListNode h = new ListNode(i < 0 ? 0 : res[i]);
        ListNode p = h;
        for(i--;i >= 0; i--){
            p.next = new ListNode(res[i]);
            p = p.next;
        }
        return h;
    }
}
