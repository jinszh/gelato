package gelato.algos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;


public class StackLuohan {
    public int getHeight(int[][] actors, int n) {
        Arrays.sort(actors, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[0], a[0]);
            }
        });
        int max = 1;
        int [] maxes = new int[n];
        Arrays.fill(maxes, 1);
        for(int i = 0 ; i < n; i ++){
            for(int j = 0; j < i; j++){
                if(actors[i][1] < actors[j][1] && maxes[i] < maxes[j] + 1){
                    maxes[i] = maxes[j] + 1;
                    if(maxes[i] > max){
                        max = maxes[i];
                    }
                }
            }
        }
        return max;
    }
}
