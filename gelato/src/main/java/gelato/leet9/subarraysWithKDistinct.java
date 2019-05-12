package gelato.leet9;

import java.util.HashMap;

public class subarraysWithKDistinct {
    public int subarraysWithKDistinct(int[] A, int K) {
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        int b1 = 0, b2 = 0, e = 0;
        cntMap.putIfAbsent(A[b1], 1);
        int n = 0;
        while (b1 <= e && e < A.length) {
            if (cntMap.size() == K) {
                while (cntMap.size() == K) {
                    if (cntMap.get(A[b2]) == 1) {
                        break;
                    }else {
                        cntMap.put(A[b2], cntMap.get(A[b2]) - 1);
                    }
                    b2++;
                }
                n += (b2 - b1 + 1);
            }
            if (cntMap.size() <= K) {
                e++;
                if(e < A.length) {
                    cntMap.put(A[e], cntMap.getOrDefault(A[e], 0) + 1);
                }
            } else {
                while (cntMap.size() > K) {
                    cntMap.put(A[b2], cntMap.get(A[b2]) - 1);
                    if (cntMap.get(A[b2]) == 0) {
                        cntMap.remove(A[b2]);
                    }
                    b2++;
                }
                b1 = b2;
            }
        }
        return n;
    }
}
