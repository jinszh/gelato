package gelato.lee500;

import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> profitHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        PriorityQueue<int[]> capitalHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        for (int i = 0; i < Capital.length; i++) {
            capitalHeap.add(new int[]{Profits[i], Capital[i]});
        }
        for (int i = 0; i < k; i++) {
            while (!capitalHeap.isEmpty() && capitalHeap.peek()[1] <= W) {
                profitHeap.add(capitalHeap.poll());
            }
            if (!profitHeap.isEmpty()) {
                int[] head = profitHeap.poll();
                W += head[0];
            } else {
                break;
            }
        }
        return W;
    }
}
