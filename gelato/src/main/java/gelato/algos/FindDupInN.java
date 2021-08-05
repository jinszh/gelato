package gelato.algos;

import gelato.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class FindDupInN {
    /* 数组长度为n, 数组中数字都为1到n, 从中找出重复的数字*/
    /**直接利用这1到n就可以了**/
    /**不需要额外的数组或者hash table来保存，题目里写了数组里数字的范围保证在0 ~ n-1 之间，**/
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean dup = false;
        for(int i = 0; i < length ; i++){
            int v = numbers[i];
            if(numbers[i] > length){
                v = v - length;
            }
            if(numbers[v] > length){
                duplication[0] = v;
                dup = true;
                break;
            }else{
                numbers[v] = numbers[v] + length;
            }
        }
        return dup;
    }
}
