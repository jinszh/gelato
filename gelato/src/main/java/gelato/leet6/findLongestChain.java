package gelato.leet6;

import java.util.Arrays;

//646
public class findLongestChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        int [] dp = new int[pairs.length];
        int res = 0;
        for(int i = 0; i < pairs.length; i++){
            int max = 1;
            for(int j = 0; j < i; j++){
                if(pairs[j][1] < pairs[i][0] && dp[j] + 1 > max){
                    max = dp[j] + 1;
                }
            }
            dp[i] = max;
            res = Math.max(max, res);
        }
        return res;
    }

    //Optimization - 其实greedy也是可以的 这道题
    public int findLongestChain_greedy(int[][] pairs) {
        Arrays.sort(pairs, (p1,p2)->p1[1]-p2[1] );//按pair尾来sort

        int count = 0, end = Integer.MIN_VALUE;
        for (int[] pair : pairs)
        {
            if (pair[0] > end)
            {
                count++;
                end = pair[1];
            }
        }
        return count;
    }
}
