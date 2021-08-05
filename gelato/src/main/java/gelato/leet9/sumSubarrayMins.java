package gelato.leet9;

//907
//Usage of monotone stack
//

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sum-of-subarray-minimums/discuss/178876/stack-solution-with-very-detailed-explanation-step-by-step
 * Monotone stack, stack里面递增, 所以对每个数都可以找到前面一个次于自己的数, 和后面一个次于自己的数
 * (1) 对于每个A[i]先找到左侧小于A[i]的left[i], 以及右侧小于自己的right[i]
 *  ----以A[i]为min的子川即 : left[i] 与 right[i]中间所有包含 A[i]的子串
 * (2) 计算left[i] 与 right[i]中间所有包含 A[i]的子串数量, e.g.如下
 *  9,7,8,3,4,6. A[i]为3.
 *  与3相连左侧串有{}, {9,7,8}, {7,8}, {8}
 *  与3相连右侧串有{}, {4}, {4,6}
 *  所以所有子串数量为: 左侧串的数量 nleft * 右侧串的数量 nright
 *  */

public class sumSubarrayMins {
    public int sumSubarrayMins(int[] A) {
        int[][] range = new int[A.length][2];
        for (int i = 0; i < range.length; i++) {
            range[i][1] = range.length;
        }
        LinkedList<int[]> monoStack = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            while (!monoStack.isEmpty() && monoStack.peek()[0] > A[i]) {
                int[] p = monoStack.pop();
                range[p[1]][1] = i;
            }
            range[i][0] = monoStack.isEmpty() ? -1 : monoStack.peek()[1];
            monoStack.push(new int[]{A[i], i});
        }
        int sum = 0;
        for (int i = 0; i < range.length; i++) {
            sum = (sum + A[i] * (i - range[i][0]) * (range[i][1] - i) % 1000000007)%1000000007;
        }
        return sum;
    }
}
