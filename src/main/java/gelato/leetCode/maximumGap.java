package gelato.leetCode;

public class maximumGap {
    public long mul(long x, long y){
        return x * y;
    }
    public int maximumGap(int[] nums) {
        int len = nums.length;
        int n = len;
        if(len < 2){
            return 0;
        }
        int mini = nums[0];
        int maxi = nums[0];
        for(int i = 0; i < len; i++){
            mini = Math.min(mini, nums[i]);
            maxi = Math.max(maxi, nums[i]);
        }
        if(mini == maxi){
            return 0;
        }
        boolean[] empty = new boolean[n + 1];
        for(int i = 0; i < n + 1; i++){
            empty[i] = true;
        }
        int[] pmax = new int[n + 1];
        int[] pmin = new int[n + 1];

        for(int i = 0; i < n; i++){
            int idx = (int)(mul(nums[i] - mini, n + 1) / (maxi - mini));
            if(idx > n){
                idx = n;
            }
            if(empty[idx]){
                empty[idx] = false;
                pmax[idx] = nums[i];
                pmin[idx] = nums[i];
            }else{//因为最大的gap一定大于 (max-min)/n, 所以不需要考虑桶内的gap
                pmax[idx] = Math.max(pmax[idx], nums[i]);
                pmin[idx] = Math.min(pmin[idx], nums[i]);
            }
        }
        int res = 0;
        int last = -1;
        for(int i = 0; i < n + 1; i++){
            if(!empty[i]){
                if(last < 0){
                    last = pmax[i];
                }else{
                    res = Math.max(res, pmin[i] - last);
                    last = pmax[i];
                }
            }
        }
        return res;
    }
}
