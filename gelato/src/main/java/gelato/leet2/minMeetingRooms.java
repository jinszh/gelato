package gelato.leet2;

import java.util.Arrays;

//253
public class minMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        int res = 0, cnt = 0;
        if(intervals.length > 0) {
            int[] sarr = Arrays.stream(intervals).mapToInt(o -> o[0]).toArray();
            int[] earr = Arrays.stream(intervals).mapToInt(o -> o[1]).toArray();
            Arrays.sort(sarr);
            Arrays.sort(earr);

            int s = 0;
            for (int e = 0; e < earr.length; e++) {
                for (; s < sarr.length && sarr[s] < earr[e]; s++) {
                    cnt++;
                    res = Math.max(cnt, res);
                }
                cnt--;
            }
        }
        return res;
    }
}
