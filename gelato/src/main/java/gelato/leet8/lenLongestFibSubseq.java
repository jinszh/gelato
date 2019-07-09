package gelato.leet8;

import java.util.Arrays;

//873
public class lenLongestFibSubseq {
    public int lenLongestFibSubseq(int[] A) {
        boolean[][] vistited = new boolean[A.length][A.length];
        int res = 0;
        for (int i = A.length - 1; i > 0; i--) {
            for (int j = i - 1; j > 0; j--) {
                if (vistited[i][j]) continue;
                int k1 = i, k2 = j, nhop = 0;
                while (k2 > 0) {
                    vistited[k1][k2] = true;
                    int nxt = Arrays.binarySearch(A, 0, k2, A[k1] - A[k2]);
                    if (nxt < 0) {
                        break;
                    }
                    k1 = k2;
                    k2 = nxt;
                    nhop++;
                }
                res = Math.max(res, nhop + 2);
            }
        }
        return res;
    }
}
