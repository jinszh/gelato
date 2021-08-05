package gelato.leet4;

public class findMaxForm {
    //DFS with memorization
    int [][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[m][n][strs.length];
        return recur(strs, 0, m, n);
    }

    private int recur(String[] strs, int i, int m, int n) {
        if (dp[m][n][i] > 0) return dp[m][n][i];
        int n1 = 0, n0 = 0;
        for (char c : strs[i].toCharArray()) {
            if (c == '0') n0++;
            else {
                n1++;
            }
        }
        if (i == strs.length - 1) {
            dp[m][n][i] = m >= n0 && n >= n1 ? 1 : 0;
        }else if(m >= n0 && n >= n1){
            dp[m][n][i] = Math.max(1 + recur(strs, i + 1, m - n0, n - n1), recur(strs, i + 1, m, n));
        }else {
            dp[m][n][i] = recur(strs, i + 1, m, n);
        }
        return dp[m][n][i];
    }

    //DP method: - 直接dp会更快, 而且只有2d的空间需求
    public int findMaxForm_dp(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s: strs) {
            int[] count = countzeroesones(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--)
                for (int ones = n; ones >= count[1]; ones--)
                    //即加入一块新的石头的时候, < (m - n1, n - n1)的部分是减掉这块石头重量的背包的能达到的最大的容积 + 1,
                    // 后半部分则是不加这块石头的最大容积, 前后比较选大的一部分
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
        }
        return dp[m][n];
    }
    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'0']++;
        }
        return c;
    }
}
