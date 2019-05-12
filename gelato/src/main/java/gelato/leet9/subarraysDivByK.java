package gelato.leet9;

public class subarraysDivByK {
    public int subarraysDivByK(int[] A, int K) {
        int [] prefix = new int[A.length + 1];
        int nans = 0;
        prefix[0] = 0;
        for (int i = 0; i < A.length; i++) {
            prefix[i + 1] = prefix[i] + A[i];
        }

        for(int i = 0; i < A.length; i ++) {
            for (int j = 0; j <= i; j++) {
                if ((prefix[i + 1] - prefix[j]) % K == 0) {
                    nans++;
                }
            }
        }
        return nans;
    }
}
