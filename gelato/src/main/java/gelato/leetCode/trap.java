package gelato.leetCode;

import java.util.Stack;

public class trap {
    public int trap(int[] height) {
        int trap = 0;
        Stack<Integer> w = new Stack<>();
        Stack<Integer> wid = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            Integer prew = w.isEmpty() ? 0 : w.peek();
            if (prew >= height[i]) {
                w.push(height[i]);
                wid.push(i);
            } else if (prew < height[i]) {
                Integer lid2 ;
                while (!w.isEmpty() && w.peek() < height[i]) {
                    int h = w.pop();
                    wid.pop();
                    lid2 = !wid.isEmpty() ? wid.peek() : null;
                    if(lid2 != null) {
                        trap += (i - lid2 - 1) * (Math.min(height[i], height[lid2]) - h);
                    }
                }
                w.push(height[i]);
                wid.push(i);
            }
        }
        return trap;
    }
}
