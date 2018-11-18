package gelato.leet2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class countRangeSum {
    /***
     * Merge Sort version
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i)
            sums[i + 1] = sums[i] + nums[i];
        return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sums, start, mid, lower, upper)
                + countWhileMergeSort(sums, mid, end, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; ++i, ++r) {
            while (k < end && sums[k] - sums[i] < lower) k++;
            while (j < end && sums[j] - sums[i] <= upper) j++;
            while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
            cache[r] = sums[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, sums, start, t - start);
        return count;
    }

    /**
     * Segment tree version ---------------------------------------------------
     */
    class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int count;
        long min;
        long max;
        public SegmentTreeNode(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }
    private SegmentTreeNode buildSegmentTree(Long[] valArr, int low, int high) {
        if(low > high) return null;
        SegmentTreeNode stn = new SegmentTreeNode(valArr[low], valArr[high]);
        if(low == high) return stn;
        int mid = (low + high)/2;
        stn.left = buildSegmentTree(valArr, low, mid);
        stn.right = buildSegmentTree(valArr, mid+1, high);
        return stn;
    }
    private void updateSegmentTree(SegmentTreeNode stn, Long val) {
        if(stn == null) return;
        if(val >= stn.min && val <= stn.max) {
            stn.count++;
            updateSegmentTree(stn.left, val);
            updateSegmentTree(stn.right, val);
        }
    }
    private int getCount(SegmentTreeNode stn, long min, long max) {
        if(stn == null) return 0;
        if(min > stn.max || max < stn.min) return 0;
        if(min <= stn.min && max >= stn.max) return stn.count;
        return getCount(stn.left, min, max) + getCount(stn.right, min, max);
    }

    public int countRangeSum2(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        int ans = 0;
        Set<Long> valSet = new HashSet<Long>();
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (long) nums[i];
            valSet.add(sum);
        }

        Long[] valArr = valSet.toArray(new Long[0]);

        Arrays.sort(valArr);
        SegmentTreeNode root = buildSegmentTree(valArr, 0, valArr.length - 1);

        /**
         * 对于每个区间和sum[j,i], 都可以表示为两个prefixSum之差, sum[0,i] - sum[0,j]
         * 对于某个i, 与其前面构成的区间和即为sum[1,i], sum[2,i] ... , sum[i-2, i], sum[i-1,i]
         * 而对于sum[j,i]是否在{lower,upper}range内,也就是
         * --> lower <= sum[0,i] - sum[0,j] <= upper
         * --> sum[0,j]属于range {sum[0,i] - upper, sum[0,i] - lower}
         * --> 所以对于每个i, 需要知道所有的sum[i,j] (j < i)的个数,
         *     就可以通过判断所有sum[0,j]落在{sum[0,i] - upper, sum[0,i] - lower}里面的个数来知道
         */
        ans += nums[0] >= lower && nums[0] <= upper ? 1 : 0;
        sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            /**
             * lower <= currentPrefixSum (sum[0,i])- previousPrefixSum (sum[0,i-1]) <= upper
             *  ==>
             * currentPrefixSum-upper <= previousPrefixSum <= currentPrefixSum-lower
             */
            updateSegmentTree(root, sum);
            sum += nums[i];
            ans += sum >= lower && sum <= upper ? 1 : 0;
            ans += getCount(root, (long) sum - upper, (long) sum - lower);
        }
        return ans;
    }
}
