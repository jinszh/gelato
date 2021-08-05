package gelato.leet9;

//900
public class RLEIterator {
    int [] A;
    int cur = 0, i = 0;
    public RLEIterator(int[] A) {
        this.A = A;
    }

    public int next(int n) {
        while (i < A.length) {
            if (cur + n > A[i]) {
                n -= (A[i] - cur);
                cur = 0;
                i += 2;
            } else {
                cur += n;
                return A[i + 1];
            }
        }
        return -1;
    }
}
