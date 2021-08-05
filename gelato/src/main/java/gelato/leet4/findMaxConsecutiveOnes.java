package gelato.leet4;

//487
public class findMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, n0 = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == 0) n0++;
            while (n0 > 1) {
                if (nums[j] == 0) n0--;
                j++;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
