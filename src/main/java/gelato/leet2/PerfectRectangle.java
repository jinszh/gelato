package gelato.leet2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        boolean formed = true;
        if (rectangles.length > 0) {
            List<int[]> recs = Arrays.asList(rectangles);
            Collections.sort(recs, (o1, o2) -> {
                return Integer.compare(o1[0], o2[0]);
            });
            int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
            for (int[] rect : rectangles) {
                if (rect[1] < low) {
                    low = rect[1];
                }
                if (rect[3] > high) {
                    high = rect[3];
                }
            }
            int pos = 0;
            List<int[]> remains = new ArrayList<>();
            while (formed && pos < recs.size()) {
                int nxtPos = Collections.binarySearch(recs, new int[]{recs.get(pos)[0] + 1, 0, 0, 0}, (o1, o2) -> {
                    return Integer.compare(o1[0], o2[0]);
                });
                while (nxtPos < recs.size() && nxtPos > 0 && recs.get(nxtPos - 1)[0] == recs.get(nxtPos)[0]) {
                    nxtPos--;
                }
                if (nxtPos < 0) {
                    nxtPos = -nxtPos - 1;
                }
                List<int[]> sub = new ArrayList<>();
                sub.addAll(recs.subList(pos, nxtPos));
                sub.addAll(remains);
                remains = new ArrayList<>();
                int right = recs.get(pos)[2];
                for (int[] cur : sub) {
                    right = Math.min(right, cur[2]);
                }
                for (int[] cur : sub) {
                    if (cur[2] > right) {
                        remains.add(new int[]{right, cur[1], cur[2], cur[3]});
                    }
                    cur[2] = right;
                }
                if (nxtPos < recs.size() && recs.get(nxtPos)[0] != right) {
                    break;
                }
                Collections.sort(sub, (o1, o2) -> Integer.compare(o1[1], o2[1]));
                if (sub.get(0)[1] != low || sub.get(sub.size() - 1)[3] != high) {
                    break;
                }
                for (int i = 1; i < sub.size(); i++) {
                    if (sub.get(i)[1] != sub.get(i - 1)[3]) {//there is overlap
                        formed = false;
                        break;
                    }
                }
                if (!formed) {
                    break;
                }
                pos = nxtPos;
            }
            return formed && pos == recs.size();
        }
        return formed;
    }
}
