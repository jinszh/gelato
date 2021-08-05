package gelato.leet1;

import gelato.model.ListNode;

//148
public class sortList {
    public ListNode sortList_my(ListNode head) {
        if (head == null || head.next == null) return head;
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        ListNode[] h = sort(head, len);
        p = h[0];
        int l = 0;
        while (++l < len) p = p.next;
        p.next = null;
        return h[0];
    }

    private ListNode[] sort(ListNode head, int len) {
        ListNode[] res;
        if (len == 1) {
            res = new ListNode[]{head, head.next};
        } else {
            ListNode[] res1 = sort(head, (len + 1) / 2);
            ListNode[] res2 = sort(res1[1], len / 2);
            ListNode h = merge(res1[0], res2[0], (len + 1) / 2, len / 2);
            res = new ListNode[]{h, res2[1]};
        }
        return res;
    }

    private ListNode merge(ListNode h1, ListNode h2, int l1, int l2) {
        int len1 = 0, len2 = 0;
        ListNode prev = null, nxt, head = null, tail = null;
        while (len1 < l1 && len2 < l2) {
            if (h1.val < h2.val) {
                nxt = h1;
                len1++;
                h1 = h1.next;
            } else {
                nxt = h2;
                len2++;
                h2 = h2.next;
            }
            if (head == null) {
                head = nxt;
            }
            if (prev != null) {
                prev.next = nxt;
            }
            prev = nxt;
        }
        prev.next = len1 < l1 ? h1 : h2;
        return head;
    }

    //相同得merge sort, 用的是fast slow pointers
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; //把前后两个链断掉 再分开sort和merge

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }
}
