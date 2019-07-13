package gelato.leet0;

//75
public class sortColors {
    //相当于三个指针, 一个走得最快, 一个中间, 一个最慢, 每个指针把经过得地方都赋值
    //一轮就可以了,并没有说一轮具体有多少操作
    public void sortColors(int[] nums) {
        for (int i = 0, j = 0, k = 0; k < nums.length; k++) {
            int temp = nums[k];

            //assigning the current as max
            nums[k] = 2;

            // if original is less than 2 then it should be 0, 1
            if (temp < 2) {
                nums[j] = 1;
                j += 1;
            }

            // if original is less than 1 then it should be 0. The above if statement ensures that 1 - index
            // will always be greater than 0 - index
            if (temp < 1) {
                nums[i] = 0;
                i += 1;
            }
        }
    }

    //类似我之前想法得的two pointer得, 从high到low, 其实one pass指的就是一个循环, 并不限制循环内多少操作
    public void sortColors2(int[] A) {
        if (A == null || A.length < 2) return;
        int low = 0;
        int high = A.length - 1;
        for (int i = low; i <= high; ) {
            if (A[i] == 0) {
                // swap A[i] and A[low] and i,low both ++
                int temp = A[i];
                A[i] = A[low];
                A[low] = temp;
                i++;
                low++;
            } else if (A[i] == 2) {
                //swap A[i] and A[high] and high--;
                int temp = A[i];
                A[i] = A[high];
                A[high] = temp;
                high--;
            } else {
                i++;
            }
        }
    }
}
