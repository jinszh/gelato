package gelato.leet0;

//33
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int res = -1;
        boolean straight = false;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                res = m;
                break;
            }
            if (straight) {
                if (nums[m] < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else if (nums[m] >= nums[l]) { // left part straight
                if (target > nums[m] || target < nums[l]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                    straight = true;
                }
            } else { // right part straight
                if (target < nums[m] || target > nums[r]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                    straight = true;
                }
            }
        }
        if (nums[l] == target) res = l;
        return res;
    }
}
