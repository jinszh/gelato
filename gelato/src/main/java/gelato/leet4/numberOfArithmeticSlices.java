package gelato.leet4;

//413
public class numberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        for (int i = 0, j = 1; j < A.length - 1; j++) {
            if (A[j + 1] - A[j] == A[j] - A[j - 1]) {
                //Count
                res += (j - i);
            } else {
                i = j;
            }
        }
        return res;
    }
}
