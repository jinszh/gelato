package gelato.leet2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        Integer tot = 0;
        if(grid.length > 0 && grid[0].length > 0) {
            List<Integer> x = new ArrayList<>();
            List<Integer> y = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        x.add(j);
                        y.add(i);
                    }
                }
            }
            Collections.sort(x);
            Collections.sort(y);
            Integer xm, ym;

            xm = x.get(x.size() / 2);
            ym = y.get(y.size() / 2);
            tot +=  x.stream().mapToInt(o -> Math.abs(o - xm)).sum();
            tot +=  y.stream().mapToInt(o -> Math.abs(o - ym)).sum();
        }
        return tot;
    }
}
