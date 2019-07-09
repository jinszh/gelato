package gelato.leet7;

import gelato.model.ListNode;

//725
public class splitListToParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int len = 0;
        ListNode p = root;
        while (p != null) {
            p = p.next;
            len++;
        }
        p = root;
        if (len < k) {
            for (int i = 0; i < len; i++) {
                res[i] = p;
                p = p.next;
                res[i].next = null;
            }
        } else {
            int sz = len / k;
            int rem = len - sz * k;
            for (int i = 0; i < k; i++, rem--) {
                res[i] = p;
                int j = 0;
                ListNode end = p;
                while (j++ < sz) end = end.next;
                if (rem > 0) end = end.next;
                p = end.next;
                end.next = null;
            }
        }
        return res;
    }
}
