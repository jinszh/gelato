package gelato.leet4;

import java.util.LinkedList;

//456
public class find132pattern {
    //遍历数组可以从左往右, 这种132的情况应该是从右往左更好理解, s1 < s3 < s2
    //用栈的时候 栈里面可以递增或者递减, 另外弹出来的值也可以利用, 比如这里面, s3就是弹出来的最大的值, 且栈里面的值一定大于s3, s3条件满足时候, 则s2必然存在
    public boolean find132pattern(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3) {
                return true;
            } else {
                while (!stack.isEmpty() &&
                        nums[i] > stack.peek()) {
                    s3 = stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
