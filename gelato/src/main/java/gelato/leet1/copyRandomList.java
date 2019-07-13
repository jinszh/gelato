package gelato.leet1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//138
public class copyRandomList {
    //My
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, List<Integer>> ranmap = new HashMap<>();
        List<Node> res = new ArrayList<>();
        Node p = head;
        Node prev = null;
        for (int i = 0; p != null; i++){
            Node cur = new Node(p.val, null, null);
            if (prev != null) {
                prev.next = cur;
            }
            if (!ranmap.containsKey(p.random)) {
                ranmap.put(p.random, new ArrayList<>());
            }
            ranmap.get(p.random).add(i);
            res.add(cur);
            p = p.next;
            prev = cur;
        }
        p = head;
        for (int i = 0; i < res.size(); i++){
            if (ranmap.containsKey(p)) {
                for (Integer id : ranmap.get(p)) {
                    res.get(id).random = res.get(i);
                }
            }
            p = p.next;
        }
        //System.out.println(res.get(0).next.next.val);
        return res.get(0);
    }

    //不通过HashMap, 直接修改原链表也可以, 拷贝时候把clone的链表random指向原链表,
    // 拷贝完之后把原链表的next指向拷贝的链表, 然后拷贝的链表通过一个random加一个next操作即可
    //题目不让修改原链表, 所以得想办法restore回去 -- 下面这个方案不行
    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        Node h = head;
        Node prev = new Node(head.val, null, h);
        Node res = prev;
        h = h.next;
        head.next = res;
        while (h != null){
            Node cur = new Node(h.val, null, h);
            prev.next = cur;
            Node preh = h;
            h = h.next;
            preh.next = cur;
            prev = cur;
        }
        Node p = res;
        while (p != null){
            p.random = p.random.next;
        }
        return res;
    }

    //把copy得链表插进去.... 这样就可以restore了
    public Node copyRandomList3(Node head) {
        if (head == null) return null;
        //第一轮 把拷贝链表插入原链表
        Node h = head;
        while (h != null){
            Node cur = new Node(h.val, h.next, h.random);
            h.next = cur;
            h = h.next.next;
        }
        //第二轮 调整拷贝链表的random和next;
        Node res = h = head.next;
        while (h != null){
            h.random = h.random != null ? h.random.next : null;
            h = h.next != null ? h.next.next : null;
        }
        //第三轮restore, 因为random可能指向前面的节点, 所以不能再第二轮restore next
        h = head;
        while (h != null){
            Node h1 = h.next.next;
            h.next.next = h1 != null ? h1.next : null;
            h.next = h1;
            h = h.next;
        }
        return res;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
