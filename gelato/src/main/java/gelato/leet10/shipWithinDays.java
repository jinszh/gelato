package gelato.leet10;

import java.util.Arrays;
import java.util.stream.IntStream;

public class shipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        int l = 0, r = 0;
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int load = 0;
            int cnt = 0;
            for(int w : weights){
                if(load + w > mid) {
                    cnt++;
                    load = 0;
                }
                load += w;
            }
            cnt++;
            if(cnt <= D){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
    //Binary Search
    public int shipWithinDays_sol1(int[] weights, int D) {
        /*
         * Find the least possible capacity of ship. It will be maximum of -> the
         * largest item or the weight on one ship if the weight is evenly distributed on
         * all the ships i.e. (sum_of_all_items)/(total_ships)
         */
        int heaviestItem = weights[0];
        int weightSum = 0;
        for (int x : weights) {
            heaviestItem = Math.max(heaviestItem, x);
            weightSum += x;
        }
        int avgWeightOnShip = (int) weightSum / D;
        // Minimum required weight capacity of a ship
        int minWeight = Math.max(heaviestItem, avgWeightOnShip);

        // Start from minimum possible size to maximum possible
        for (int i = minWeight; i <= weights.length * minWeight; i++) {
            int[] ship = new int[D];
            int index = 0;
            // Fill all the ships
            for (int j = 0; j < ship.length; j++) {
                // Try to fit as many items as possible
                while (index < weights.length && ship[j] + weights[index] < i) {
                    ship[j] += weights[index];
                    index++;
                }
            }
            if (index == weights.length)
                return i - 1;
        }
        return 0;
    }

}
