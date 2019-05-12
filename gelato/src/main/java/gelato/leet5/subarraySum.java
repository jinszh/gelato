package gelato.leet5;

import java.util.HashMap;

public class subarraySum {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        int nans = 0;
        prefix[0] = 0;
        HashMap<Integer, Integer> sumFreq = new HashMap<>();
        sumFreq.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
            nans += sumFreq.getOrDefault(prefix[i + 1] - k, 0);
            sumFreq.put(prefix[i + 1], sumFreq.getOrDefault(prefix[i + 1], 0) + 1);
        }
        return nans;
    }
}
