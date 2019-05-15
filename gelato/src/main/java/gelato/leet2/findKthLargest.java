package gelato.leet2;

import java.util.PriorityQueue;
import java.util.Random;

public class findKthLargest {
    //My solution : O(NlogK) -- heap sort
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for(int i = 0 ; i < nums.length; i++){
            if(queue.size() < k){
                queue.add(nums[i]);
            }else {
                if(queue.peek() < nums[i]){
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();
    }

    //下面Quick select的方法 实测下来 没有shuffle的话没有heap sort快
    //Partition method - Quick select 类似于quick sort, 用的方法是partition, best case O(N), worst case O(N^2)
    public int findKthLargest_par(int[] nums, int k) {
        shuffle(nums);//用了shuffle之后倒确实快了很多
        int lo = 0, hi = nums.length - 1;
        int m;
        k = nums.length - k;
        while (lo < hi) {
            m = partition(nums, lo, hi);
            if (m < k) {
                lo = m + 1;
            } else if (m > k) {
                hi = m - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int [] array, int low, int high) {
        int pivot = array[low];
        while (low < high){
            while (array[high] > pivot && low < high) {
                high--;
            }
            array[low] = array[high];
            while (array[low] <= pivot && low < high){
                low++;
            }
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }

    private void shuffle(int a[]) {
        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            int swap = a[ind];
            a[ind] = a[r];
            a[r] = swap;
        }
    }
}
