package gelato.leet2;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class AllOne {
    HashMap<String, Integer> map;
    HashMap<Integer, Integer> link;
    HashMap<Integer, Integer> revLink;
    HashMap<Integer, LinkedHashSet<String>> vmap;
    int maxCnt;
    int minCnt;

    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<>();
        vmap = new HashMap<>();
        link = new HashMap<>();
        revLink = new HashMap<>();
    }

    private void moveDown(int curCnt, boolean curRemove){
        Integer pre =  revLink.containsKey(curCnt) ? revLink.get(curCnt) : null;
        Integer post = !curRemove ? curCnt : link.containsKey(curCnt) ? link.get(curCnt) : null;
        if(curCnt ==  minCnt && curRemove){
            if(curCnt == 1) {
                minCnt = link.containsKey(curCnt) ? link.get(curCnt) : 0;
            }else {
                minCnt = curCnt - 1;
            }
        }
        if (pre != null && curRemove) {
            link.remove(pre, curCnt);
            revLink.remove(curCnt, pre);
        }
        if (post != null && curRemove) {
            revLink.remove(post, curCnt);
            link.remove(curCnt, post);
        }
        if (post != null && curCnt > 1) {
            link.put(curCnt - 1, post);
            revLink.put(post, curCnt - 1);
        }
        if (pre != null && pre < curCnt - 1) {
            link.put(pre, curCnt - 1);
            revLink.put(curCnt - 1, pre);
        }
        if(curCnt == maxCnt && curRemove){
            maxCnt = curCnt - 1;
        }
    }

    private void moveUp(int curCnt, boolean curRemove) {
        Integer pre = !curRemove ? curCnt : (revLink.containsKey(curCnt) ? revLink.get(curCnt) : null);
        Integer post = link.containsKey(curCnt) ? link.get(curCnt) : null;
        if (pre != null && curRemove) {
            link.remove(pre, curCnt);
            revLink.remove(curCnt, pre);
        }
        if (post != null && curRemove) {
            revLink.remove(post, curCnt);
            link.remove(curCnt, post);
        }
        if (pre != null) {
            revLink.put(curCnt + 1, pre);
            link.put(pre, curCnt + 1);
        }
        if (post != null && post > curCnt + 1) {
            revLink.put(post, curCnt + 1);
            link.put(curCnt + 1, post);
        }

        if (maxCnt == curCnt) {
            maxCnt++;
        }
        if (minCnt == curCnt && curRemove) {
            minCnt = minCnt + 1;
        }
    }
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int curCnt = map.containsKey(key) ? map.get(key) : 0;
        map.put(key, curCnt + 1);

        if (minCnt == 0) {
            minCnt = curCnt + 1;
        }
        if (maxCnt == 0) {
            maxCnt = curCnt + 1;
        }

        if (vmap.containsKey(curCnt)) {
            vmap.get(curCnt).remove(key);
            if (vmap.get(curCnt).isEmpty()) {//removed current node
                vmap.remove(curCnt);
                moveUp(curCnt, true);
            } else if (!vmap.containsKey(curCnt + 1) || vmap.get(curCnt + 1).isEmpty()) {//created new next
                moveUp(curCnt, false);
            }
        } else if (minCnt > curCnt + 1) {//a new coming
            link.put(curCnt + 1, minCnt);
            revLink.put(minCnt, curCnt + 1);
            minCnt = curCnt + 1;
        }
        if (!vmap.containsKey(curCnt + 1)) {
            vmap.put(curCnt + 1, new LinkedHashSet<>());
        }
        vmap.get(curCnt + 1).add(key);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (map.containsKey(key)) {
            int curCnt = map.get(key);
            if (curCnt == 1) {
                map.remove(key);
            } else {
                map.put(key, curCnt - 1);
            }
            vmap.get(curCnt).remove(key);
            if (vmap.get(curCnt).isEmpty()) {
                moveDown(curCnt, true);
                vmap.remove(curCnt);
            } else {
                moveDown(curCnt, false);
            }
            if (curCnt > 1) {
                if (!vmap.containsKey(curCnt - 1)) {
                    vmap.put(curCnt - 1, new LinkedHashSet<>());
                }
                vmap.get(curCnt - 1).add(key);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return maxCnt == 0 ? "" : vmap.get(maxCnt).iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return minCnt == 0 ? "" : vmap.get(minCnt).iterator().next();
    }
}
