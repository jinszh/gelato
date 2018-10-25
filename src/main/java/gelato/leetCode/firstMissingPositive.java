package gelato.leetCode;

public class firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int result = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > nums.length){
                nums[i] = -1;
            }else if(nums[i] >= 0){
                int k = nums[i];
                while (k > 0 && k <= nums.length && k != nums[k - 1]){
                    int tmp = nums[k - 1];
                    nums[k - 1] = k;
                    k = tmp;
                }
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                result = i + 1;
                break;
            }
        }
        return result == -1 ? nums.length + 1 : result;
    }
}
