package gelato.algos;

import java.util.Arrays;

public class RegexMatch {
    //正则匹配
    /**    1: 如果pattern[j-1] != str[i] && pattern[j-1] != '.', 此时dp[i][j] = dp[i][j-2] //a*匹配0次
     2: 如果pattern[j-1] == str[i] || pattern[j-1] == '.'
     此时dp[i][j] = dp[i][j-2] // a*匹配0次
     或者 dp[i][j] = dp[i][j-1] // a*匹配1次
     或者 dp[i][j] = dp[i-1][j] // a*匹配多次****/
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return true;
        }
        boolean f[][] = new boolean[str.length + 1][pattern.length + 1]; //用0来表示空串, 因为空串是可以用来匹配的
        for (int i = 0; i < str.length; i++) {
            Arrays.fill(f[i], false);
        }
        f[0][0] = true;
        boolean matched = false || (str.length == 0 && pattern.length == 0);
        for (int i = 0; i <= str.length; i++) {
            for (int j = 1; j <= pattern.length; j++) {
                if (pattern[j - 1] == '*') {
                    f[i][j] = f[i][j - 1]
                            || (i > 0 && (f[i - 1][j - 1] || f[i - 1][j]) && (str[i - 1] == pattern[j - 2] || pattern[j - 2] == '.'))
                            || (j >= 2 && f[i][j - 2]);
                } else if (pattern[j - 1] == '.') {
                    f[i][j] = i > 0 && f[i - 1][j - 1];
                } else {
                    f[i][j] = i > 0 && f[i - 1][j - 1] && str[i - 1] == pattern[j - 1];
                }
                if (f[i][j] && i == str.length && j == pattern.length) {
                    matched = true;
                    break;
                }
            }
            if (matched) {
                break;
            }
        }
        return matched;
    }
}
