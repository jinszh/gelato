package gelato.leetCode;

public class Regex_DP {
    //DP - buttom-up
    public boolean isMatch(String s, String p) {
        char [] sa = s.toCharArray();
        char [] pa = p.toCharArray();
        //dp[i,j]表示 s[len - i, len] 和 p[len - j, len]是否匹配 //因为串的边界本来为len-1, 边界加1表示空串的情况
        boolean dp[][] = new boolean[sa.length + 1][pa.length + 1];
        dp[sa.length][pa.length] = true;
        for(int i = s.length(); i >=0; i--){
            for(int j = p.length() - 1; j >= 0 ; j--){
                boolean firstMatch = i < sa.length && ( sa[i] == pa[j] || pa[j] == '.');
                if (j + 1 < pa.length && pa[j+1] == '*'){
                    dp[i][j] = dp[i][j+2] || firstMatch && dp[i+1][j];
                } else {
                    dp[i][j] = firstMatch && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
