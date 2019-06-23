package gelato.leet8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//835
public class largestOverlap {
    //slide的办法 O(N^4)
    int n;
    public int largestOverlap(int[][] A, int[][] B) {
        if (A.length == 0) {
            return 0;
        }
        n = A.length;
        int[][][] overlaps = new int[A.length][B.length][A[0].length + B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    overlaps[i][j][k] = getOverLap(A, B, i, j, k, 0);
                    overlaps[i][j][k + A[0].length] = getOverLap(A, B, i, j, 0, k);
                }
            }
        }
        //DL
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cur = countOverLap(overlaps, i, j);
                max = Math.max(cur, max);
            }
        }
        //DR
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int cur = countOverLap(overlaps, i, -j);
                max = Math.max(cur, max);
            }
        }
        //UL
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cur = countOverLap(overlaps, -i, j);
                max = Math.max(cur, max);
            }
        }
        //UR
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int cur = countOverLap(overlaps, -i, -j);
                max = Math.max(cur, max);
            }
        }
        return max;
    }

    private int countDL(int [][][] overlaps){
        int max = countOverLap(overlaps, 0, 0);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int cur = countOverLap(overlaps, i, j);
                max = Math.max(cur, max);
            }
        }
        return max;
    }

    private int countOverLap(int [][][] overlaps, int deltaR, int deltaC){
        int sum = 0;
        for(int i = 0; i < overlaps.length; i++){
            if(deltaR > 0) {
                sum += overlaps[i][i + deltaR][deltaC > 0 ? deltaC : n + Math.abs(deltaC)];
            }else {
                sum += overlaps[i + deltaR][i][deltaC > 0 ? deltaC : n + Math.abs(deltaC)];
            }
        }
        return sum;
    }

    private int getOverLap(int[][] A, int[][] B, int ai, int bi, int aj, int bj) {
        int overlap = 0;
        for (int k = 0; k + aj < A[0].length && k + bj < B[0].length; k++) {
            if (A[ai][k] == 1 && A[ai][k + aj] == B[bi][k + bj]) {
                overlap++;
            }
        }
        return overlap;
    }

    //Smart method:

    /**
     * Loop on A, if value == 1, save a coordinates i / N * 100 + i % N to LA.
     * Loop on B, if value == 1, save a coordinates i / N * 100 + i % N to LB.
     * Loop on combination (i, j) of LA and LB, increase count[i - j] by 1.
     * If we slide to make A[i] orverlap B[j], we can get 1 point.
     * Loop on count and return max values.
     */
    //O(N^2)的方法
    public int largestOverlap_smart(int[][] A, int[][] B) {
        int N = A.length;
        List<Integer> LA = new ArrayList<>();
        List<Integer> LB = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();//首先是要2D转1D
        for (int i = 0; i < N * N; ++i) if (A[i / N][i % N] == 1) LA.add(i / N * 100 + i % N);
        for (int i = 0; i < N * N; ++i) if (B[i / N][i % N] == 1) LB.add(i / N * 100 + i % N);
        for (int i : LA) for (int j : LB)//第二步就是, 每个i - j 都可以通过各个方向的slide达到, 转化成重叠的count
            count.put(i - j, count.getOrDefault(i - j, 0) + 1);
        int res = 0;
        for (int i : count.values()) res = Math.max(res, i);
        return res;
    }
}
