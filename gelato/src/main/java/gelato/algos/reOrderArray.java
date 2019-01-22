package gelato.algos;

//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

import java.util.Arrays;
import java.util.stream.Stream;

public class reOrderArray {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        boolean valid = true;
        if(pushA == null && popA == null){return true;}
        else if(pushA == null || popA == null){return false;}
        else{
            boolean [] pushed = new boolean[popA.length];
            boolean [] poped = new boolean[popA.length];
            Arrays.fill(pushed, false);
            Arrays.fill(poped, false);
            for(int i = 0; i < popA.length; i++){
                int pos = findPos(popA[i], pushA);
                pushed[pos] = true;
                Arrays.fill(pushed, 0, pos, true);
                poped[pos] = true;

                for(int j = pos + 1;j< pushA.length; j++){
                    if(!((pushed[j] && poped[j]) || (!pushed[j] && !poped[j]))){
                        valid = false;
                        break;
                    }
                }
                if(!valid){
                    break;
                }
            }
        }
        return valid;
    }

    int findPos(int value, int [] array){
        int pos = -1;
        for(int i = 0 ; i < array.length; i ++){
            if(array[i] == value){
                pos = i;
            }
        }
        return pos;
    }
}
