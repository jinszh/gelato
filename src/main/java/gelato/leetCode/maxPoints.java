package gelato.leetCode;

import java.awt.*;
import java.math.BigDecimal;

public class maxPoints {
    public int maxPoints(Point[] points) {
        BigDecimal[][] slope;
        int n = 0;
        if(points != null && points.length > 0) {
            n = points.length > 1 ? 2 : 1;
            slope = new BigDecimal[points.length][points.length];
            boolean [][] contained = new boolean[points.length][points.length];
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    if ((points[i].y - points[j].y) == 0) {
                        if(points[i].x == points[j].x){
                            slope[i][j] = null;
                        }else {
                            slope[i][j] = BigDecimal.;
                        }
                    } else {
                        slope[i][j] = BigDecimal.valueOf ((points[i].x - points[j].x) / (points[i].y - points[j].y));
                    }
                    contained[i][j] = false;
                }
            }
            for(int i = 0; i < points.length - 1; i++){
                int base = 1;
                for(int j = i + 1; j < points.length; j++){
                    if(contained[i][j]){continue;}
                    if(slope[i][j] == null){
                        base++;
                        if(base > n){
                            n = base;
                        }
                       // contained[i][j] = true;
                    }else {
                        int cur = base + 1;
                        for (int k = j + 1; k < points.length; k++) {
                            if (slope[i][k] == null || slope[i][j].compareTo(slope[i][k]) == 0) {
                                cur++;
                       //         contained[j][k] = true;
                            }
                        }
                        if(cur > n){
                            n = cur;
                        }
                    }
                }

            }
        }
        return n;
    }
}
