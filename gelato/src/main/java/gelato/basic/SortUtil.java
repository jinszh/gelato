package gelato.basic;

import java.util.Arrays;

public class SortUtil {
    public static void mergeSort(int [] array, int b, int e) {
        if (b == e) return;
        int mid = b + (e - b) / 2;
        if (b < mid) {
            mergeSort(array, b, mid);
        }
        if (mid + 1 < e) {
            mergeSort(array, mid + 1, e);
        }
        int[] aux = new int[e - b + 1];
        int i = b, j = mid + 1, k = 0;
        while (k < e - b + 1) {
            aux[k] = i <= mid && j <= e ? (array[i] < array[j] ? array[i++] : array[j++])
                    : (i <= mid ? array[i++] : array[j++]);
        }
        for (i = 0; i <= aux.length; i++) {
            array[b + i] = aux[i];
        }
    }


    /****************************
     * QSort
     */
    public static void QSort(int [] array){
        QSort(array, 0, array.length - 1);
    }

    public static void QSort(int [] array, int low, int high) {
        if (high > low) {
            int pi = partitionM(array, low, high);
            QSort(array, low, pi - 1);
            QSort(array, pi + 1, high);
        }
    }

    private static int partitionM(int [] array, int low, int high){
        int pivot = array[low];
        while (low < high){
            //low给了pivot, 所以需要把high--放前面, 这样子先把high赋给low
            while (low < high && array[high] >= pivot) high --;
            array[low] = array[high];
            while (low < high && array[low] <= pivot) low ++;
            array[high] = array[low];

          //  swap(array, low, high);
        }
      //  swap(array, low, pivotId);
        array[low] = pivot;
        return low;
    }

    //Another way 用最高位做pivot, 前面用两个指针, 一个走得快, 一个走得慢, 保证慢的指针前面的都是小于Pivot的
    private static int partition(int [] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) { //用的是<= 同理下面用的是>=和<=, 因为i, j起点相同, 如果第一个数比pivot小, j必须也要自加
                int swap = nums[i];
                nums[i] = nums[j];
                nums[j] = swap;
                i++;
            }
        }
        nums[high] = nums[i];
        nums[i] = pivot;
        return i;
    }
}
