package gelato.leet3;

import java.util.*;
import java.util.stream.Collectors;

public class topKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int n : nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> order = new PriorityQueue<int[]>(k, (a, b) -> (Integer.compare(a[1], b[1])));
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (order.size() < k) {
                order.add(new int[]{entry.getKey(), entry.getValue()});
            } else if (order.peek()[1] < entry.getValue()) {
                order.poll();
                order.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        List ans = order.stream().map(o -> o[0]).collect(Collectors.toList());
        return new ArrayList<Integer>(ans);
    }


    //下面是method用的是bucket sort, 所以是O(N)更快
    public List<Integer> topKFrequent_faster(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
