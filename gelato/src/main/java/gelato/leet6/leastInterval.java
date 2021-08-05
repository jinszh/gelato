package gelato.leet6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//621
public class leastInterval {
    public int leastInterval(char[] tasks, int n) {
        int[] taskn = new int[26];
        for (char c : tasks) {
            taskn[c - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int ni : taskn) {
            if (ni > 0) {
                pq.add(ni);
            }
        }
        n = n + 1;
        int res = 0, cur = 0;
        while (!pq.isEmpty()) {
            int size = pq.size();
            ArrayList<Integer> round = new ArrayList<>();
            while (!pq.isEmpty()) {
                int nafter = pq.poll() - 1;
                if (nafter > 0) {
                    round.add(nafter);
                }
                cur++;
                if (cur == n || cur == size) {
                    pq.addAll(round);
                    if (pq.isEmpty()) {
                        res += cur;
                    } else {
                        res += n;
                    }
                    cur = 0;
                    break;
                }
            }
        }
        return res;
    }
}
