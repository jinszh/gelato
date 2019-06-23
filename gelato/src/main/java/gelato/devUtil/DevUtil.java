package gelato.devUtil;

import java.util.Arrays;

public class DevUtil {
    public static int binarySearchLast(int[] nums, int key) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = (l + h) / 2;
            if (nums[mid] < key) {
                l = mid + 1;
            } else if (nums[mid] > key) {
                h = mid;
            } else {
                if (mid < nums.length - 1 && nums[mid + 1] == nums[mid]) {
                    l = mid + 1;
                } else {
                    l = mid;
                    break;
                }
            }
        }
        return nums[l] != key ? (nums[l] < key ? -(l + 2) : -(l + 1)) : l;
    }

    public static int binarySearchFirst(int [] nums, int target){
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = l + (r - l) /2;
            if(nums[mid] < target){
                l = mid + 1;
            }else if((mid > 0 && nums[mid - 1] == target) || nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid;
                break;
            }
        }
        return nums[l] != target ? (nums[l] < target ? -(l + 2) : -(l + 1)) : l;
    }
}
