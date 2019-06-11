package gelato.leet0;

import java.util.ArrayList;
import java.util.LinkedList;

//11
public class maxArea {
    public int maxArea(int[] height) {
        if (height.length <= 1) return 0;
        int maxArea = 0;
        int l = 0, h = height.length - 1;
        while (l < h) {
            maxArea = Math.max(Math.min(height[l], height[h]) * (h - l), maxArea);
            int low = height[l], high = height[h];
            if (low < high) {
                while (l < h && height[l] <= low) l++;
            } else {
                while (l < h && height[h] <= high) h--;
            }
        }
        return maxArea;
    }
}
