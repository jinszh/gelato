package gelato.leetCode;

import java.awt.*;

public class maxPoints {
    public int maxPoints(Point[] points) {
        Double [][] slope;
        int n = 0;
        if(points != null && points.length > 0) {
            n = points.length > 1 ? 2 : 1;
            slope = new Double[points.length][points.length];
            boolean [][] contained = new boolean[points.length][points.length];
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    if ((points[i].y - points[j].y) == 0) {
                        if(points[i].x == points[j].x){
                            slope[i][j] = null;
                        }else {
                            slope[i][j] = Double.MAX_VALUE;
                        }
                    } else {
                        slope[i][j] = (double) (points[i].x - points[j].x) / (points[i].y - points[j].y);
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
                            if (slope[i][k] == null || Math.abs(slope[i][j] - slope[i][k]) < 10E-20) {
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
