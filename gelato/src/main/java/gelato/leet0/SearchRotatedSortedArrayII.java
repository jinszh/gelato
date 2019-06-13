package gelato.leet0;

//81
public class SearchRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        boolean res = false;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                res = true;
                break;
            }
            if (nums[m] == nums[l] && nums[l] == nums[r]) {
                int i = l;
                for(; i < r; i++){
                    if(nums[i] != nums[m]){
                        l = i;
                        break;
                    }
                }
                if(i == r)break;
            } else if (nums[m] > nums[l] || nums[m] > nums[r]) { // left part straight
                if (target > nums[m] || target < nums[l]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else { // right part straight
                if (target < nums[m] || target > nums[r]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        if (nums.length > 0 && nums[l] == target) res = true;
        return res;
    }
}
