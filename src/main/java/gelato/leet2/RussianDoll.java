package gelato.leet2;

import java.util.Arrays;

public class RussianDoll {
    public int maxEnvelopes(int[][] envelopes) {
        int n = 0;
        if(envelopes.length > 0) {
            Arrays.sort(envelopes, (a, b) -> {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            });
            int tail[] = new int[envelopes.length];
            int len = 0;
            for (int[] envelope : envelopes) {
                int index = Arrays.binarySearch(tail, 0, len, envelope[1]);
                if (index < 0)
                    index = -(index + 1);
                tail[index] = envelope[1];
                if (index == len)
                    len++;
            }
            n = len;
        }
        return n;
    }
}
