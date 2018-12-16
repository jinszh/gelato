package gelato.lee500;

import java.util.Arrays;

public class FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        int[][] steps = new int[ring.length()][key.length()];
        for (int[] arr : steps) Arrays.fill(arr, Integer.MAX_VALUE);
        for (int kl = key.length() - 1; kl >= 0; kl--) {
            for (int s = ring.length() - 1; s >= 0; s--) {
                if (ring.charAt(s) == key.charAt(kl)) {
                    steps[s][kl] = kl == key.length() - 1 ? 1 : steps[s][kl + 1] + 1;
                    int u = s, d = s;
                    int cnt = 1;
                    int diff = 0;
                    while (true) {
                        u = u + 1 < ring.length() ? u + 1 : 0;
                        d = d - 1 >= 0 ? d - 1 : ring.length() - 1;
                        diff = u - d;
                        if (steps[u][kl] > steps[s][kl] + cnt) steps[u][kl] = steps[s][kl] + cnt;
                        if (steps[d][kl] > steps[s][kl] + cnt) steps[d][kl] = steps[s][kl] + cnt;
                        if (u == d || (u - d) * diff < 0) break;
                        cnt++;
                    }
                }
            }
        }
        return steps[0][0];
    }
}
