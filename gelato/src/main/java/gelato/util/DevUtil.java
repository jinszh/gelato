package gelato.util;

public class DevUtil {
    public static int biSearchFirst(int [] array, int start, int end, int key) {
        int mid = (start + end) / 2;
        while (start <= end) {
            if (array[mid] == key && (mid == 0 || array[mid] > array[mid - 1])) {
                return mid;
            } else {
                if (array[mid] > key || (array[mid] == key && mid > 0 && array[mid] == array[mid - 1])) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -mid;
    }

    public static int biSearchLast(int [] array, int start, int end, int key) {
        if (start > end) throw new IllegalArgumentException("Start must before end for BiSearch");
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (array[mid] == key && (mid == array.length - 1 || array[mid] < array[mid + 1])) {
                return mid;
            } else {
                if (array[mid] < key || (array[mid] == key && mid < array.length - 1 && array[mid] == array[mid + 1])) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -mid;
    }

    public static void Qsort(int[] follow, int[] order, int b, int e) {
        if (b >= e) return;
        int vi = b;
        int v = order[b];
        int vp = follow[b];
        for (int j = vi + 1; j <= e; j++) {
            if (order[j] < v) {
                order[vi] = order[j];
                follow[vi] = follow[j];
                order[j] = v;
                follow[j] = vp;
                vi = j;
            }
        }
        Qsort(follow, order, b, vi - 1);
        Qsort(follow, order, vi + 1, e);
    }
}
