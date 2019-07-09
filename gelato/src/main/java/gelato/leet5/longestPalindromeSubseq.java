package gelato.leet5;

//516
public class longestPalindromeSubseq {
    public int cnt = 0;
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 0) return 0;
        int max = 1;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 2 : 1;
        }

        for (int j = 2; j < s.length(); j++) {
            for (int i = 0; i + j < s.length(); i++) {
                cnt++;
                dp[i][i + j] = Math.max(Math.max(dp[i + 1][i + j], dp[i][i + j - 1])
                        , s.charAt(i) == s.charAt(i + j) ? dp[i + 1][i + j - 1] + 2 : dp[i + 1][i + j - 1]);
                max = Math.max(max, dp[i][i + j]);
            }
        }
        return max;
    }

    //Another way - 写得简单点
    public int longestPalindromeSubseq2(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                cnt++;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2; // i 倒着走, 则[i+1][j-1],[i+1][j]都出现过了. j正着走, j, j-1的都出现过了
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
