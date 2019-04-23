package gelato.leet7;

import java.util.ArrayList;
import java.util.Arrays;

public class minmaxGasDist {
    public double minmaxGasDist(int[] stations, int K) {
        ArrayList<Integer> dists = new ArrayList<>(stations.length);
        double max = 0;
        for (int i = 1; i < stations.length; i++) {
            dists.add(stations[i] - stations[i - 1]);
            max = Math.max(stations[i] - stations[i - 1], max);
        }
        double min = (double) (stations[stations.length - 1] - stations[0]) / (double)(stations.length - 1 + K);
        while (max - min > 0.000001){
            double mid = min + (max - min) / 2;
            int cnt = 1;
            for(Integer dist : dists){
                cnt += Math.ceil(dist / mid);
            }
            if(cnt > K + stations.length){
                min = mid;
            }else {
                max = mid;
            }
        }
        return max;
    }
}
