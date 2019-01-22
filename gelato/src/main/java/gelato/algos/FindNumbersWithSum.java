package gelato.algos;

import java.util.ArrayList;
import java.util.Arrays;

public class FindNumbersWithSum {
        public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = null;
        int l = 0, h = array.length - 1;
        int minProduct = Integer.MAX_VALUE;
        while(l < h){
            if(array[l] + array[h] == sum){
                if(array[l] * array[h] < minProduct){
                    result = new ArrayList<>(Arrays.asList(array[l], array[h]));
                    minProduct = array[l] * array[h];
                }
                h--; l++;
            }else if(array[l] + array[h] > sum){
                h --;
            }else {
                l ++;
            }
        }
        return result;
    }
}
