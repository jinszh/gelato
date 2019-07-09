package gelato.leet3;

import java.util.HashMap;
import java.util.HashSet;

//356
public class isReflected {
    //结构越简单越快 - HashMap套Hashset肯定慢
    public boolean isReflected(int[][] points) {
        int minx = Integer.MAX_VALUE, maxx = Integer.MIN_VALUE;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int [] p : points){
            minx = Math.min(minx, p[0]);
            maxx = Math.max(maxx, p[0]);
            map.computeIfAbsent(p[0], v -> new HashSet<>()).add(p[1]);
        }
        int mid = 2 * minx + (maxx - minx);
        for(int [] p : points){
            if(!(map.containsKey(mid - p[0]) && map.get(mid - p[0]).contains(p[1]))){
                return false;
            }
        }
        return true;
    }
}
