package gelato.basic;

public class QSort {
    public void QSort(int [] array){
        QSort(array, 0, array.length - 1);
    }

    public void QSort(int [] array, int low, int high) {
        if (high > low) {
            int pi = partitionH(array, low, high);
            QSort(array, low, pi - 1);
            QSort(array, pi + 1, high);
        }
    }

    private int partitionH(int [] array, int low, int high){
        int pivot = array[high];
        int i = low;
        for(int j = low ; j < high; j++){
            if(array[j] < pivot){
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, high);
        return i;
    }

    private int partitionM(int [] array, int low, int high){

        int id = (low + high) / 2;
        int pivot = array[id];
        return id;
    }

    private void swap(int [] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }



}
