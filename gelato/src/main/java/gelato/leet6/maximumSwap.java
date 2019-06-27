package gelato.leet6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

//670
public class maximumSwap {
    public int maximumSwap(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
        LinkedList<int[]> stack = new LinkedList<>();
        for(int i = list.size() - 1; i >= 0; i--){
            int prev = i;
            while (!stack.isEmpty() && ( stack.peek()[0] < list.get(i)
                    || (stack.peek()[0] == list.get(i) && stack.peek()[1] != stack.peek()[2]))){
                prev = stack.pop()[2];
            }
            if(stack.isEmpty() || stack.peek()[1] == stack.peek()[2]) {
                stack.push(new int[]{list.get(i), i, prev});
            }
        }
        for(int i = 0; i < stack.size(); i++){
            if(stack.get(i)[2] != stack.get(i)[1]){
                int swap = list.get(stack.get(i)[1]);
                list.set(stack.get(i)[1], list.get(stack.get(i)[2]));
                list.set(stack.get(i)[2], swap);
            }
        }
        int res = 0;
        for(int i = list.size() - 1; i >= 0; i--){
            res += list.get(i);
            res *= 10;
        }
        return res / 10;
    }

    //用桶不用java的各种collection貌似更快
    public int maximumSwap2(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }

        return num;
    }
}
