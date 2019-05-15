package gelato.basic;

public class QSort {
    public void QSort(int [] array){
        QSort(array, 0, array.length - 1);
    }

    public void QSort(int [] array, int low, int high) {
        if (high > low) {
            int pi = partitionM(array, low, high);
            QSort(array, low, pi - 1);
            QSort(array, pi + 1, high);
        }
    }

    private int partitionM(int [] array, int low, int high){
        int pivot = array[low];
        while (low < high){
            //注意 high -- 要放在前面!!! 才能保证low收敛在<=pivot的数字上
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

    //Another way
    private int partition(int [] nums, int low, int high) {
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
