package gelato.algos;

import java.util.ArrayList;

public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length == 0)return;
        int exOrSum = 0;
        for(int i = 0; i < array.length; i++){
            exOrSum ^= array[i];
        }
        int mask = firstBit(exOrSum);
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            if((array[i] & mask) != 0){
                arr1.add(array[i]);
            }else{
                arr2.add(array[i]);
            }
        }
        exOrSum = 0;
        for(int i = 0; i < arr1.size(); i++){
            exOrSum ^= arr1.get(i);
        }
        num1[0] = ~exOrSum;
        exOrSum = 0;
        for(int i = 0; i < arr2.size(); i++){
            exOrSum ^= arr2.get(i);
        }
        num2[0] = ~exOrSum;
    }

    private int firstBit(int v){
        int mask = 1;
        while((v & 1) != 1){
            v = v >> 1;
            mask = mask << 1;
        }
        return mask;
    }
}
