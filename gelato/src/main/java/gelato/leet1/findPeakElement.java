package gelato.leet1;

//162
public class findPeakElement {
    public int findPeakElement(int[] nums) {
        return biSearch(nums, 0, nums.length - 1);
    }

    private int biSearch(int[] nums, int l, int r){
        while (l < r){
            int mid = l + (r - l) / 2;
            int ml = mid == 0 ? Integer.MIN_VALUE : nums[mid - 1];
            int mr = mid == nums.length - 1 ? Integer.MIN_VALUE : nums[mid + 1];
            if(nums[mid] > ml && nums[mid] > mr){
                return mid;
            }else if(nums[mid] < ml){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
}
