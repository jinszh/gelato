package gelato.leet7;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//715
public class RangeModule {//half open [left, right)
    //优化: 一个map就够了, 并且可以用subMap来得到数据段, 不用循环
//    public RangeModule() {
//
//    }
//
//    public void addRange(int left, int right) {
//        boolean mergel = false;
//        boolean merger = false;
//        Integer floorl = lrmap.floorKey(left);
//        Integer ceill = lrmap.ceilingKey(left);
//        if (floorl != null && lrmap.get(floorl) >= right) {
//            return;
//        }
//        if (floorl != null && floorl < left && lrmap.get(floorl) >= left) {
//            mergel = true;
//        }
//        if (ceill != null && ceill <= right) {
//            merger = true;
//        }
//
//        if (mergel && merger) {
//            int l = floorl;
//            int r = Math.max(right, lrmap.get(ceill));
//            removeKey(floorl);
//            removeKey(ceill);
//            addRange(l, r);
//        } else if (mergel) {
//            removeKey(floorl);
//            addRange(floorl, right);
//        } else if (merger) {
//            int r = Math.max(right, lrmap.get(ceill));
//            removeKey(ceill);
//            addRange(left, r);
//        } else {
//            lrmap.put(left, right);
//            rlmap.put(right, left);
//        }
//    }
//
//    public boolean queryRange(int left, int right) {
//        boolean res = false;
//        Integer floorl = lrmap.floorKey(left);
//        if(floorl != null && lrmap.get(floorl) >= right){
//            res = true;
//        }
//        return res;
//    }
//
//    public void removeRange(int left, int right) {
//        Integer ceilr = rlmap.ceilingKey(left);
//        if(ceilr != null && rlmap.get(ceilr) >= right)return;
//        if (ceilr != null && ceilr > left) {
//            int l = rlmap.get(ceilr);
//            rlmap.remove(ceilr);
//            if (l >= left) {
//                lrmap.remove(l);
//            } else {
//                lrmap.put(l, left);
//                rlmap.put(left, l);
//            }
//            if(right < ceilr){
//                addRange(right, ceilr);
//            }
//        }
//        Integer ceill = lrmap.ceilingKey(left);
//        while (ceill != null) {
//            int r = lrmap.get(ceill);
//            if (r <= right) {
//                lrmap.remove(ceill);
//                rlmap.remove(r);
//                ceill = lrmap.ceilingKey(left);
//            } else if (ceill < right) {
//                lrmap.remove(ceill);
//                lrmap.put(right, r);
//                rlmap.put(r, right);
//                break;
//            } else {
//                break;
//            }
//        }
//    }
//
//    private void removeKey(int left){
//        rlmap.remove(lrmap.get(left));
//        lrmap.remove(left);
//    }
//    TreeMap<Integer, Integer> lrmap = new TreeMap<>();
//    TreeMap<Integer, Integer> rlmap = new TreeMap<>();

    //优化的版本
    TreeMap<Integer, Integer> map;
    public RangeModule() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if (right <= left) return;
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if (start == null && end == null) {
            map.put(left, right);
        } else if (start != null && map.get(start) >= left) {
            map.put(start, Math.max(map.get(end), Math.max(map.get(start), right)));
        } else {
            map.put(left, Math.max(map.get(end), right));
        }
        // clean up intermediate intervals
        Map<Integer, Integer> subMap = map.subMap(left, false, right, true);
        Set<Integer> set = new HashSet(subMap.keySet());
        map.keySet().removeAll(set);
    }

    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);
        if (start == null) return false;
        return map.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        if (right <= left) return;
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if (end != null && map.get(end) > right) {
            map.put(right, map.get(end));
        }
        if (start != null && map.get(start) > left) {
            map.put(start, left);
        }
        // clean up intermediate intervals
        Map<Integer, Integer> subMap = map.subMap(left, true, right, false);
        Set<Integer> set = new HashSet(subMap.keySet());
        map.keySet().removeAll(set);

    }
}
