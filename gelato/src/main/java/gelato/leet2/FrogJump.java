package gelato.leet2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrogJump {
    public boolean canCross(int[] stones) {
        boolean can = false;
        boolean[][] p = new boolean[stones.length][stones.length];//direct predecessor
        p[0][1] = stones[1] - stones[0] == 1;
        for (int i = 1; i < stones.length; i++) {
            for (int j = 0; j < i; j++) {
                if (p[j][i]) {
                    int step = stones[i] - stones[j];
                    List<Integer> nxtHop = new ArrayList<>();
                    if (step > 1) {
                        nxtHop.add(stones[i] + step - 1);
                    }
                    nxtHop.add(stones[i] + step);
                    nxtHop.add(stones[i] + step + 1);
                    for (Integer nxt : nxtHop) {
                        int nid = Arrays.binarySearch(stones, nxt);
                        if (nid > 0) {
                            p[i][nid] = true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < stones.length; i++) {
            if (p[i][stones.length - 1]) {
                can = true;
            }
        }
        return can;
    }
}
