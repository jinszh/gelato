package gelato.leet2;

public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        //所谓greedy, 就是假设num是[1,2], n是5, patch3或者4都可以合格, 然后如果patch 4 最多可以拼到7, patch 3却不行,所以在当前情况下选最优的patch
        //https://leetcode.com/problems/patching-array/solution/
        int patches = 0, i = 0;
        long miss = 1; // use long to avoid integer overflow error
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) // miss is covered
                miss += nums[i++];
            else { // patch miss to the array
                miss += miss;
                patches++; // increase the answer
            }
        }
        return patches;
    }
}
