package gelato.leet3;

//376
public class wiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 1) return nums.length;
        int down = 1, up = 1; //last one count as 1
        int cur = nums.length - 2;
        while (cur >= 0) {
            if (nums[cur + 1] > nums[cur]) {
                up = Math.max(down + 1, up);
            } else if (nums[cur + 1] < nums[cur]) {
                down = Math.max(up + 1, down);
            }
            cur--;
        }
        return Math.max(down, up);
    }
}
