package gelato.algos;

import java.util.*;

public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> results = new ArrayList<>();
        if (input != null && input.length != 0) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
            for (int v : input) {
                maxHeap.add(v);
            }
            for (int i = 0; i < k && i < input.length; i++) {
                results.add(maxHeap.poll());
            }
        }
        return results;
    }
}
