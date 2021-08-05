package gelato.leet3;

//324
public class wiggleSort {
    //所谓O(N)就是认为找median是O(n)的  用的是partition的方法... 类似于215的find Kth element理论上来说average是O(N)
    //https://en.wikipedia.org/wiki/Quickselect -- 为啥quick select 是 O(N)
    //大致意思就是 T(N) + T(n/2) + T(n/4) + ... = T(N) * (1 + 1/2 + 1/4 + 1/8 +...) = T(2N) ~ O(N)
    //https://stackoverflow.com/questions/8783408/why-is-the-runtime-of-the-selection-algorithm-on
    public void wiggleSort(int[] nums) {
        int median = median(nums, (nums.length - 1) / 2);
        int l = 0; int m = 0; int r = nums.length - 1;
        while(m <= r){
            if(nums[get(nums, m)] > median)
                swap(nums, get(nums, m++), get(nums, l++));
            else if(nums[get(nums, m)] < median)
                swap(nums, get(nums, m), get(nums, r--));
            else m++;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int median(int[] nums, int k){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int pi = partition(nums, left, right);
            if(pi == k) return nums[pi];
            else if(pi > k) right = pi - 1;
            else left = pi + 1;
        }
        return 0;
    }

    private int partition(int[]nums, int left, int right){
        int pivot = nums[right];
        int lessIndex = left - 1;
        for(int i = left; i < right; i++){
            if(nums[i] <= pivot){
                lessIndex++;
                swap(nums, i, lessIndex);
            }
        }
        swap(nums, lessIndex + 1, right);
        return lessIndex + 1;
    }

    private int get(int[] nums, int i){
        if(i <= (nums.length / 2 - 1)) return i * 2 + 1;
        return (i - nums.length / 2) * 2;
    }
}
