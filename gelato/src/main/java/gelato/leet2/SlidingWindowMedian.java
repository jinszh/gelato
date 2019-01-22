package gelato.leet2;

import java.util.Comparator;
import java.util.TreeSet;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];
        Comparator<Integer> comparator = (a,b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> high = new TreeSet<Integer>(comparator);
        TreeSet<Integer> low = new TreeSet<Integer>(comparator.reversed());
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                if (nums[i - k] <= nums[low.first()]) {
                    low.remove(i - k);
                } else {
                    high.remove(i - k);
                }
            }
            if(!low.isEmpty() && nums[i] <= nums[low.first()]) {
                low.add(i);
            }else {
                high.add(i);
            }
            if (low.size() > high.size()) {
                high.add(low.pollFirst());
            }else if(high.size() > low.size()){
                low.add(high.pollFirst());
            }
            if (i >= k - 1) {
                medians[i - k + 1] = low.size() > high.size() ? nums[low.first()]
                        : (low.size() == high.size() ? (double) (nums[low.first()] + nums[high.first()]) / 2 : nums[high.first()]);
            }
        }
        return medians;
    }
}
