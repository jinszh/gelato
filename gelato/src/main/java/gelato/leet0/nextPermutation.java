package gelato.leet0;

import java.util.Arrays;

//31
public class nextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length > 1) {
            int i = nums.length - 1;
            for (; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    for(int j = nums.length - 1; j >= i; j--){
                        if(nums[j] > nums[i - 1]){
                            swap(nums, j, i - 1);
                            break;
                        }
                    }
                    break;
                }
            }
            Arrays.sort(nums, i, nums.length);
        }
    }

    private void swap(int [] nums, int i, int j)
    {
        int swap = nums[j];
        nums[j] = nums[i];
        nums[i] = swap;
    }
}
