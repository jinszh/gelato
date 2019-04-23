package gelato.leet8;

public class minEatingSpeed {
    public int minEatingSpeed_my(int[] piles, int H) {
        int l = 1, r = 0;
        for (int w : piles) {
            r = Math.max(r, w);
        }
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int cnt = 0;
            for (int w : piles) {
                cnt += w / mid + (w % mid != 0 ? 1 : 0);
            }
            if(cnt <= H) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }

        }
        return l;
    }

    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1, hi = getMaxPile(piles);

        // Binary search to find the smallest valid K.
        while (lo <= hi) {
            int K = lo + ((hi - lo) >> 1);
            if (canEatAll(piles, K, H)) {
                hi = K - 1;
            } else {
                lo = K + 1;
            }
        }

        return lo;
    }

    private boolean canEatAll(int[] piles, int K, int H) {
        int countHour = 0; // Hours take to eat all bananas at speed K.

        for (int pile : piles) {
            countHour += pile / K;
            if (pile % K != 0)
                countHour++;
        }
        return countHour <= H;
    }

    private int getMaxPile(int[] piles) {
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxPile = Math.max(pile, maxPile);
        }
        return maxPile;
    }
}
