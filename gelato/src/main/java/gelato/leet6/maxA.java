package gelato.leet6;

import java.util.Arrays;

//651
public class maxA {
    public int maxA(int N) {
        int[] res = new int[N + 1];
        for (int i = 0; i <= 3 && i <= N; i++) res[i] = i;
        for (int i = 4; i <= N; i++) {
            res[i] = i;
            for (int j = 2; j <= i - 3; j++) {
                res[i] = Math.max(res[i], res[j] * (i - j - 1));
            }
        }
        return res[N];
    }
}
