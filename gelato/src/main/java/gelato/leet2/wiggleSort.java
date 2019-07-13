package gelato.leet2;

//280
public class wiggleSort {
    public void wiggleSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            if(i%2 != 0 && nums[i + 1] > nums[i]){
                swap(nums, i, i + 1);
            }else if(i % 2 == 0 && nums[i + 1] < nums[i]){
                swap(nums, i, i + 1);
            }
        }
    }

    private void swap(int [] num, int i, int j){
        int swap = num[i];
        num[i] = num[j];
        num[j] = swap;
    }
}
