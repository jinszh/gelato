package gelato.leet3;

import java.util.Arrays;
import java.util.PriorityQueue;

//313
public class nthSuperUglyNumber {
    //用priority queue理论上O(nlogk), 其实慢, 因为使用了复杂的java objects instead of primitive types
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n + 1];
        int[] pointers = new int[primes.length];
        Arrays.fill(pointers, 0);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int cur = 2;
        for (int i = 0; i < pointers.length; i++) {
            heap.add(new int[]{primes[i], 1, i});
        }
        ugly[1] = 1;
        while (cur <= n) {
            int[] top = heap.poll();
            if(ugly[cur - 1] < top[0]) {
                ugly[cur++] = top[0];
            }
            heap.add(new int[]{primes[top[2]] * (ugly[top[1] + 1]), top[1] + 1, top[2]});
        }
        return ugly[n];
    }

    //不用queue维护, 反而更快. 简单快速 O(kn)
    public int nthSuperUglyNumber_simple(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);

        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;

            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                //skip duplicate and avoid extra multiplication
                if (val[j] == ugly[i]) val[j] = ugly[idx[j]++] * primes[j];
                //find next ugly number
                next = Math.min(next, val[j]);
            }
        }

        return ugly[n - 1];
    }
}
