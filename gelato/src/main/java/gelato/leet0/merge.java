package gelato.leet0;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
}
