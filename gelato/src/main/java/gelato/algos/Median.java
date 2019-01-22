package gelato.algos;

import java.util.PriorityQueue;

public class Median {
    PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>((o1, o2) -> o2.compareTo(o1));
    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();

    public void Insert(Integer num) {
        if(maxheap.size() == 0 && minheap.size() == 0){
            maxheap.add(num);
        }else if(minheap.size() == 0){
            if(num > maxheap.peek()){
                minheap.add(num);
            }else{
                minheap.add(maxheap.poll());
                maxheap.add(num);
            }
        }else {
            if(num > maxheap.peek()){
                minheap.add(num);
            }else{
                maxheap.add(num);
            }
            if(minheap.size() > maxheap.size() + 1){
                maxheap.add(minheap.poll());
            }else if(minheap.size() < maxheap.size() - 1){
                minheap.add(maxheap.poll());
            }
        }
    }

    public Double GetMedian() {
        if(minheap.size() == 0 || maxheap.size() ==0){
            if(minheap.size() != 0){
                return (double)minheap.peek();
            }else if(maxheap.size() != 0){
                return (double)maxheap.peek();
            }else{
                return null;
            }
        }
        if(minheap.size() == maxheap.size()){
            return ((double)minheap.peek() + (double)maxheap.peek())/2;
        }else{
            if(minheap.size() > maxheap.size()){
                return (double)minheap.peek();
            }else{
                return (double)maxheap.peek();
            }
        }
    }
}
