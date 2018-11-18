package gelato.leet2;

public class MaxNumFrom2Array {
    //关键是问题的拆分, 需要拆分成从num1中选i个数, num2中选k-i个数.然后就可以用贪心了
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
            int [] can1 = maxArray(nums1, i);
            int [] can2 = maxArray(nums2, k - i);
            int[] candidate = merge(can1, can2, k);
            if (greater(candidate, 0, ans, 0)){
                ans = candidate;
            }
        }
        return ans;
    }
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int i = 0, j = 0;
        for(int valid = 0; valid < k; valid++){
            if(i < nums1.length && j < nums2.length){
                res[valid] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
            }else if(i < nums1.length){
                res[valid] = nums1[i++];
            }else if(j < nums2.length){
                res[valid] = nums2[j++];
            }
        }
        return res;
    }
    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] > nums2[j]){
                return true;
            }else if(nums1[i] < nums2[j]){
                return false;
            }else{
                i++; j++;
            }
        }
        if(i < nums1.length){
            return true;
        }else{
            return false;
        }
    }
    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }
}
