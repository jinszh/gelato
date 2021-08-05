package gelato.leet0;

//80
public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0, res = 0;
        while (fast < nums.length) {
            int count = 0;
            while (fast < nums.length && nums[slow] == nums[fast]) {
                count++;
                fast++;
            }
            slow += count > 1 ? 2 : 1;
            if (fast < nums.length && slow != fast) {
                nums[slow] = nums[fast];
                if (fast < nums.length - 1 && nums[fast] == nums[fast + 1]) {
                    nums[slow + 1] = nums[fast];
                    res = slow + 1;
                }
            }
        }
        return res > slow ? res : slow;
    }

    //更清晰的思路....就是写k个相同的数.. k以上的便跳过....
    public int removeDuplicates_simple(int[] nums) {
        int slow = 1, ndup = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                ndup++;
                if(ndup > 1) continue;
            }else {
                ndup = 0;
            }
            nums[slow++] = nums[i];
        }
        return slow;
    }
}
