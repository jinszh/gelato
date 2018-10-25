package gelato.leetCode;

import gelato.model.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {//O(nlogn)
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> (Integer.compare(a.val, b.val)));
        for(int i = 0; i< lists.length; i++){
            if(lists[i] != null) queue.add(lists[i]);
        }
        ListNode newHead = queue.isEmpty() ? null : queue.poll();
        ListNode h = newHead;
        while (!queue.isEmpty()){
            if(h.next!= null){
                queue.add(h.next);
            }
            h.next = queue.poll();
            h = h.next;
        }
        return newHead;
    }

    public ListNode mergeKLists2(ListNode[] lists) {//O(nlogn)
        List<ListNode> l = new ArrayList<>(Arrays.asList(lists));
        while (l != null && l.size() > 1){
            ListNode n = merge(l.get(0), l.get(1));
            l.remove(0); l.remove(0);
            l.add(n);
        }
        return l.get(0);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode h;
        if(l1.val > l2.val ){
            h = l2; l2 = l2.next;
        }else {
            h = l1; l1 = l1.next;
        }
        ListNode nh = h;
        while (l1 != null && l2 != null )
        {
            if(l1.val > l2.val){
                h.next = l2;
                l2 = l2.next;
            }else {
                h.next = l1;
                l1 = l1.next;
            }
            h = h.next;
        }
        if(l1!= null){
            h.next = l1;
        }else if(l2 != null){
            h.next = l2;
        }
        return nh;
    }
}
