package gelato.algos;

import java.util.ArrayList;
import java.util.Arrays;

public class DictSort {
    public ArrayList<String> Permutation(String str) {
        char a[] = str.toCharArray();
        Arrays.sort(a);
        return permutation(a);
    }

    ArrayList<String> permutation(char a[]) {
        if (a == null || a.length == 0) {
            return null;
        }
        ArrayList<String> lists = new ArrayList<>();
        lists.add(new String(a));
        while (true) {
            int li = -1;
            for (int i = 1; i < a.length; i++) {
                if (a[i] > a[i - 1]) {
                    li = i - 1;
                }
            }
            if (li < 0) {
                break;
            }
            int j = li + 1;
            for (; j < a.length && a[j] > a[li]; j++) ;
            j = j - 1;
            swap(a, li, j);
            for (int k1 = li + 1, k2 = a.length - 1; k2 > k1; k1++, k2--) {
                swap(a, k1, k2);
            }
            lists.add(new String(a));
        }
        return lists;
    }

    private void swap(char a[], int i , int j){
        char swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
