package gelato.leetCode;

import sun.awt.image.ImageWatched;

import java.util.HashMap;

public class LRUCache {
    LinkNode head = null;
    LinkNode tail = null;
    HashMap<Integer, HashNode> cache = new HashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            LinkNode linkNode = cache.get(key).qItem;
            moveToTail(linkNode);
            return cache.get(key).value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.get(key).value = value;
            moveToTail(cache.get(key).qItem);
        }else {
            if(cache.size() == capacity) {
                cache.remove(head.value);
                head = head.next;
                if (head != null) head.prev = null;
            }
            if(head == null){
                head = new LinkNode(key, null, null);
                tail = head;
                cache.put(key, new HashNode(value, head));
            }else{
                LinkNode newNode = new LinkNode(key, tail, null);
                tail.next = newNode;
                tail = newNode;
                cache.put(key, new HashNode(value, tail));
            }
        }
    }
    private void moveToTail(LinkNode linkNode){
        if (linkNode.prev != null && linkNode != tail) {
            linkNode.prev.next = linkNode.next;
        }
        if (linkNode.next != null) {
            linkNode.next.prev = linkNode.prev;
        }
        if(linkNode == head && head.next != null){
            head = head.next;
            head.prev = null;
        }
        if(tail != linkNode) {
            tail.next = linkNode;
            linkNode.prev = tail;
            linkNode.next = null;
            tail = linkNode;
        }
    }

    class LinkNode{
        Integer value;
        LinkNode next = null;
        LinkNode prev = null;
        LinkNode(int v, LinkNode prev, LinkNode next){
            value = v;
            this.prev = prev;
            this.next = next;
        }
    }

    class HashNode{
        Integer value;
        LinkNode qItem;
        HashNode(int v, LinkNode l){
            this.value = v;
            this.qItem = l;
        }
    }
}
