package gelato.leet7;

import gelato.basic.SegmentTree;

import java.util.TreeMap;

//732
public class MyCalendarThree {
    public int book(int start, int end) {
        int left = map.floorKey(start) != null && map.get(map.floorKey(start))[0] > start ? map.floorKey(start) : start;
        int right = map.floorKey(end) == null || map.floorKey(end).equals(end) ? end : Math.max(map.get(map.floorKey(end))[0], end);

        while (left < right) {
            Integer key = map.ceilingKey(left);
            if (key == null || key.intValue() >= right) { // no intersect
                map.put(left, new int[]{right, 1});
                break;
            }
            if (key > left) { //key lies in the right and there's intersect
                map.put(left, new int[]{key, 1});
                left = key;
            }else {//when key <= left and there is intersection
                int keyr = map.get(key)[0];
                int keyn = map.get(key)[1];
                max = Math.max(max, keyn + 1);
                int l = key;
                if (key < start) { // For the first left floor key - key < start想的时候周全点 否则很难debug
                    map.put(key, new int[]{start, keyn});
                    l = start;
                }
                //process the right part of the key interval (>= left part, this interval can also be the leftmost one)
                if (end > keyr) {
                    map.put(l, new int[]{keyr, keyn + 1});
                    left = keyr;
                } else {
                    map.put(l, new int[]{end, keyn + 1});
                    if (end < keyr) {
                        map.put(end, new int[]{keyr, keyn});
                    }
                    break;
                }
            }
        }
        return max;
    }

    TreeMap<Integer, int[]> map = new TreeMap<>();
    int max = 1;

    /// Another version - Use segment tree
    //用segmenttree就是根结点按给的最大的值的范围给区间
    SegmentTree segmentTree;
    public MyCalendarThree() {
        segmentTree = new SegmentTree(0, 1000000000);
    }
    public int book_seg(int start, int end) {
        segmentTree.add(start, end, 1);
        return segmentTree.getMax();
    }
}
