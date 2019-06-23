package gelato.leet5;

//565
public class arrayNesting {
    public int arrayNesting(int[] nums) {
        int res = nums.length > 0 ? 1 : 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == i) continue;
            else {
                int len = 0;
                int cur = nums[i];
                nums[i] = -1;
                while (cur >= 0){
                    len++;
                    int nxt = nums[cur];
                    nums[cur] = cur;
                    cur = nxt;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
