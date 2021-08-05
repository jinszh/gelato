package gelato.leet9;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

//954
public class canReorderDoubled {
    public boolean canReorderDoubled(int[] A) {
        Arrays.sort(A);
        boolean[] used = new boolean[A.length];
        for (int i = 0; i < A.length; ) {
            if (used[i]) {
                i++;
                continue;
            }
            if (A[i] < 0) {
                if (A[i] % 2 != 0) return false;
                int half = binarySearch(A, A[i] / 2, i + 1, A.length - 1);
                if (!(half > i && A[half] * 2 == A[i] && processDup(A, used, i, half, A[half]))) {
                    return false;
                }
            } else if (A[i] > 0) {
                if (i == A.length - 1) return false;
                int times = binarySearch(A, A[i] * 2, i + 1, A.length - 1);
                if (!(times > i && A[times] == A[i] * 2 && processDup(A, used, i, times, A[times]))) {
                    return false;
                }
            } else {
                if (i < A.length - 1 && A[i + 1] == 0) {
                    i += 2;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean processDup(int[] A, boolean[] used, int i, int j, int target) {
        int istart = i;
        while (A[i] == A[istart] && i < A.length) {
            if (j < A.length && A[j] == target) {
                used[i] = true;
                used[j] = true;
            } else {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    private int binarySearch(int[] A, int n, int l, int r) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (A[mid] < n) {
                l = mid + 1;
            } else if (A[mid] > n) {
                r = mid - 1;
            } else {
                if (l > 0 && A[mid - 1] == A[mid]) {
                    r = mid - 1;
                } else {
                    l = mid;
                    break;
                }
            }
        }
        return l;
    }

    //差不多的思路, 但是用的treemap, 所以code简单,不用自己写binary search等
    public boolean canReorderDoubled2(int[] A) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int a : A)
            count.put(a, count.getOrDefault(a, 0) + 1);
        for (int x : count.keySet()) {
            if (count.get(x) == 0) continue;
            int want = x < 0 ? x / 2 : x * 2;
            if (x < 0 && x % 2 != 0 || count.get(x) > count.getOrDefault(want, 0))
                return false;
            count.put(want, count.get(want) - count.get(x));
        }
        return true;
    }
}
