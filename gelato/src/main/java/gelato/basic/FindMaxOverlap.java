package gelato.basic;

import gelato.util.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMaxOverlap {
    public Integer find(int[][] segments){
        List<Integer[]> sorted = new ArrayList<>(segments.length);
        for(int [] seg : segments){
            sorted.add(new Integer[]{seg[0], 0});
            sorted.add(new Integer[]{seg[1], 1});
        }
        Collections.sort(sorted, (a,b) -> Integer.compare(a[0], b[0]));
        int maxOverLap = 0;
        int overLap = 0;
        int whereIsMax = -1;
        for(Integer [] point : sorted){
            if(point[1] == 0){
                overLap++;
                if(overLap > maxOverLap){
                    maxOverLap = overLap;
                    whereIsMax = point[0];
                }
            }else {
                overLap--;
            }
        }
        Util.print(whereIsMax);
        return maxOverLap;
    }
}
