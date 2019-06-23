package gelato.leet3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//360
public class sortTransformedArray {
    //其实考察的是1元二次方程, 初中数学
    //https://www.mathplanet.com/education/algebra-1/quadratic-equations/the-graph-of-y-ax-2-plus-bx-plus-c
    //简单证明: aX^2 + bX + c = a*(x + b/2a)*(x + b/2a) + (c - b^2/4a)
    //min or max point (x = -b/2a)
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        if(a == 0) {
            List<Integer> l = Arrays.stream(nums).map(o -> o * b + c).boxed().collect(Collectors.toList());
            if (b < 0) {
                Collections.reverse(l);
            }
            res = l.stream().mapToInt(Integer::intValue).toArray();
            return res;
        }
        int mid = (int)Math.round(- (double) b / ((double)a * 2));
        int id = Arrays.binarySearch(nums, mid);
        if (id < 0) id = -id - 2;
        int left = id, right = id + 1;
        int i = a > 0 ? 0 : nums.length - 1;
        while (left >= 0 && right < nums.length) {
            int vl = a * nums[left] * nums[left] + b * nums[left] + c;
            int vr = a * nums[right] * nums[right] + b * nums[right] + c;
            if (vl < vr) {
                if (a > 0) {
                    res[i++] = vl;
                    left--;
                } else {
                    res[i--] = vr;
                    right++;
                }
            } else {
                if (a > 0) {
                    res[i++] = vr;
                    right++;
                } else {
                    res[i--] = vl;
                    left--;
                }
            }
        }
        while (left >= 0){
            res[a > 0 ? i++: i--] = a * nums[left] * nums[left] + b * nums[left] + c;
            left--;
        }
        while (right < nums.length){
            res[a > 0 ? i++: i--] = a * nums[right] * nums[right] + b * nums[right] + c;
            right++;
        }
        return res;
    }


    //改进 - 因为是个抛物线, 两边往中间走就行了, 并不需要计算b/2a, 知道最大或最小点在中间就行了!!!
    public int[] sortTransformedArray_simple(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] sorted = new int[n];
        int i = 0, j = n - 1;
        int index = a >= 0 ? n - 1 : 0;
        while (i <= j) {
            if (a >= 0) {//b也可以同理, 其实就是倾斜直线,一边高一边低
                sorted[index--] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[i++], a, b, c) : quad(nums[j--], a, b, c);
            } else {
                sorted[index++] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[j--], a, b, c) : quad(nums[i++], a, b, c);
            }
        }
        return sorted;
    }

    private int quad(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
