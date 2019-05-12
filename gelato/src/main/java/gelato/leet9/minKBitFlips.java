package gelato.leet9;

public class minKBitFlips {
    public int minKBitFlips(int[] A, int K) {
        boolean noRes = false;
        int n = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                n++;
                int j;
                for (j = i; j < i + K && j < A.length; j++) {
                    A[j] = A[j] == 0 ? 1 : 0;
                }
                if (j == A.length && j < i + K) {
                    noRes = true;
                    break;
                }
            }
        }
        return noRes ? -1 : n;
    }
}
