package gelato.leet9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class intervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<int []> res = new ArrayList<>();
        int ai = 0;
        int bi = 0;
        while (ai < A.length && bi < B.length){
            int [] overLap = null;
            if(A[ai][0] < B[bi][0]){
                if(A[ai][1] >= B[bi][0]) {
                    overLap = new int[]{B[bi][0], Math.min(A[ai][1], B[bi][1])};
                    if (A[ai][1] < B[bi][1]) {
                        ai++;
                    }else if (A[ai][1] > B[bi][1]) {
                        bi++;
                    }else {
                        ai++;bi++;
                    }
                }else{
                    ai++;
                }
            }else if(A[ai][0] == B[bi][0]){
                overLap = new int[]{A[ai][0], Math.min(A[ai][1], B[bi][1])};
                if(A[ai][1] < B[bi][1]) {
                    ai++;
                }else if(A[ai][1] > B[bi][1]) { //code大量重复.
                    bi++;
                }else {
                    ai++;bi++;
                }
            }else{
                if(A[ai][0] <= B[bi][1]) {
                    overLap = new int[]{A[ai][0], Math.min(A[ai][1], B[bi][1])};
                    if (A[ai][1] > B[bi][1]) {
                        bi++;
                    }else if (A[ai][1] < B[bi][1]) {
                        ai++;
                    }else {
                        ai++;bi++;
                    }
                }else {
                    bi++;
                }
            }
            if(overLap != null){
                res.add(overLap);
            }
        }
        return (int[][]) res.toArray(new int[res.size()][2]);
    }

    public int[][] intervalIntersection_simple(int[][] A, int[][] B) {
        if(A == null || A.length == 0 || B == null || B.length == 0)
            return new int[][]{};
        List<int[]> res = new ArrayList<>();

        int i = 0, j = 0;
        int startMax, endMin;
        while(i < A.length && j < B.length){
            startMax = Math.max(A[i][0], B[j][0]);
            endMin = Math.min(A[i][1], B[j][1]);

            if(endMin >= startMax)
                res.add(new int[]{startMax, endMin});

            if(A[i][1] == endMin) i++;
            if(B[j][1] == endMin) j++;
        }

        return res.toArray(new int[res.size()][2]);
    }
}
