package gelato.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FreqStack {
    Map<Integer,Integer> map;
    PriorityQueue<int[]> pq;
    int index;
    public FreqStack() {
        map = new HashMap<>();
        pq = new PriorityQueue<>((a,b) -> {
            if (a[1] == b[1]) return b[2] - a[2];
            else return b[1] - a[1];
        });
        index = 0;
    }

    public void push(int x) {
        int freq = map.getOrDefault(x,0) + 1;
        map.put(x,freq);
        pq.offer(new int[]{x, freq, index++});
    }

    public int pop() {
        int temp =  pq.poll()[0];
        if (map.get(temp) == 1) map.remove(temp);
        else map.put(temp, map.get(temp)-1);
        return temp;
    }
}
