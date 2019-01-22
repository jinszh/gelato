package gelato.algos;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class InversePairs {
    /**
     * 利用归并排序来统计逆序对
     **/
    private AtomicInteger count = new AtomicInteger();

    public int InversePairs(int[] array) {
        if (array == null || array.length <= 1) {
            count.set(0);
        } else {
            sort(array, 0, array.length - 1);
        }
        return count.get();
    }

    private void sort(int[] array, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(array, l, m);
            sort(array, m + 1, r);
            merge(array, l, r, m);
        }
    }

    private void merge(int[] array, int l, int r, int m) {
        int[] a1 = Arrays.copyOfRange(array, l, m + 1);
        int[] a2 = Arrays.copyOfRange(array, m + 1, r + 1);
        int i1 = 0, i2 = 0;
        for (int i = l; i <= r; i++) {
            if (i1 < a1.length && (i2 == a2.length || a1[i1] <= a2[i2])) {
                array[i] = a1[i1];
                i1++;
            } else if (i2 < a2.length && (i1 == a1.length|| a1[i1] > a2[i2])) {
                array[i] = a2[i2];
                i2++;
                if(i1 != a1.length) {
                    count.set(count.get() + a1.length - i1);
                }
            }
        }
    }
}
