package gelato.algos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class maxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num == null || num.length < size){
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<Integer> qid = new ArrayDeque<Integer>();
        for(int i = 0; i < num.length; i ++){
            if(!qid.isEmpty() && qid.peekFirst() <= i -size){
                qid.pollFirst();
            }
            if(qid.isEmpty() || num[i] > num[qid.peekFirst()]){
                qid.clear();
                qid.offerLast(i);
            }else {
                while (num[i] > num[qid.peekLast()]){
                    qid.pollLast();
                }
                qid.offerLast(i);
            }
            if(i >= size - 1){
                result.add(num[qid.peekFirst()]);
            }
        }

        return result;
    }
}
