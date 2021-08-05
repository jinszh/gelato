package gelato.leet4;

//457
public class circularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        boolean res = false;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % nums.length;
            if (nums[i] == 0) nums[i] = nums.length + i;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= nums.length) continue;
            int be = i, cur = i, nxt = -1;
            int step;
            while (true) {
                step = nums[cur];
                nums[cur] = nums.length + be;
                nxt = cur + step;
                if (nxt < 0) {
                    nxt = nums.length + nxt;
                } else if (nxt >= nums.length) {
                    nxt = nxt - nums.length;
                }
                if (nums[nxt] == nums.length + be) {
                    res = true;
                    break;
                }else if(nums[nxt] >= nums.length){
                    break;
                }
                if(step * nums[nxt] < 0){
                    break;
                }
                cur = nxt;
            }
            if (res) {
                break;
            }
        }
        return res;
    }
}
