package gelato.leet0;

import java.util.*;

//56
public class merge {
    //不是实时会增加的 其实不需要treeMap, Sort可能效率更高
    public int[][] merge(int[][] intervals) {
        for(int [] interval : intervals) {
            Integer floore = map.floorKey(interval[1]);
            if (floore != null && map.get(floore) > interval[0]) {
                interval[1] = Math.max(map.get(floore), interval[1]);
            }
            Integer floors = map.floorKey(interval[0]);
            if (floors != null && map.get(floors) >= interval[0]) {
                interval[0] = floors;
            }
            Map<Integer, Integer> internal = map.subMap(interval[0], true, interval[1], true);
            map.keySet().removeAll(new HashSet<>(internal.keySet()));
            map.put(interval[0], interval[1]);
        }

        int [][] res = new int [map.size()][2];
        int i = 0;
        while (!map.isEmpty()){
            res[i++] = new int[]{map.firstKey(),map.get(map.firstKey())};
            map.remove(map.firstKey());
        }
        return res;
    }

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public int[][] merge2(int[][] intervals) {
        if(intervals.length > 0) {
            Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
            List<int[]> res = new ArrayList<>();
            int start = intervals[0][0];
            int end = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] <= end) {
                    end = Math.max(end, intervals[i][1]);
                }else {
                    res.add(new int[]{start, end});
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }
            res.add(new int[]{start, end});
            return res.toArray(new int[res.size()][]);
        }
        return new int[][]{};
    }
}
