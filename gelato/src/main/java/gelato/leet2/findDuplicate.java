package gelato.leet2;

//287
public class findDuplicate {
    public int findDuplicate(int[] nums) {
        int res = -1;
//        for(int i = 0; i < nums.length; i++) {
//            if (nums[i] != i) {
//                int cur = nums[i];
//                nums[i] = -1;
        int cur = nums[0];
        //nums[i] = -1; 0不会到达,所以不需要
        while (true) {
            int nxt = nums[cur];
            if (nxt == cur) {
                res = cur;
                break;
            }
            nums[cur] = cur;
            cur = nxt;
        }
//        if (res > 0)
//            break;
        //}
        // }
        return res;
    }

    //另外一个解法, 有重复的数, 则一定有环, 而且只有一个重复的数字, 所以重复的entry一定会被重复地通过, 于是第二次通过时就会成环
    //所以上面其实也同理, 从第一个数出发,一定可以重复抵达重复数字的entry
    /**
     * eg.
     * 数组为: 3,5,2,1,1,4
     * 坐标为: 0,1,2,3,4,5
     * 访问为: 0->3->1->5->4->1
     */
    public int findDuplicate3(int [] nums)
    {
        if (nums.length > 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}
