package gelato.leet3;

import java.util.Arrays;

//370
public class getModifiedArray {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length + 1];
        for (int[] u : updates) {
            res[u[0]] += u[2];
            res[u[1] + 1] -= u[2];
        }
        int mod = 0;
        for (int i = 0; i < res.length; i++) {
            mod += res[i];
            res[i] = mod;
        }
        return Arrays.copyOfRange(res, 0, res.length - 2);
    }
}
