package gelato.leet9;

import java.util.ArrayList;
import java.util.List;

//969
public class pancakeSort {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        int last = A.length - 1;
        while (last > 0){
            int max = Integer.MIN_VALUE;
            int maxId = -1;
            for(int i = 0 ; i <= last; i++){
                if(A[i] > max){
                    maxId = i;
                    max = A[i];
                }
            }
            if(maxId < last) {
                if(maxId > 0) {
                    res.add(maxId + 1);
                    flip(A, 0, maxId);
                }
                res.add(last + 1);
                flip(A, 0, last);
            }
            last--;
        }
        return res;
    }

    private void flip(int [] nums, int l, int r){
        while (l < r) {
            int swap = nums[l];
            nums[l] = nums[r];
            nums[r] = swap;
            l++;
            r--;
        }
    }
}
