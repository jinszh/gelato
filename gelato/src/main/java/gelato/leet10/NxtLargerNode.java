package gelato.leet10;

import gelato.model.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class NxtLargerNode {
    public int[] nextLargerNodes(ListNode head) {
        if(head == null) return null;
        ListNode h1 = head;
        LinkedList<Integer> stackv = new LinkedList<>();
        LinkedList<Integer> stacki = new LinkedList<>();
        ArrayList<Integer> out = new ArrayList<>();
        int i = 0;
        while (h1 != null) {
            while (!stackv.isEmpty() && h1.val > stackv.peekLast()){
                stackv.pollLast();
                int cur = stacki.pollLast();
                out.set(cur, h1.val);
            }
            stackv.add(h1.val);
            stacki.add(i);
            out.add(0);
            i++;
            h1 = h1.next;
        }
        return out.stream().mapToInt(Integer::intValue).toArray();
    }
}
