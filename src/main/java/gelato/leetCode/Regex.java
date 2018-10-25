package gelato.leetCode;

import java.util.Arrays;

public class Regex {
    //recursive solution
    public boolean isMatch(String s, String p) {
        char[] sa = s.toCharArray();
        char[] pa = p.toCharArray();
        return isMatch(sa, pa);
    }

    private boolean isMatch(char[] sa, char[] pa) {
        boolean result = false;
        int i = sa.length - 1, j = pa.length - 1;
        while (true) {
            if (i == -1 && j == -1) {
                result = true;
                break;
            } else if (i >= 0 && j >= 0 && pa[j] != '*') {
                if (pa[j] == '.' || pa[j] == sa[i]) {
                    i--;
                    j--;
                } else {
                    break;
                }
            } else if (j >= 0 && pa[j] == '*') {
                if(i == -1 || (pa[j - 1] != sa[i] && pa[j - 1] != '.')) {
                    j -= 2;
                } else {
                    int count = 1;
                    if(pa[j - 1] != '.') {
                        while (i - count >= 0 && sa[i - count] == sa[i]) count++;
                    }else{
                        count = i + 1;
                    }
                    for (int k = 0; k <= count; k++) {
                        boolean resIn = isMatch(Arrays.copyOfRange(sa, 0, i - k + 1), Arrays.copyOfRange(pa, 0, j - 2 + 1));
                        if (resIn) {
                            result = resIn;
                            break;
                        }
                    }
                    break;
                }
            } else {
                break;
            }
        }
        return result;
    }
}
